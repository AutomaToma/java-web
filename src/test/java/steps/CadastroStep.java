package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;
import pages.HomePage;

public class CadastroStep {

	HomePage home = new HomePage();
	CadastroPage cadastro = new CadastroPage();

	@Dado("que eu esteja na pagina de cadastro")
	public void que_eu_esteja_na_pagina_de_cadastro() throws InterruptedException {
		cadastro.validarPagCadastro();
		cadastro.inserirEmail("brunorabelosimoes@gmail.com");
		cadastro.cliqueBtnCriarConta();
		cadastro.validarInfoPessoal();
		Thread.sleep(3000);

	}

	@Quando("realizo meu cadastro com os dados corretos")
	public void realizo_meu_cadastro_com_os_dados_corretos() {

	}

	@Entao("o cadastro e realizado com sucesso")
	public void o_cadastro_e_realizado_com_sucesso() {

	}

}
