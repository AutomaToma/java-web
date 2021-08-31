package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import beans.ValuesHelper;

import static org.junit.Assert.*;
import static config.Driver.getDriver;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    static ValuesHelper values = new ValuesHelper();

    @FindBy(id = "total_product")
    private WebElement lblTotalProdutos;

    @FindBy(id = "total_price")
    private WebElement lblValorTotal;

    @FindBy(id = "total_shipping")
    private WebElement lblValorFrete;

    @FindBy(xpath = "(//span[contains(text(), 'Proceed to checkout')])[2]")
    private WebElement btnProcederCheckout;

    @FindBy(xpath = "//h3[text() = 'Your delivery address']")
    private WebElement titEnderecoEntrega;

    @FindBy(xpath = "//ul[@id='address_delivery']//li")
    private List<WebElement> listaEnderecoEntrega;

    @FindBy(id = "id_address_delivery")
    private WebElement selectEndereco;

    @FindBy(xpath = "//p[@class='carrier_title' and contains(text(), 'address')]")
    private WebElement tituloTransporte;

    @FindBy(id = "cgv")
    private WebElement checkboxTermosEntrega;

    @FindBy(xpath = "//div[@class = 'delivery_option_price']")
    private WebElement valorEntregaShipping;

    @FindBy(className = "page-heading")
    private WebElement tituloPedidoPage;

    @FindBy(xpath = "//div[@class='box cheque-box']//p/span[@class='price']")
    private WebElement spanValorTotalConfirmacaoPedido;

    @FindBy(xpath = "//span[text()='I confirm my order']/../../button")
    private WebElement buttonConfirmarPedido;

    @FindBy(className = "cheque-indent")
    private WebElement textoCompraComSucessoTransferencia;

    @FindBy(xpath = "//p[contains(text(), 'Your order on My Store is complete.')]")
    private WebElement textoCompraComSucessoCheque;

    // >>>> Variaveis globais <<<<

    private static String metodoPagamento = "";

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public void validarValoresPedido() {
        assertEquals(values.getValorProduto(), lblTotalProdutos.getText().replace("$", ""));
        assertEquals(values.getValorTotal(), lblValorTotal.getText().replace("$", "").replace(".", ","));
    }

    public boolean validadorEnderecoEntrega() {
        List<String> enderecoEntregaEsperado = new ArrayList<String>();
        int cont = 0;

        enderecoEntregaEsperado.add("YOUR DELIVERY ADDRESS");
        enderecoEntregaEsperado.add("AutomaToma Ti");
        enderecoEntregaEsperado.add("rua 1234t5 SUITE 421682");
        enderecoEntregaEsperado.add("South Salt Lake, Utah 84119");
        enderecoEntregaEsperado.add("United States");
        enderecoEntregaEsperado.add("+1 (572) 183-3681");
        enderecoEntregaEsperado.add("+55 11 999999999");

        for (int i = 0; i < listaEnderecoEntrega.size() - 1; i++) {
            if (listaEnderecoEntrega.get(i).getText().equals(enderecoEntregaEsperado.get(i))) {
                cont++;
            }
        }
        boolean validador = (cont == 7) ? true : false;
        return validador;
    }

    public void clicarProcederCheckout() {
        scrollDown();
        btnProcederCheckout.click();
    }

    public void validarEnderecoEntrega() {
        assertTrue(validadorEnderecoEntrega());
    }

    public void passoValidarCarrinho() {
        validarValoresPedido();
    }

    public void passoValidarEndereco() {
        validarEnderecoEntrega();
    }

    public void selecionarEndereco() {
        selecionarPrimeiro(selectEndereco);
        WebElement enderecoSelecionado = selectEndereco.findElement(By.xpath("//option[@selected='selected']"));
        values.setNomeEnderecoEntrega(enderecoSelecionado.getText());
    }

    public void validarEntrega() {
        assertEquals("casinha hmmm", tituloTransporte.getText().substring(43, 55));
        values.setValorFrete(valorEntregaShipping.getText().trim().replace("$", ""));
        aceitarTermosEnvio();
    }

    public void aceitarTermosEnvio() {
        checkboxTermosEntrega.click();
    }

    public void validarPagamento() {
        assertEquals(values.getValorProduto(), lblTotalProdutos.getText().trim().replace("$", ""));
        assertEquals(values.getValorFrete(), lblValorFrete.getText().trim().replace("$", ""));
        assertEquals(values.somarValorTotal(values.getValorProduto(), values.getValorFrete()), Float.parseFloat(lblValorTotal.getText().trim().replace("$", "")), 0.0f);
    }

    public void escolherMetodoDePagamento(String pagamento) {
        metodoPagamento = pagamento;

        System.out.println("PAGAMENTO SALVO: " + metodoPagamento);

        System.out.println("======\n Entrando na escolha de método de pagamento \n======");
        WebElement elemento = null;

        if (pagamento.equals("bankwire")) {
            System.out.println("======\n Escolhido transferência bancária \n======");
            elemento = getDriver().findElement(By.xpath("//a[@class='" + pagamento + "']"));
            elemento.click();
        } else {
            System.out.println("======\n Escolhido cheque \n======");
            elemento = getDriver().findElement(By.xpath("//a[@class='" + pagamento + "']"));
            elemento.click();
        }
    }


    public void confirmarPedido() {
        Assert.assertEquals("ORDER SUMMARY".trim(), tituloPedidoPage.getText().trim());
        Assert.assertEquals(String.valueOf(values.getValorTotal().replace(",", ".")), spanValorTotalConfirmacaoPedido.getText().replace("$", "").trim());
        buttonConfirmarPedido.click();
    }

    public void confirmarFinalizacaoDaCompra() {
        Assert.assertEquals("ORDER CONFIRMATION".trim(), tituloPedidoPage.getText().trim());

        if (metodoPagamento.equals("bankwire")) {
            Assert.assertEquals("Your order on My Store is complete.".trim(), textoCompraComSucessoTransferencia.getText().trim());
        } else {
            Assert.assertEquals("Your order on My Store is complete.".trim(), textoCompraComSucessoCheque.getText().trim());
        }

    }

}

