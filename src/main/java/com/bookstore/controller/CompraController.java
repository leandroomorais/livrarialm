package com.bookstore.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.model.FaturamentoEndereco;
import com.bookstore.model.CarroItem;
import com.bookstore.model.Pedido;
import com.bookstore.model.Pagamento;
import com.bookstore.model.RemessaEndereco;
import com.bookstore.model.CarroCompra;
import com.bookstore.model.User;
import com.bookstore.model.UserFaturamento;
import com.bookstore.model.UserPagamento;
import com.bookstore.model.UserRemessa;
import com.bookstore.service.FaturamentoEnderecoService;
import com.bookstore.service.CarroItemService;
import com.bookstore.service.PedidoService;
import com.bookstore.service.PagamentoService;
import com.bookstore.service.RemessaEnderecoService;
import com.bookstore.service.CarroCompraService;
import com.bookstore.service.UserPagamentoService;
import com.bookstore.service.UserService;
import com.bookstore.service.UserRemessaService;
import com.bookstore.utility.MailConstructor;
import com.bookstore.utility.BRConstants;

@Controller
public class CompraController {

	private RemessaEndereco remessaEndereco = new RemessaEndereco();
	private FaturamentoEndereco faturamentoEndereco = new FaturamentoEndereco();
	private Pagamento payment = new Pagamento();

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private UserService userService;

	@Autowired
	private CarroItemService carroItemService;
	
	@Autowired
	private CarroCompraService carroCompraService;

	@Autowired
	private RemessaEnderecoService remessaEnderecoService;

	@Autowired
	private FaturamentoEnderecoService faturamentoEnderecoService;

	@Autowired
	private PagamentoService pagamentoService;

	@Autowired
	private UserRemessaService userRemessaService;

	@Autowired
	private UserPagamentoService userPagamentoService;
	
	@Autowired
	private PedidoService pedidoService;

	@RequestMapping("/checkout")
	public String checkout(@RequestParam("id") Long cartId,
			@RequestParam(value = "missingRequiredField", required = false) boolean missingRequiredField, Model model,
			Principal principal) {
		User user = userService.findByUsername(principal.getName());

		if (cartId != user.getCarroCompra().getId()) {
			return "badRequestPage";
		}

		List<CarroItem> carroItemList = carroItemService.findByCarroCompra(user.getCarroCompra());

		if (carroItemList.size() == 0) {
			model.addAttribute("emptyCart", true);
			return "forward:/shoppintCart/cart";
		}

		for (CarroItem carroItem : carroItemList) {
			if (carroItem.getLivro().getInStockNumber() < carroItem.getQtd()) {
				model.addAttribute("notEnoughStock", true);
				return "forward:/shoppingCart/cart";
			}
		}

		List<UserRemessa> userRemessaList = user.getUserRemessaList();
		List<UserPagamento> userPagamentoList = user.getUserPagamentoList();

		model.addAttribute("userShippingList", userRemessaList);
		model.addAttribute("userPaymentList", userPagamentoList);

		if (userPagamentoList.size() == 0) {
			model.addAttribute("emptyPaymentList", true);
		} else {
			model.addAttribute("emptyPaymentList", false);
		}

		if (userRemessaList.size() == 0) {
			model.addAttribute("emptyShippingList", true);
		} else {
			model.addAttribute("emptyShippingList", false);
		}

		CarroCompra carroCompra = user.getCarroCompra();

		for (UserRemessa userRemessa : userRemessaList) {
			if (userRemessa.isUserRemessaPadrao()) {
				remessaEnderecoService.setByUserRemessa(userRemessa, remessaEndereco);
			}
		}

		for (UserPagamento userPagamento : userPagamentoList) {
			if (userPagamento.isPadraoPagamento()) {
				pagamentoService.setByUserPagamento(userPagamento, payment);
				faturamentoEnderecoService.setByUserFaturamento(userPagamento.getUserFaturamento(), faturamentoEndereco);
			}
		}

		model.addAttribute("shippingAddress", remessaEndereco);
		model.addAttribute("payment", payment);
		model.addAttribute("faturamentoEndereco", faturamentoEndereco);
		model.addAttribute("cartItemList", carroItemList);
		model.addAttribute("shoppingCart", user.getCarroCompra());

		List<String> stateList = BRConstants.listOfUSStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList", stateList);

		model.addAttribute("classActiveShipping", true);

		if (missingRequiredField) {
			model.addAttribute("missingRequiredField", true);
		}

		return "checkout";

	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkoutPost(@ModelAttribute("shippingAddress") RemessaEndereco remessaEndereco,
			@ModelAttribute("faturamentoEndereco") FaturamentoEndereco faturamentoEndereco, @ModelAttribute("payment") Pagamento pagamento,
			@ModelAttribute("billingSameAsShipping") String faturamentoSEndereco,
			@ModelAttribute("shippingMethod") String remessaMetodo, Principal principal, Model model) {
		CarroCompra carroCompra = userService.findByUsername(principal.getName()).getCarroCompra();

		List<CarroItem> cartItemList = carroItemService.findByCarroCompra(carroCompra);
		model.addAttribute("cartItemList", cartItemList);

		if (faturamentoSEndereco.equals("true")) {
			faturamentoEndereco.setFaturamentoEnderecoNome(remessaEndereco.getRemessaEnderecoNome());
			faturamentoEndereco.setFaturamentoEnderecoRua(remessaEndereco.getRemessaEnderecoRua());
			faturamentoEndereco.setFaturamentoEnderecoCidade(remessaEndereco.getRemessaEnderecoCidade());
			faturamentoEndereco.setFaturamentoEnderecoEstado(remessaEndereco.getRemessaEnderecoEstado());
			faturamentoEndereco.setFaturamentoEnderecoCep(remessaEndereco.getRemessaEnderecoCep());
		}

		
		User user = userService.findByUsername(principal.getName());
		
		Pedido pedido = pedidoService.criarPedido(carroCompra, remessaEndereco, faturamentoEndereco, pagamento, remessaMetodo, user);
		
		mailSender.send(mailConstructor.constructOrderConfirmationEmail(user, pedido, Locale.ENGLISH));
		
		carroCompraService.limpaCarroCompra(carroCompra);
		
		LocalDate hoje = LocalDate.now();
		LocalDate dataEntregaEstimada;
		
		if (remessaMetodo.equals("groundShipping")) {
			dataEntregaEstimada = hoje.plusDays(5);
		} else {
			dataEntregaEstimada = hoje.plusDays(3);
		}
		
		model.addAttribute("estimatedDeliveryDate", dataEntregaEstimada);
		
		return "orderSubmittedPage";
	}
//
//	@RequestMapping("/setShippingAddress")
//	public String setShippingAddress(@RequestParam("userShippingId") Long userShippingId, Principal principal,
//			Model model) {
//		User user = userService.findByUsername(principal.getName());
//		UserRemessa userShipping = userRemessaService.findById(userShippingId);
//
//		if (userShipping.getUser().getId() != user.getId()) {
//			return "badRequestPage";
//		} else {
//			remessaEnderecoService.setByUserShipping(userShipping, shippingAddress);
//
//			List<CarroItem> cartItemList = carroItemService.findByShoppingCart(user.getShoppingCart());
//
//			model.addAttribute("shippingAddress", shippingAddress);
//			model.addAttribute("payment", payment);
//			model.addAttribute("faturamentoEndereco", faturamentoEndereco);
//			model.addAttribute("cartItemList", cartItemList);
//			model.addAttribute("shoppingCart", user.getShoppingCart());
//
//			List<String> stateList = BRConstants.listOfUSStatesCode;
//			Collections.sort(stateList);
//			model.addAttribute("stateList", stateList);
//
//			List<UserRemessa> userShippingList = user.getUserShippingList();
//			List<UserPagamento> userPaymentList = user.getUserPaymentList();
//
//			model.addAttribute("userShippingList", userShippingList);
//			model.addAttribute("userPaymentList", userPaymentList);
//
//			model.addAttribute("shippingAddress", shippingAddress);
//
//			model.addAttribute("classActiveShipping", true);
//
//			if (userPaymentList.size() == 0) {
//				model.addAttribute("emptyPaymentList", true);
//			} else {
//				model.addAttribute("emptyPaymentList", false);
//			}
//
//			model.addAttribute("emptyShippingList", false);
//
//			return "checkout";
//		}
//	}
//
//	@RequestMapping("/setPaymentMethod")
//	public String setPaymentMethod(@RequestParam("userPaymentId") Long userPaymentId, Principal principal,
//			Model model) {
//		User user = userService.findByUsername(principal.getName());
//		UserPagamento userPayment = userPagamentoService.findById(userPaymentId);
//		UserFaturamento userBilling = userPayment.getUserBilling();
//
//		if (userPayment.getUser().getId() != user.getId()) {
//			return "badRequestPage";
//		} else {
//			pagamentoService.setByUserPayment(userPayment, payment);
//
//			List<CarroItem> cartItemList = carroItemService.findByShoppingCart(user.getShoppingCart());
//
//			faturamentoEnderecoService.setByUserBilling(userBilling, faturamentoEndereco);
//
//			model.addAttribute("shippingAddress", shippingAddress);
//			model.addAttribute("payment", payment);
//			model.addAttribute("faturamentoEndereco", faturamentoEndereco);
//			model.addAttribute("cartItemList", cartItemList);
//			model.addAttribute("shoppingCart", user.getShoppingCart());
//
//			List<String> stateList = BRConstants.listOfUSStatesCode;
//			Collections.sort(stateList);
//			model.addAttribute("stateList", stateList);
//
//			List<UserRemessa> userShippingList = user.getUserShippingList();
//			List<UserPagamento> userPaymentList = user.getUserPaymentList();
//
//			model.addAttribute("userShippingList", userShippingList);
//			model.addAttribute("userPaymentList", userPaymentList);
//
//			model.addAttribute("shippingAddress", shippingAddress);
//
//			model.addAttribute("classActivePayment", true);
//
//			model.addAttribute("emptyPaymentList", false);
//
//			if (userShippingList.size() == 0) {
//				model.addAttribute("emptyShippingList", true);
//			} else {
//				model.addAttribute("emptyShippingList", false);
//			}
//
//			return "checkout";
//		}
//	}

}
