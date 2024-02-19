package lesson_16;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestSpecification(String url){
        return new RequestSpecBuilder().setBaseUri(url).setContentType(ContentType.JSON).build();
    }
    public static ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder().expectStatusCode(200).build();
    }
    public static  void installSpecifications(RequestSpecification request, ResponseSpecification response){
        RestAssured.responseSpecification= response;
        RestAssured.requestSpecification = request;
    }
}
