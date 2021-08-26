#language: pt

Funcionalidade: Realizar uma compra
  Como potencial ou atual cliente da loja
  Quero realizar uma compra
  Para ficar no estilo

  @AUT-04
  Cenario: Comprar uma peça logado
    Dado que esteja logado na pagina inicial
    E adicione "Blouse" ao carrinho
    Quando prosseguir com a compra ate o checkout
    Entao a compra e realizada com sucesso

  @AUT-05
  Esquema do Cenario: Comprar uma peça 2
    Dado que esteja logado na pagina inicial
    E tenha escolhido o "<produto>" e <quantidade> com "<cor>" e "<tamanho>" para compra
    E validar o produto na tela de checkout
    E confirmar o endereco e opcao de entrega
    Quando escolher a forma de pagamento "<pagamento>" e finalizar a compra
    Entao a compra devera ser realizada com sucesso
    Exemplos:
      | produto                     | quantidade | cor  | tamanho | pagamento |
      | Faded Short Sleeve T-shirts | 2          | Blue | M       | bankwire  |

  @AUT-06
  Cenario: Enviar email para o suporte
    Dado que esteja logado na pagina inicial
    Quando acessar a página de contato
    E preencher os campos com:
      | subject_heading | Customer service       |
      | order_reference | YEZIJWCBY - 08/25/2021 |
      | message         | Teste de email         |
    E enviar o email
    Então deve ser apresentado a mensagem "Your message has been successfully sent to our team."