package apiTeste;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.sun.tools.javac.code.TypeAnnotationPosition.unknown;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class TestePet {
    static String ct = "application/json";
    static String uri = "https://petstore.swagger.io/v2/pet";

    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    @Test
    public void testarIncluirPet() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/pet01.json");
        String id = "7238157961507587";
        String name = "Eldon";
        String status = "available";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is (id))
                .body("name",is(name))
                .body("status", is(status));
    }

}
