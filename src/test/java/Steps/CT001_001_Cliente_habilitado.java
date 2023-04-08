package Steps;


import Pages.CT001_001_page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;


public class CT001_001_Cliente_habilitado {



    CT001_001_page Ct001_page = new CT001_001_page();


    // @Ct001-001 Linha 1 , coluna 0
    @Dado("^que o cliente nunca emitiu cheques sem fundo$")
    public void queOClienteNuncaEmitiuChequesSemFundo() throws IOException {
        Ct001_page.EntrarSite();
        Ct001_page.Titulo();
        Ct001_page.ChequeSemFundo();


    }
    // @Ct001-001  Linha 1 , coluna 1
    @Dado("^que não constam restrições nos sistemas$")
    public void que_não_constam_restrições_nos_sistemas() throws IOException {
        Ct001_page.Restricoes();

    }
    // @Ct001-001 Linha 1 , coluna 2
    @Dado("^que o cliente possui uma renda comprovada de R\\$ (\\d+)\\.(\\d+),(\\d+)$")
    public void que_o_cliente_possui_uma_renda_comprovada_de_R$(int arg1, int arg2, int arg3) throws IOException {
        Ct001_page.RendaComp();

    }


    // @Ct001-001 Linha 1 , coluna 3
    @Dado("^que o cliente não está usando cheque especial$")
    public void que_o_cliente_não_está_usando_cheque_especial() throws IOException {
        Ct001_page.ChequeEsp();

    }

    // @Ct001-001  Linha 1 , coluna 4
    @Dado("^que o cliente não esta usando cartão rotativo superior a  R\\$ (\\d+)\\.(\\d+),(\\d+)$")
    public void que_o_cliente_não_esta_usando_cartão_rotativo_superior_a_R$(int arg1, int arg2, int arg3) throws IOException {
        Ct001_page.CartaoRotativo();

    }

    // @Ct001-001 Linha 1 , coluna 5
    @Dado("^que o possui conta ativa mais de dois anos$")
    public void que_o_possui_conta_ativa_mais_de_dois_anos() throws IOException {

        Ct001_page.ContaAtiva2anos();

    }


    // @Ct001-001  Linha 1 , coluna 6
    @Quando("^é verificado os requisitos de elegibilidade do cliente$")
    public void éVerificadoOsRequisitosDeElegibilidadeDoCliente() throws IOException {

        Ct001_page.VerificacaoCliente();


    }

    //  Ct001-001 Linha 1 , coluna 7
    @Então("^o banco autoriza a solicitação de empréstimo$")
    public void o_banco_autoriza_a_solicitação_de_empréstimo() throws IOException, InterruptedException {
        Ct001_page.Status();
        Ct001_page.screenshot();
        Ct001_page.Sair();


    }


}






