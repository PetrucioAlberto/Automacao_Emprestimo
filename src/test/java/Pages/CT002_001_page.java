package Pages;

import Core.BasePage;
import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CT002_001_page {

    BasePage basepage2 = new BasePage();

    public void EntrarSite(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://pt.anotepad.com/");
    }
    public void Titulo(){
        basepage2.TituloDaPagina("//*[@id=\"edit_title\"]","CT002_001  Empréstimo negado (Com restrição)");
    }

    public void Restricoes() throws IOException {

        String Comrestricoes = basepage2.EscolherLinhaEColunaDaPlanilha(2,1);
        basepage2.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","o cliente não  possui  restrições       ",Comrestricoes);
        System.out.println("CT002_001 cliente possui restrições");
        Assert.assertEquals("Falso",Comrestricoes);


    }

    public void VerificacaoCliente() throws IOException {

        String verificacaodeelegibilidade =basepage2.EscolherLinhaEColunaDaPlanilha(2,6);
        basepage2.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente está habilitado a  pegar o empréstimo ?    ",verificacaodeelegibilidade);
        System.out.println("CT002_001 cliente esta inapto a receber o empréstimo");
        Assert.assertEquals("não",verificacaodeelegibilidade);

    }

    public void Status() throws IOException {

        String Status = basepage2.EscolherLinhaEColunaDaPlanilha(2,7);
        basepage2.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","Empréstimo.     ", Status);
        System.out.println("CT002_001 empréstimo negado");
        Assert.assertEquals("Negado",Status);


    }
    public void Sair() throws InterruptedException {
        Thread.sleep(5000);
        DriverFactory.quitDriver();
    }

    public void screenshot() throws IOException {
        File pasta = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String nomePasta = "screenshot" + System.currentTimeMillis() + ".jpg";
        File CriarPastaNoTarget = new File("target/screenshot/CT002_001");
        if (!CriarPastaNoTarget.exists()) {
            CriarPastaNoTarget.mkdir();
        }
        File pastaTarget = new File(CriarPastaNoTarget, nomePasta);
        FileUtils.copyFile(pasta, pastaTarget);
    }

}
