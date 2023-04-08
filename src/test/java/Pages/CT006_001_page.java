package Pages;

import Core.BasePage;
import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CT006_001_page {
    BasePage basepage6 = new BasePage();

    public void EntrarSite(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://pt.anotepad.com/");
    }
    public void Titulo(){
        basepage6.TituloDaPagina("//*[@id=\"edit_title\"]","CT006_001 Empréstimo negado  (Usando cartao rotativo)");
    }

    public void CartaoRotativo() throws IOException {

        String cartaoRotativo = basepage6.EscolherLinhaEColunaDaPlanilha(6,4);
        basepage6.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","cliente não esta usando cartão rotativo superior R$ 2.500,00    ", cartaoRotativo);
        System.out.println("CT006_001 cliente possui restrições em cartao rotativo ");
        Assert.assertEquals("Falso",cartaoRotativo);
    }

    public void VerificacaoCliente() throws IOException {

        String verificacaodeelegibilidade = basepage6.EscolherLinhaEColunaDaPlanilha(6,6);
        basepage6.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente está habilitado a  pegar o empréstimo ?    ", verificacaodeelegibilidade);
        System.out.println("CT006_001 cliente esta inapto a receber o empréstimo devido a cartao rotativo");
        Assert.assertEquals("não",verificacaodeelegibilidade);
    }

    public void Status() throws IOException {

        String Status = basepage6.EscolherLinhaEColunaDaPlanilha(6,7);
        basepage6.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O funcionário do banco informa deve infomar ao cliente que ele não esta habilitado para obter o empréstimo devido ter  cartao rotativo com o valor superior a R$ 2.500,00:     ", Status);
        System.out.println("CT006_001 empréstimo negado");
        Assert.assertEquals("Negado",Status);
    }

    public void Sair() throws InterruptedException {
        DriverFactory.quitDriver();
        Thread.sleep(5000);
    }


    public void screenshot() throws IOException {
        File pasta = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String nomePasta = "screenshot" + System.currentTimeMillis() + ".jpg";
        File CriarPastaNoTarget = new File("target/screenshot/CT006_001");
        if (!CriarPastaNoTarget.exists()) {
            CriarPastaNoTarget.mkdir();
        }
        File pastaTarget = new File(CriarPastaNoTarget, nomePasta);
        FileUtils.copyFile(pasta, pastaTarget);
    }



}
