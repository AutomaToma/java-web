package pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static config.Driver.getDriver;

public class ContactPage extends BasePage {

    public ContactPage() {
        PageFactory.initElements(getDriver(), this);
    }

    // =========== MAPEAMENTO ===========

    @FindBy(xpath = "//a[@title='Contact Us']")
    private WebElement linkContato;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    private WebElement tituloContatoPagina;

    @FindBy(id = "id_contact")
    private WebElement selectAssunto;

    @FindBy(name = "id_order")
    private WebElement selectPedido;

    @FindBy(xpath = "//div[@class='selector']/select[@name='id_product']")
    private WebElement selectProduto;

    @FindBy(xpath = "//div[@class='form-group']/textarea")
    private WebElement campoMensagem;

    @FindBy(id = "submitMessage")
    private WebElement btnEnviarMensagem;

    @FindBy(xpath = "//div[@id='center_column']/p")
    private WebElement mensagemSucesso;


    // =========== METÓDOS (AÇÕES) ===========

    public void acessarPaginaDeContato() {
        linkContato.click();
    }

    public void validarTelaContato() {
        Assert.assertEquals("CUSTOMER SERVICE - CONTACT US", tituloContatoPagina.getText());
    }

    public void preencherDadosDeContato(DataTable dataTable) {
        List<List<String>> tabela = dataTable.asLists();

        /** >>>>>>>>>  EXEMPLO DataTable  <<<<<<<<<
         *  chave = coluna        valor = coluna
         *       0                  1
         0  | subject_heading | Customer service                                |
         1  | order_reference | YEZIJWCBY - 08/25/2021                          |
         2  | product         | Printed Summer Dress - Color : Yellow, Size : S |
         3  | message         | Teste de email                                  |
         */

        //inserindo os dados do DataTable
        selecionarPorTexto(selectAssunto, tabela.get(0).get(1));
        selecionarPorTexto(selectPedido, tabela.get(1).get(1));
        pietro(2000);
        selecionarPorTexto(selectProduto, tabela.get(2).get(1));
        campoMensagem.sendKeys(tabela.get(3).get(1));
    }

    public void enviarMensagem() {
        btnEnviarMensagem.click();
    }

    public void validarMensagemDeSucesso(String mensagem) {
        Assert.assertEquals(mensagem, mensagemSucesso.getText());
    }

}
