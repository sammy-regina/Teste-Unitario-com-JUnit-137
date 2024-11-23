package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base{//definir a classe base e colocar o extends
    //construtor(uma conexão como se fosse um de/para conectando ao webdriver)
    public HomePage(WebDriver driver){
        super(driver); //precisa do extends base
    }
    //mapeamento dos elementos
    //seletor de local(origem ou destino)
    public By byLocal(String local){
        return By.cssSelector("option[value=\"" + local + "\"]");
    }
    //botão de procurar voo
    public By byBtnFindFlights = By.cssSelector("input[value]");

    //Ações
    //Seleção da origem e do destino
    public void selecionarOrigemDestino(String byOrigem, String byDestino){
        this.driver.findElement(byLocal(byOrigem)).click();
        this.driver.findElement(byLocal(byDestino)).click();
    }
    public void clicarBtnProcurarVoo(){
        this.driver.findElement(byBtnFindFlights).click();
    }
}
