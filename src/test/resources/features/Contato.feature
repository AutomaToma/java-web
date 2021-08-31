#language:pt

Funcionalidade: Realizar contato com suporte

  @AUT-06
  Cenario: Enviar email para o suporte
    Dado que esteja logado na pagina inicial
    Quando acessar a página de contato
    E preencher os campos com:
      | subject_heading | Customer service       |
      | order_reference | YEZIJWCBY - 08/25/2021 |
      | message         | Teste de email         |
    E enviar o email
    Entao deve ser apresentado a mensagem "Your message has been successfully sent to our team."