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
      | produto                     | quantidade | cor    | tamanho | pagamento |
      | Faded Short Sleeve T-shirts | 1          | Blue   | M       | bankwire  |
      | Printed Dress               | 1          | Orange | L       | cheque    |
