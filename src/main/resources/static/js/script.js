var atualizaCarrinho = function(){
	var carrinhos = $('.cart-list');
	carrinhos.each(function()){
		var carrinhoAtual = $(this);
		var valorItem = carrinhoAtual.find('.qty');
		var valorTotal = carrinhoAtual.find('.total');
		var resultado = 0;
		
		valorItem.each(function() {
			var tdAtual = $(this);
			var pegaValor = parseFloat(tdAtual.text());
			resultado = parseFloat(resultado + pegaValor);
			
		});
		
		valorTotal.text(resultado);
				
	}
}
	
