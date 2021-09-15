package steps.automationPratice;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;
import pages.automationPratice.ContactPage;

public class ContatoStep {

    private ContactPage contato = new ContactPage();

    @Quando("acessar a pagina de contato")
    public void acessarAPaginaDeContato() {
        contato.acessarPaginaDeContato();
        contato.validarTelaContato();
    }

    @Quando("preencher os campos com:")
    public void preencherOsCamposCom(DataTable dataTable) {
        contato.preencherDadosDeContato(dataTable);
    }

    @Quando("enviar o email")
    public void enviarOEmail() {
        contato.enviarMensagem();
    }

    @Entao("deve ser apresentado a mensagem {string}")
    public void deveSerApresentadoAMensagem(String mensagem) {
        contato.validarMensagemDeSucesso(mensagem);
    }

}
