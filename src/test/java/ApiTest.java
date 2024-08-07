import io.qameta.allure.testng.AllureTestNg;
import org.junit.Test;
import org.testng.annotations.Listeners;

import javax.annotation.processing.SupportedAnnotationTypes;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Listeners({AllureTestNg.class})
public class ApiTest {
    @Test

    public void getListOfUsers(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void getUser(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users/5")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void getUserDelay(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users?delay=3")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void getListOfUsersCheckBodyField() {
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .body(not(emptyString()))
                .body("per_page", equalTo(6));
    }
//    @Test
//        public void postCreateUser(){
//
//        CreateUserBody body1 = new CreateUserBody ("Olena", "HR BP");
//
//        given()
//                .baseUri("https://reqres.in/api")
//                .body(body1)
//                .contentType("application/json")
//                .log().all()
//                .when()
//                .post("/users")
//                .then()
//                .log().all()
//                .statusCode(201)
//                .body(not(emptyString()))
//                .body("name", equalTo("Olena"))
//                .body("job", equalTo("HR BP"));
//    }
@Test
    public void deleteUser(){
        given()
                .baseUri("https://reqres.in/api")
                .log().all()
                .when()
                .delete("/users/5")
                .then()
                .log().all()
                .statusCode(204);
    }
}



