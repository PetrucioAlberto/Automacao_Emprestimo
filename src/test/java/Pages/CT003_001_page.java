package Pages;

import Core.BasePage;
import Core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CT003_001_page {
    BasePage basepage3 = new BasePage();


    public void EntrarSite(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://pt.anotepad.com/");
    }
    public void Titulo(){
        basepage3.TituloDaPagina("//*[@id=\"edit_title\"]","CT003_001 Empréstimo negado (Conta com restrição)");
    }


    public void ContaAtiva2anos() throws IOException {

        String contamaisde2anos = basepage3.EscolherLinhaEColunaDaPlanilha(3, 5);
        basepage3.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]", "cliente não esta usando cartão rotativo superior R$ 2.500,00     ", contamaisde2anos);
        System.out.println("CT003_001 cliente possui restrições em conta ativa ");
        Assert.assertEquals("Falso",contamaisde2anos);
    }

    public void VerificacaoCliente() throws IOException {

        String verificacaodeelegibilidade = basepage3.EscolherLinhaEColunaDaPlanilha(3,6);
        basepage3.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","O cliente está habilitado a  pegar o empréstimo ?    ",verificacaodeelegibilidade);
        System.out.println("CT003_001 cliente esta inapto a receber o empréstimo ");
        Assert.assertEquals("não",verificacaodeelegibilidade);
    }

    public void Status() throws IOException {

        String Status = basepage3.EscolherLinhaEColunaDaPlanilha(3,7);
        basepage3.InserirTextoNoCampo("//*[@id=\"edit_textarea\"]","o funcionário do banco solicita que o cliente abra uma conta  ou espere ate atingir o prazo mínimo, empréstimo:     ", Status);
        System.out.println("CT003_001 empréstimo negado");
        Assert.assertEquals("Negado",Status);
    }
    public void Sair() throws InterruptedException {
        Thread.sleep(5000);
        DriverFactory.quitDriver();
    }



    public void screenshot() throws IOException {
        File pasta = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String nomePasta = "screenshot" + System.currentTimeMillis() + ".jpg";
        File CriarPastaNoTarget = new File("target/screenshot/CT003_001");
        if (!CriarPastaNoTarget.exists()) {
            CriarPastaNoTarget.mkdir();
        }
        File pastaTarget = new File(CriarPastaNoTarget, nomePasta);
        FileUtils.copyFile(pasta, pastaTarget);
    }


}
