package Pages;

import Core.BasePage;
import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CT007_001_page {
    BasePage basepage7 = new BasePage();


    public void EntrarSite(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://pt.anotepad.com/");
    }
    public void Titulo(){
        basepage7.TituloDaPagina("//*[@id=\"edit_title\"]","CT007_001 Empréstimo negado  (Usando cheque especial)");
    }

    public void ChequeEsp() throws IOException {
        String chequeEpecial = basepage7.EscolherLinhaEColunaDaPlanilha(7,3);
        basepage7.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","cliente nao esta usando cheque especial   ",chequeEpecial);
        System.out.println("CT007_001 cliente possui restrições em cheque especial ");
    }

    public void VerificacaoCliente() throws IOException {

        String verificacaodeelegibilidade = basepage7.EscolherLinhaEColunaDaPlanilha(7,6);
        basepage7.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente está habilitado a  pegar o empréstimo ?    ", verificacaodeelegibilidade);
        System.out.println("CT007_001 cliente esta inapto a receber o empréstimo devido a cheque especial");
    }

    public void Status() throws IOException {

        String Status = basepage7.EscolherLinhaEColunaDaPlanilha(7,7);
        basepage7.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O funcionário do banco informa deve infomar ao cliente que ele não esta habilitado para obter o empréstimo devido està  usando  cheques especial:     ", Status);
        System.out.println("CT007_001 empréstimo negado");
    }

    public void Sair() throws InterruptedException {
        Thread.sleep(5000);
        DriverFactory.quitDriver();
    }


    public void screenshot() throws IOException {
        File pasta = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String nomePasta = "screenshot" + System.currentTimeMillis() + ".jpg";
        File CriarPastaNoTarget = new File("target/screenshot/CT007_001");
        if (!CriarPastaNoTarget.exists()) {
            CriarPastaNoTarget.mkdir();
        }
        File pastaTarget = new File(CriarPastaNoTarget, nomePasta);
        FileUtils.copyFile(pasta, pastaTarget);
    }
}
