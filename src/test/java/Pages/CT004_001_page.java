package Pages;


import Core.BasePage;
import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CT004_001_page {
    BasePage basepage4 = new BasePage();


    public void EntrarSite(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://pt.anotepad.com/");
    }
    public void Titulo(){
        basepage4.TituloDaPagina("//*[@id=\"edit_title\"]","CT004_001 Empréstimo negado  (Cheque sem fundo)");
    }

    public void ChequeSemFundo() throws IOException {

        String chequeSemFundo = basepage4.EscolherLinhaEColunaDaPlanilha(4, 0);
        basepage4.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente nunca emitiu cheques sem fundo.  ", chequeSemFundo);
        System.out.println("CT004_001 cliente possui restrições em cheque sem fundo ");
        Assert.assertEquals("Falso",chequeSemFundo);
    }

    public void VerificacaoCliente() throws IOException {

        String verificacaodeelegibilidade = basepage4.EscolherLinhaEColunaDaPlanilha(4,6);
        basepage4.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente está habilitado a  pegar o empréstimo ?    ", verificacaodeelegibilidade);
        System.out.println("CT004_001 cliente esta inapto a receber o empréstimo devido a emitir cheque sem fundo");
        Assert.assertEquals("não",verificacaodeelegibilidade);
    }

    public void Status() throws IOException {

        String Status = basepage4.EscolherLinhaEColunaDaPlanilha(4,7);
        basepage4.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O funcionário do banco  deve infomar ao cliente que ele não esta habilitado para obter o empréstimo devido à emissão de cheques sem fundo:     ", Status);
        System.out.println("CT004_001 empréstimo negado");
        Assert.assertEquals("Negado",Status);
    }
    public void Sair() throws InterruptedException {
        Thread.sleep(5000);
        DriverFactory.quitDriver();
    }

    public void screenshot() throws IOException {
        File pasta = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String nomePasta = "screenshot" + System.currentTimeMillis() + ".jpg";
        File CriarPastaNoTarget = new File("target/screenshot/CT004_001");
        if (!CriarPastaNoTarget.exists()) {
            CriarPastaNoTarget.mkdir();
        }
        File pastaTarget = new File(CriarPastaNoTarget, nomePasta);
        FileUtils.copyFile(pasta, pastaTarget);
    }

}
