package steps.automationPratice;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.automationPratice.ComprasPage;
import pages.automationPratice.HomePage;
import pages.automationPratice.MyAccountPage;
import pages.automationPratice.OrderPage;
import pages.automationPratice.LoginPage;

import java.util.List;

public class ComprasStep {

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	MyAccountPage minhaConta = new MyAccountPage();
	ComprasPage comprasPage = new ComprasPage();
	OrderPage order = new OrderPage();
	
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
		order.passoValidarCarrinho();
		order.clicarProcederCheckout();
		order.passoValidarEndereco();
		order.clicarProcederCheckout();
		order.validarEntrega();
		order.clicarProcederCheckout();
	}

	@Entao("a compra e realizada com sucesso")
	public void a_compra_e_realizada_com_sucesso() {
		order.validarPagamento();
		order.escolherMetodoDePagamento("bankwire");
		order.confirmarPedido();
		order.confirmarFinalizacaoDaCompra();
	}

	// >>>>>> CENARIO 2 <<<<<<

	@E("tenha escolhido o {string} e {int} com {string} e {string} para compra")
	public void tenha_escolhido_o_e_com_e_para_compra(String produto, Integer quantidade, String cor, String tamanho) throws Exception {
		home.clickBtnAddToCart(produto);
		comprasPage.validarInformacoesProduto(produto);
		comprasPage.inserirInformacoesDeCompra(quantidade, cor, tamanho);
		comprasPage.validarProdutoAdicionadoAoCarrinho(produto);
	}

	@E("validar o produto na tela de checkout")
	public void validar_o_produto_na_tela_de_checkout() {
		order.passoValidarCarrinho();
		order.clicarProcederCheckout();
	}

	@E("confirmar o endereco e opcao de entrega")
	public void confirmar_o_endereco_e_opcao_de_entrega() {
		order.passoValidarEndereco();
		order.clicarProcederCheckout();
		order.validarEntrega();
		order.clicarProcederCheckout();
	}

	@Quando("escolher a forma de pagamento {string} e finalizar a compra")
	public void escolher_a_forma_de_pagamento_e_finalizar_a_compra(String pagamento) {
		order.validarPagamento();
		order.escolherMetodoDePagamento(pagamento);
	}

	@Entao("a compra devera ser realizada com sucesso")
	public void a_compra_devera_ser_realizada_com_sucesso() {
		order.confirmarPedido();
		order.confirmarFinalizacaoDaCompra();
	}

}
