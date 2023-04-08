package Steps;

import Pages.CT003_001_page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class CT003_001_Cliente_não_possui_uma_conta_corrente_ativa_no_banco {


    CT003_001_page Ct003_page = new CT003_001_page();


    // @Ct003-001 Linha 3 , coluna 5
    @Dado("^que o cliente não possui uma conta corrente ativa a mais de (\\d+) anos$")
    public void queOClienteNãoPossuiUmaContaCorrenteAtivaAMaisDeAnos(int arg1) throws IOException {
        Ct003_page.EntrarSite();
        Ct003_page.Titulo();
        Ct003_page.ContaAtiva2anos();

    }


    // @Ct003-001 Linha 3 , coluna 6
    @Quando("^o funcionário do banco verifica os requisitos$")
    public void oFuncionárioDoBancoVerificaOsRequisitos() throws IOException {

        Ct003_page.VerificacaoCliente();
    }


    // @Ct003-001 Linha 3 , coluna 7
    @Então("^o funcionário do banco solicita que o cliente abra uma conta  ou espere ate atingir o prazo mínimo\\.$")
    public void oFuncionárioDoBancoSolicitaQueOClienteAbraUmaContaOuEspereAteAtingirOPrazoMínimo() throws IOException, InterruptedException {
        Ct003_page.Status();
        Ct003_page.screenshot();
        Ct003_page.Sair();


    }

}
