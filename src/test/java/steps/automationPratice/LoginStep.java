package steps.automationPratice;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.automationPratice.HomePage;
import pages.automationPratice.MyAccountPage;
import pages.automationPratice.LoginPage;

public class LoginStep {

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	MyAccountPage minhaConta = new MyAccountPage();

	@Dado("que abra o site e va ate a pagina de login")
	public void que_abra_o_site_e_va_ate_a_pagina_de_login() throws InterruptedException {
	
//		home.acessarUrl();
		home.validarAcesso();
		home.acessarLogin();
	}

	@Dado("que esteja na pagina de login")
	public void que_esteja_na_pagina_de_login() {
		login.validarSignInPage();
	}

	@Quando("inserir usuario e senha corretamente")
	public void inserir_usuario_e_senha_corretamente() {
		login.loginComDadosValidos("automatomati@gmail.com", "12345");
	}

	@Entao("o login eh validado com sucesso")
	public void o_login_eh_validado_com_sucesso() {
		minhaConta.validarMinhaConta();
		minhaConta.validarMensagemWelcome();
	}

	@Quando("inserir usuario e senha corretamente da planilha")
	public void inserir_usuario_e_senha_corretamente_da_planilha() {
		login.loginComDadosDaPlanilha();
	}


}
