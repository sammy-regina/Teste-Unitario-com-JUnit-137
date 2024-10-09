//nome do pacote
package apiTeste;

//bibliotecas

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static com.sun.tools.javac.code.TypeAnnotationPosition.unknown;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

//Classe
public class TesteUser {
    private static final String BASE_URI = "http://example.com/api";   //inicio da classe co letra maiuscula
    private static final String CONTENT_TYPE = "application/json";
    //atributos
    static String ct = "application/json";
    static String uri = "https://petstore.swagger.io/v2/user/";

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
                .statusCode(200)                     //comunicação ida e volta ok
                .body("code", is(200))         //tag code é 200
                .body("type", is("unknown"))   //tag type é unknown
                .body("message", is(userId))         //message é variável userId
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
    @Test
    public void testarAlterarUser() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");
        String userId = "1373879393";
        String username = "Liza";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userId))
        ;

    }//fim put

    @Test //anotação
    public void testarExcluiirUser(){//inicio delete
        String username = "Liza";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uri + username)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type",is("unknown"))
                .body("message", is(username))
        ;

    }//fim delete

    @Test
    public void testarLogin(){ //consulta e extrai o token
        String username = "Liza";
        String password = "987654";

        Response response = (Response)
        given()//cast de detalhamento para o given guardar a resposta
                .contentType(ct)
                .log().all()
        .when()
                .get(uri + "login?username=" + username + "&password= " + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36)) //valida pelo numero de caracter (colections)
                .extract()
                ;
        //extração da resposta
        String token = response.jsonPath().getString("message").substring(23);//pega um pedaço do texto a partir da posição 23
        System.out.println("Conteúdo do Token: " + token);
    }//fim login

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')
    @Order(5)

    public void testarIncluirUserCSV(
            String id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            String userStatus)
    {
        User user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUserStatus(userStatus);

        Gson gson = new Gson();
        String jsonBody = gson.toJson(user);

        RestAssured.baseURI = BASE_URI;

        //realizar teste

        given()                                         //Dado que
                .contentType(ct)                        //o tipo de conteudo
                .log().all()                            //mostre tudo
                .body(jsonBody)                         //corpo da requisição
        .when()                                         //Quando
                .post(uri)                              //endpoint
        .then()                                         //então
                .log().all()                            //mostre tudo na volta
                .statusCode(200)                     //comunicação ida e volta ok
                .body("code", is(200))         //tag code é 200
                .body("type", is("unknown"))   //tag type é unknown
        /*.body("message", is( id ))*/          //message é variável id
        ;

    }//fim csv
}// fim da classe