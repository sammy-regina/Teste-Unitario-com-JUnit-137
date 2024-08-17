//nome do pacote
package apiTeste;

//bibliotecas

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is; //comparador se é igual

//Classe
public class TesteUser {   //inicio da classe co letra maiuscula
    //atributos

    //funções e metodos

    //funções de apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    //funções de teste

    @Test
    public void testarIncluirUser() throws IOException {
        //carregar dados do json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");
        String userId = "1373879393";

        //realizar teste
        given()                                         //Dado que
                .contentType("application/json")     //o tipo de conteudo
                .log().all()                            //mostre tudo
                .body(jsonBody)                         //corpo da requisição
                .when()                                         //Quando
                .post("https://petstore.swagger.io/v2/user") //endpoint
                .then()                                          //então
                .log().all()                             //mostre tudo na volta
                .statusCode(200)                      //comunicação ida e volta ok
                .body("code", is(200))          //tag code é 200
                .body("type", is("unknown"))    //tag type é unknown
                .body("message", is(userId))          //message é variável userId
        ;
    }//fim post

    

}// fim da classe