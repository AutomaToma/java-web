package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.HomePage;

public class LoginStep {

	HomePage home = new HomePage();

	@Dado("que abra o site e va ate a pagina de login")
	public void que_abra_o_site_e_va_ate_a_pagina_de_login() throws InterruptedException {
	
		home.acessarUrl();
		home.validarAcesso();
		home.acessarLogin();
		Thread.sleep(5000);
	}

	@Dado("que esteja na pagina de login")
	public void que_esteja_na_pagina_de_login() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Quando("inserir usuario e senha corretamente")
	public void inserir_usuario_e_senha_corretamente() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Entao("o login eh validado com sucesso")
	public void o_login_eh_validado_com_sucesso() {
		// Write code here that turns the phrase above into concrete actions
	}
}
