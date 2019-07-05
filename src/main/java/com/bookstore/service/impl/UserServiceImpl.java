package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.CarroCompra;
import com.bookstore.model.User;
import com.bookstore.model.UserFaturamento;
import com.bookstore.model.UserPagamento;
import com.bookstore.model.UserRemessa;
import com.bookstore.model.security.PasswordResetToken;
import com.bookstore.model.security.UserRole;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}
	
	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public User findById(Long id){
		return userRepository.findOne(id);
	}
	
	@Override
	public User findByEmail (String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles){
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			CarroCompra carroCompra = new CarroCompra();
			carroCompra.setUser(user);
			user.setCarroCompra(carroCompra);
			user.setUserRemessaList(new ArrayList<UserRemessa>());
			user.setUserPagamentoList(new ArrayList<UserPagamento>());
			
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void updateUserBilling(UserFaturamento userBilling, UserPagamento userPayment, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserShipping(UserRemessa userShipping, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserDefaultShipping(Long userShippingId, User user) {
		// TODO Auto-generated method stub
		
	}

}
