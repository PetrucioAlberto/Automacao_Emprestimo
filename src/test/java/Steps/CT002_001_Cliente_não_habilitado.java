package Steps;

import Pages.CT002_001_page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class CT002_001_Cliente_não_habilitado {

    CT002_001_page Ct002_page = new CT002_001_page();


    // @Ct002-001 Linha 2 , coluna 1
    @Dado("^que o cliente não atende a um ou mais requisitos de elegibilidade$")
    public void queOClienteNãoAtendeAUmOuMaisRequisitosDeElegibilidade() throws IOException {
        Ct002_page.EntrarSite();
        Ct002_page.Titulo();
        Ct002_page.Restricoes();

    }



    // @Ct002-001 Linha 2 , coluna 6
    @Quando("^o funcionário do banco verifica os requisitos de elegibilidade do cliente$")
    public void oFuncionárioDoBancoVerificaOsRequisitosDeElegibilidadeDoCliente() throws IOException {
        Ct002_page.VerificacaoCliente();
    }




    // @Ct002-001 Linha 2 , coluna 7
    @Então("^o banco informa ao cliente não estar habilitador para o empréstimo$")
    public void oBancoInformaAoClienteNãoEstarHabilitadorParaOEmpréstimo() throws IOException, InterruptedException {
        Ct002_page.Status();
        Ct002_page.screenshot();
        Ct002_page.Sair();

    }


}
