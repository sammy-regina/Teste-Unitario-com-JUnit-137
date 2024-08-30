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
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/user/";

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
                .contentType(ct)                        //o tipo de conteudo
                .log().all()                            //mostre tudo
                .body(jsonBody)                         //corpo da requisição
                .when()                                 //Quando
                .post(uri)                              //endpoint
                .then()                                 //então
                .log().all()                            //mostre tudo na volta
                .statusCode(200)                      //comunicação ida e volta ok
                .body("code", is(200))          //tag code é 200
                .body("type", is("unknown"))    //tag type é unknown
                .body("message", is(userId))          //message é variável userId
        ;
    }//fim post

    @Test
    public void testarConsultarUser(){
        String username = "Liza"; //variavel username (pode ser alterado o nome)

        //resultado esperado
        int userId = 1373879393; //codigo do usuário
        String email = "liza@teste.com";
        String password = "123456";

        given()
                .contentType(ct) //ct = a variavel que foi declarada la em cima em atributos
                .log().all()// mostrar tudo
        .when() //quando
                .get(uri + username) //variavel endpoint do usuario + variavel username
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is (userId))
                .body("email", is (email))
                .body("password", is (password))
        ;
    }//fim get
    

}// fim da classe