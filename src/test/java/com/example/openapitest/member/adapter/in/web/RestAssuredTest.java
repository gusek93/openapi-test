package com.example.openapitest.member.adapter.in.web;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {

    @Test
    void getMember() {
        given().
            when().get("/member").then().log().all();

    }

    @Test
    void createMember() {
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("name", "testcase1");

        RestAssured.given().contentType("application/json")
                .body(requestData).log().all()
                .when().post("/member")
                .then()
                    .assertThat().body("name", equalTo("testcase1")).log().all();

    }

    @Test
    public void updateMember() {
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("id", 72);
        requestData.put("name", "fuckkingBDD");

        RestAssured.given()
            .contentType("application/json")
            .pathParam("id",72)
            .body(requestData).log().all()
            .when().put("/member/{id}")
            .then().statusCode(200)
            .assertThat().body("id",equalTo(72))
            .assertThat().body("name", equalTo("fuckkingBDD")).log().all();

    }

    @Test
    public void deleteMember() {
        RestAssured.given()
            .pathParam("id",72).log().all()
            .when().delete("/member/{id}")
            .then().statusCode(200)
            .log().all();
    }
}
