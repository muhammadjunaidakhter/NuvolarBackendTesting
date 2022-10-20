package users;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

public class users {

    static String baseUrl = "https://reqres.in/api/users";

    @Test
    public void getUsersList(){
            given()
                    .queryParam("page","2")
                .when()
                    .get(baseUrl)
                .then()
                    .log()
                .body()
                    .statusCode(200)
                    .body("page",equalTo(2))
                    .headers("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void getSingleUser(){
        given()
                .when()
                    .get(baseUrl+"/2")
                .then()
                    .log()
                .body()
                    .statusCode(200)
                    .body("data.email",equalTo("janet.weaver@reqres.in"))
                    .headers("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void getEmptyUser(){
        given()
                .when()
                .get(baseUrl+"/23")
                .then()
                .log()
                .body()
                .statusCode(404)
                .body("data.email",equalTo(null))
                .headers("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void creatUser(){
            String body = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }
                """;

            given()
                    .body(body)
                    .when()
                    .post(baseUrl)
                    .then()
                    .log()
                    .body()
                    .statusCode(201);
    }

    @Test
    public void updateUserWithPut(){
        String body = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }
                """;

        given()
                .body(body)
                .when()
                .put(baseUrl+"/2")
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void updateUserWithPatch(){
        String body = """
                {
                    "name": "morpheus"
                }
                """;

        given()
                .body(body)
                .when()
                .patch(baseUrl+"/2")
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void deleteUser(){

        given()
                .when()
                .delete(baseUrl+"/2")
                .then()
                .log()
                .headers()
                .statusCode(204);
    }
}
