package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.HomePage;
import pages.MyAccountPage;
import pages.LoginPage;

public class ComprasStep {

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	MyAccountPage minhaConta = new MyAccountPage();
	
	@Dado("que esteja logado na pagina inicial")
	public void que_esteja_logado_na_pagina_inicial() {
		home.acessarLogin();
		login.loginComDadosValidos("automatomati@gmail.com", "12345");
		minhaConta.validarMensagemWelcome();
		home.voltarParaHome();
	}

	@Dado("adicione {string} ao carrinho")
	public void adicione_ao_carrinho(String nomeDoProduto) {
		home.clickBtnAddToCart(nomeDoProduto);
		home.validarItemAdicionadoCarrinho();
	}

	@Quando("prosseguir com a compra ate o checkout")
	public void prosseguir_com_a_compra_ate_o_checkout() {
		
	}

	@Entao("a compra e realizada com sucesso")
	public void a_compra_e_realizada_com_sucesso() {
		
	}
}
