package Pages;

import Core.BasePage;
import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CT005_001_page {
    BasePage basepage5 = new BasePage();


    public void EntrarSite(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://pt.anotepad.com/");
    }
    public void Titulo(){
        basepage5.TituloDaPagina("//*[@id=\"edit_title\"]","CT005_001 Empréstimo negado  (Sem renda comprovada)");
    }

    public void RendaComp() throws IOException {

        String rendacomprovada =basepage5.EscolherLinhaEColunaDaPlanilha(5,2);
        basepage5.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","cliente possui uma renda comprovada.    ",rendacomprovada);
        System.out.println("CT005_001 cliente possui restrições em renda insuficiente ");
        Assert.assertEquals("Falso",rendacomprovada);
    }

    public void VerificacaoCliente() throws IOException {

        String verificacaodeelegibilidade = basepage5.EscolherLinhaEColunaDaPlanilha(5,6);
        basepage5.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente está habilitado a  pegar o empréstimo ?    ", verificacaodeelegibilidade);
        System.out.println("CT005_001 cliente esta inapto a receber o empréstimo devido a renda insuficiente");
        Assert.assertEquals("não",verificacaodeelegibilidade);
    }

    public void Status() throws IOException {

        String Status = basepage5.EscolherLinhaEColunaDaPlanilha(5,7);
        basepage5.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O funcionário do banco  deve infomar ao cliente que ele não esta habilitado para obter o empréstimo devido à renda insuficiente    ", Status);
        System.out.println("CT005_001 empréstimo negado");
        Assert.assertEquals("Negado",Status);
    }
    public void Sair() throws InterruptedException {
        DriverFactory.quitDriver();
        Thread.sleep(5000);
    }

    public void screenshot() throws IOException {
        File pasta = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String nomePasta = "screenshot" + System.currentTimeMillis() + ".jpg";
        File CriarPastaNoTarget = new File("target/screenshot/CT005_001");
        if (!CriarPastaNoTarget.exists()) {
            CriarPastaNoTarget.mkdir();
        }
        File pastaTarget = new File(CriarPastaNoTarget, nomePasta);
        FileUtils.copyFile(pasta, pastaTarget);
    }



}
