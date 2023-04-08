package Steps;

import Pages.CT004_001_page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class CT004_001_Cliente_nunca_emitiu_cheques_sem_fundo {

    CT004_001_page Ct004_page = new CT004_001_page();



    // @Ct004-001 Linha 4 , coluna 0
    @Dado("^quer o cliente nunca emitiu cheques sem fundo$")
    public void queroClienteNuncaEmitiuChequesSemFundo() throws IOException {
        Ct004_page.EntrarSite();
        Ct004_page.Titulo();
        Ct004_page.ChequeSemFundo();
    }




    // @Ct004-001 Linha 4 , coluna 6
    @Quando("^é verificado os requisitos de elegibilidade do cliente\\.\\.$")
    public void éVerificadoOsRequisitosDeElegibilidadeDoCliente() throws IOException {
        Ct004_page.VerificacaoCliente();

    }



    // @Ct004-001 Linha 3 , coluna 7
    @Então("^o funcionário do banco informa ao cliente que ele não esta habilitado para obter o empréstimo devido à emissão de cheques sem fundo$")
    public void oFuncionárioDoBancoInformaAoClienteQueEleNãoEstaHabilitadoParaObterOEmpréstimoDevidoÀEmissãoDeChequesSemFundo() throws IOException, InterruptedException {
        Ct004_page.Status();
        Ct004_page.screenshot();
        Ct004_page.Sair();
    }










}
