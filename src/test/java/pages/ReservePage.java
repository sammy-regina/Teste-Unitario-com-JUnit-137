package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage extends Base{
    public ReservePage(WebDriver driver){
        super(driver);
    }
    //Mapeamento dos elementos
    //Apenas a frase que diz origem e destino
    public By byCabecalhoListaDeVoos = By.cssSelector("div.container h3");

    //Ação
    public String lerCabecalhoListaDeVoos(){
        return driver.findElement(byCabecalhoListaDeVoos).getText();
    }
    //ler titulo da guia reserve
    public String lerTituloGuia(){
        return driver.getTitle();
    }
}
