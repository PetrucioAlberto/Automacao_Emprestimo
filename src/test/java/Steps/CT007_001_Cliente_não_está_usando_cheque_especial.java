package Steps;

import Pages.CT007_001_page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class CT007_001_Cliente_não_está_usando_cheque_especial {

    CT007_001_page Ct007_page = new CT007_001_page();



    // @Ct007 Linha 7 , coluna 3
    @Dado("^que o cliente não está usando cheque especial\\.$")
    public void queOClienteNãoEstáUsandoChequeEspecial() throws IOException {
        Ct007_page.EntrarSite();
        Ct007_page.EntrarSite();
        Ct007_page.ChequeEsp();
    }


    // @Ct007-001 Linha 7 , coluna 6
    @Quando("^é verificado os requisitos de elegibilidade do cliente\\.\\.\\.\\.$")
    public void éVerificadoOsRequisitosDeElegibilidadeDoCliente() throws IOException {
        Ct007_page.VerificacaoCliente();

    }


    // Ct007-001 Linha 7 , coluna 7
    @Então("^o funcionário do banco informa ao cliente que ele  não esta habilitado   para obter o empréstimo devido ter  cheque especial\\.$")
    public void oFuncionárioDoBancoInformaAoClienteQueEleNãoEstaHabilitadoParaObterOEmpréstimoDevidoTerChequeEspecial() throws IOException, InterruptedException {
        Ct007_page.Status();
        Ct007_page.screenshot();
        Ct007_page.Sair();
    }



}
