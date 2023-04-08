package Core;

import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class BasePage {
    Util util = new Util();


    public void TituloDaPagina(String xpath, String texto){
        WebElement titulo =  DriverFactory.getDriver().findElement(By.xpath(xpath));
        titulo.sendKeys(texto);
    }

    public String EscolherLinhaEColunaDaPlanilha(int linha, int coluna) throws IOException {
        String restricoes = util.buscarDadosClientes(linha, coluna);

        return  restricoes;
    }


    public void InserirTextoNoCampo( String xpath, String respostaTexto, String NomeVariavel){
       DriverFactory.getDriver().findElement(By.xpath(xpath)).sendKeys(respostaTexto + NomeVariavel + Keys.ENTER);

    }


}
