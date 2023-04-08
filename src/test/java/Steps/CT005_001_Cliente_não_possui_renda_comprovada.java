package Steps;

import Pages.CT005_001_page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class CT005_001_Cliente_não_possui_renda_comprovada {

    CT005_001_page Ct005_page = new CT005_001_page();


    // @Ct005-001 Linha 5 , coluna 2
    @Dado("^que o cliente não possui renda comprovada de no mínimo R\\$ (\\d+)\\.(\\d+),(\\d+)$")
    public void queOClienteNãoPossuiRendaComprovadaDeNoMínimoR$(int arg1, int arg2, int arg3) throws IOException {
        Ct005_page.EntrarSite();
        Ct005_page.Titulo();
        Ct005_page.RendaComp();
    }


    // @Ct005-001 Linha 5 , coluna 6
    @Quando("^é verificado os requisitos de elegibilidade do cliente\\.$")
    public void éVerificadoOsRequisitosDeElegibilidadeDoCliente() throws IOException {
        Ct005_page.VerificacaoCliente();
    }



    // @Ct005-001 Linha 5 , coluna 7
    @Então("^o funcionário do banco deve informar ao cliente que ele não esta habilitado para obter o empréstimo devido não ter renda sufiuciente$")
    public void oFuncionárioDoBancoDeveInformarAoClienteQueEleNãoEstaHabilitadoParaObterOEmpréstimoDevidoNãoTerRendaSufiuciente() throws IOException, InterruptedException {
        Ct005_page.Status();
        Ct005_page.screenshot();
        Ct005_page.Sair();
    }


}
