#language:pt

Funcionalidade: Validar o login
		Como usuário já cadastrado
		Quero realizar o login
	
	
Contexto: Realizar o login
		Dado que abra o site e va ate a pagina de login

  @AUT-01
  Cenario: Realizar o login com sucesso
    Dado que esteja na pagina de login
    Quando inserir usuario e senha corretamente
    Entao o login eh validado com sucesso

  @AUT-07
  Cenario: Realizar o login com sucesso utilizando massa via planilha
    Dado que esteja na pagina de login
    Quando inserir usuario e senha corretamente da planilha
    Entao o login eh validado com sucesso