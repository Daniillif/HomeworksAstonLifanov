package lesson_16;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Lesson_16 {
    //Перейдите в сервис Postman.
    //Войдите в свой аккаунт и скачайте себе коллекцию Postman Echo.
    //Написать автотесты для каждого метода из папки Request Methods
    // (проверка тела ответа (просто сравнить значения всех полей) и кода ответа).
    @Test
    public void checkGetRequestPostman(){
        Specifications.installSpecifications(Specifications.requestSpecification("https://postman-echo.com/"),Specifications.responseSpecification());
        given().contentType("application/json").
                get("get?foo1=bar1&foo2=bar2").
                then().log().body().
                statusCode(HttpStatus.SC_OK).and().body("args.foo1",equalTo("bar1")).and().body("args.foo2",equalTo("bar2"));
    }
    @Test
    public void checkPostRawTextPostman(){
        DataTest value = new DataTest("value");
        Specifications.installSpecifications(Specifications.requestSpecification("https://postman-echo.com/"),Specifications.responseSpecification());
        given().log().body().contentType("application/json").body(value).when().
                post("post").
                then().log().body().
                statusCode(HttpStatus.SC_OK).and().body("data.test",equalTo("value"));
    }
    @Test
    public void checkPostFormDataPostman(){
        PostForm postForm = new PostForm("bar1", "bar2");
        Specifications.installSpecifications(Specifications.requestSpecification("https://postman-echo.com/"),Specifications.responseSpecification());
        given().log().body().contentType("application/json").body(postForm).when().
                post("post").
                then().log().body().
                statusCode(HttpStatus.SC_OK).and().body("data.foo1",equalTo("bar1")).and().body("data.foo2",equalTo("bar2"));
    }
    @Test
    public void checkPutRequestPostman(){
        Specifications.installSpecifications(Specifications.requestSpecification("https://postman-echo.com/"),Specifications.responseSpecification());
        given().log().body().contentType("application/json").body("This is expected to be sent back as part of response body.").when().
                put("put").
                then().log().body().
                statusCode(HttpStatus.SC_OK).and().body("data",equalTo("This is expected to be sent back as part of response body."));
    }
    @Test
    public void checkPatchRequestPostman(){
        Specifications.installSpecifications(Specifications.requestSpecification("https://postman-echo.com/"),Specifications.responseSpecification());
        given().log().body().contentType("application/json").body("This is expected to be sent back as part of response body.").when().
                patch("patch").
                then().log().body().
                statusCode(HttpStatus.SC_OK).and().body("data",equalTo("This is expected to be sent back as part of response body."));
    }
    @Test
    public void checkDeleteRequestPostman(){
        Specifications.installSpecifications(Specifications.requestSpecification("https://postman-echo.com/"),Specifications.responseSpecification());
        given().log().body().contentType("application/json").body("This is expected to be sent back as part of response body.").when().
                delete("delete").
                then().log().body().
                statusCode(HttpStatus.SC_OK).and().body("data",equalTo("This is expected to be sent back as part of response body."));
    }
}
