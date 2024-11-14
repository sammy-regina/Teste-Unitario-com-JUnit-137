package webTest;
//bibliotecas

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Classes
public class ComprarPassagemWD {
    // Atributos/ caracteristicas/ variaveis
    private WebDriver driver; //declaramos o objeto do selenium webdriver

    // funções e metodos

    // antes do teste
    @BeforeEach // = antes de cada teste - beforeall = antes de tudo
    public void setUp(){ // inicio do Before
        //declarar o gerenciador para baixar o crome driver
        WebDriverManager.chromedriver().setup();
        //configuração específica a partir do selenium webdriver
        ChromeOptions options = new ChromeOptions(); //instancia o chromeOptions
        options.addArguments("--remote-allow-origins*");
        driver = new ChromeDriver(options); //instancia o chromedriver com options
        driver.manage().window().maximize(); //maximiza janela do navegador
    }//fim do before

    // depois do teste
    @AfterEach
    public void tearDown(){ //inicio do after
        driver.quit();//encerrar(destroi a instancia do selenium webdriver)
    }
    // o teste
    @Test
    public void comprarPassagemWD(){ //inicio comprar passagem wd
        driver.get("https://www.blazedemo.com");//abrir o endereço alvo
        //selecionar a lista de cidades de origem
        driver.findElement(By.name("fromPort")).click();//selenium procurar elemento por nome"fromPort" e clique
        //selecionar a cidadeorigem na lista
        {//inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));//criou um nome para a lista (fromPort(origem))
            lista.findElement(By.xpath("options//[.= 'São Paolo']")).click();
        }//fim da seleção dentro do lista

        driver.findElement(By.name("toPort")).click();//selenium procurar elemento por nome"fromPort" e clique
        //selecionar a cidade destino na lista
        {//inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));//toPort (destino)
            lista.findElement(By.xpath("options//[.= 'Berlin']")).click();
        }//fim da seleção dentro do lista

        //aperat o botão find flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        //validar a frase que indica que o voo é de são paolo para berlim
        assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());
    }// fim comprar passagem wd
}
