package Steps;

import Pages.CT006_001_page;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class CT006_001_Cliente_não_esta_usando_cartao_rotativo{

    CT006_001_page Ct006_page = new CT006_001_page();


    // @Ct006-001 Linha 6 , coluna 4
    @Dado("^que o Cliente não esta usando cartao rotativo com o valor superior a R\\$ (\\d+)\\.(\\d+),(\\d+)$")
    public void queOClienteNãoEstaUsandoCartaoRotativoComOValorSuperiorAR$(int arg1, int arg2, int arg3) throws IOException {
        Ct006_page.EntrarSite();
        Ct006_page.Titulo();
        Ct006_page.CartaoRotativo();
    }




    // @Ct006-001 Linha 6 , coluna 6
    @Quando("^é verificado os requisitos de elegibilidade do cliente\\.\\.\\.$")
    public void éVerificadoOsRequisitosDeElegibilidadeDoCliente() throws IOException {
        Ct006_page.VerificacaoCliente();
    }



    // @Ct006-001 Linha 6 , coluna 7
    @Então("^o funcionário do banco informa ao cliente que ele  não esta habilitado   para obter o empréstimo devido ter  cartao rotativo com o valor superior a R\\$ (\\d+)\\.(\\d+),$")
    public void oFuncionárioDoBancoInformaAoClienteQueEleNãoEstaHabilitadoParaObterOEmpréstimoDevidoTerCartaoRotativoComOValorSuperiorAR$(int arg1, int arg2) throws IOException, InterruptedException {
       Ct006_page.Status();
       Ct006_page.screenshot();
       Ct006_page.Sair();
    }

}
