package steps.automationPratice;

import java.util.Random;

import com.github.javafaker.Faker;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.automationPratice.RegisterPage;
import pages.automationPratice.HomePage;
import pages.automationPratice.LoginPage;

public class CadastroStep {

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	RegisterPage cadastro = new RegisterPage();
	Faker faker = new Faker();

	//Gerar numero randomico
	Random random = new Random();
	int numeroRandom = random.nextInt(10000);
	
	String email = faker.elderScrolls().firstName() + numeroRandom + "@gmail.com";

	@Dado("que eu esteja na pagina de cadastro")
	public void que_eu_esteja_na_pagina_de_cadastro() throws InterruptedException {
		home.acessarLogin();
		cadastro.validarPagCadastro();
		cadastro.inserirEmail(email);
		cadastro.cliqueBtnCriarConta();
		cadastro.validarInfoPessoal();
		Thread.sleep(3000);

	}

	@Quando("realizo meu cadastro com os dados corretos")
	public void realizo_meu_cadastro_com_os_dados_corretos() {
		cadastro.realizarCadastro("Bruno", "Sim�es", email, "123456", "1", "1", "1986", "Bruno",
				"Sim�es", "AutomaToma", "Rua Teste", "Teste City", "New York", "14925", "United States", "Teste",
				"9922222222", "9911111111", "Bruno Casa");
	}

	@Entao("o cadastro e realizado com sucesso")
	public void o_cadastro_e_realizado_com_sucesso() {
		cadastro.validarContaCriada();
	}

}
