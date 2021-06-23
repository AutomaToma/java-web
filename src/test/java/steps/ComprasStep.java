package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.ComprasPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.LoginPage;

public class ComprasStep {

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	MyAccountPage minhaConta = new MyAccountPage();
	ComprasPage comprasPage = new ComprasPage();
	
	@Dado("que esteja logado na pagina inicial")
	public void que_esteja_logado_na_pagina_inicial() {
		home.acessarLogin();
		login.loginComDadosValidos("automatomati@gmail.com", "12345");
		minhaConta.validarMensagemWelcome();
		home.voltarParaHome();
	}

	@Dado("adicione {string} ao carrinho")
	public void adicione_ao_carrinho(String nomeDoProduto) throws Exception {
		home.clickBtnAddToCart(nomeDoProduto);
		comprasPage.validarInformacoesProduto(nomeDoProduto);
		comprasPage.inserirInformacoesDeCompra();
		comprasPage.validarProdutoAdicionadoAoCarrinho(nomeDoProduto);
	}

	@Quando("prosseguir com a compra ate o checkout")
	public void prosseguir_com_a_compra_ate_o_checkout() {
		
	}

	@Entao("a compra e realizada com sucesso")
	public void a_compra_e_realizada_com_sucesso() {
		
	}
}
