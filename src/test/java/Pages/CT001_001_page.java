package Pages;

import Core.BasePage;
import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class CT001_001_page  {


    BasePage basepage1 = new BasePage();

    public void EntrarSite(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://pt.anotepad.com/");
    }

    public void Titulo(){
        basepage1.TituloDaPagina("//*[@id=\"edit_title\"]","CT001.001- Cliente habilitado para obter empréstimo ");
    }

    public void ChequeSemFundo() throws IOException {

        String chequeSemFundo = basepage1.EscolherLinhaEColunaDaPlanilha(1, 0);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente nunca emitiu cheques sem fundo.  ", chequeSemFundo);
        System.out.println("CT001_001 cliente nunca emitiu cheque sem fundo");
        Assert.assertEquals("Verdadeiro",chequeSemFundo);



    }

    public void Restricoes() throws IOException {

        String semrestricoes = basepage1.EscolherLinhaEColunaDaPlanilha(1,1);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","não constam restrições nos sistemas    ",semrestricoes);
        System.out.println("CT001_001 cliente não possui restrições");
        Assert.assertEquals("Verdadeiro",semrestricoes);


    }

    public void RendaComp() throws IOException {

        String rendacomprovada = basepage1.EscolherLinhaEColunaDaPlanilha(1,2);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","cliente possui uma renda comprovada    ",rendacomprovada);
        System.out.println("CT001_001 cliente possui uma renda comprovada");
        Assert.assertEquals("Verdadeiro",rendacomprovada);


    }

    public void ChequeEsp() throws IOException {
        String chequeEpecial = basepage1.EscolherLinhaEColunaDaPlanilha(1,3);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","cliente não esta usando cheque especial   ",chequeEpecial);
        System.out.println("CT001_001 cliente não esta usando cheque especial");
        Assert.assertEquals("Verdadeiro",chequeEpecial);

    }

    public void CartaoRotativo() throws IOException {

        String cartaoRotativo = basepage1.EscolherLinhaEColunaDaPlanilha(1,4);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","cliente não esta usando cartão rotativo superior R$ 2.500,00    ", cartaoRotativo);
        System.out.println("CT001_001 cliente não esta usando cartao rotativo com valor de R$ 2.500,00");
        Assert.assertEquals("Verdadeiro",cartaoRotativo);

    }
    public void ContaAtiva2anos() throws IOException {

        String contamaisde2anos = basepage1.EscolherLinhaEColunaDaPlanilha(1, 5);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]", "cliente não esta usando cartão rotativo superior R$ 2.500,00     ", contamaisde2anos);
        System.out.println("CT001_001 cliente possui conta ativa maior que 2 anos ");
        Assert.assertEquals("Verdadeiro",contamaisde2anos);

    }

    public void VerificacaoCliente() throws IOException {
        String verificacaodeelegibilidade = basepage1.EscolherLinhaEColunaDaPlanilha(1,6);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente está habilitado a  pegar o empréstimo ?    ",verificacaodeelegibilidade);
        System.out.println("CT001_001 cliente esta apto a receber o empréstimo");
        Assert.assertEquals("sim",verificacaodeelegibilidade);



    }

    public void Status() throws IOException {

        String Status = basepage1.EscolherLinhaEColunaDaPlanilha(1,7);
        basepage1.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","Empréstimo.     ", Status);
        System.out.println("CT001_001 empréstimo autorizado");
        Assert.assertEquals("Concedido",Status);

    }


    public void screenshot() throws IOException {
        File pasta = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String nomePasta = "screenshot" + System.currentTimeMillis() + ".jpg";
        File CriarPastaNoTarget = new File("target/screenshot/CT001_001");
        if (!CriarPastaNoTarget.exists()) {
            CriarPastaNoTarget.mkdir();
        }
        File pastaTarget = new File(CriarPastaNoTarget, nomePasta);
        FileUtils.copyFile(pasta, pastaTarget);
    }




    public void Sair() throws InterruptedException {
        Thread.sleep(5000);
        DriverFactory.quitDriver();

    }









}
