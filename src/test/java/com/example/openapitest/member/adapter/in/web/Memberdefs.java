package com.example.openapitest.member.adapter.in.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Memberdefs {

    private Response response;

    @Before
    public void setup() {
        RestAssured.baseURI="http://localhost:8080";
    }

    @When("클라이언트가 전체 멤버 목록을 요청한다")
    public void 클라이언트가전체멤버목록을요청한다 () {
        response = RestAssured
                .given().log().all()
                .when().get("member").
        thenReturn();
    }

    @Then("status 코드 {string}을 수신한다")
    public void status코드을수신한다(String arg0) {
        assertThat(response.statusCode()).isEqualTo(Integer.parseInt(arg0));
    }

    @And("n{string}개의 member를 수신한다")
    public void n개의Member를수신한다(String arg0) {
        assertThat((int)response.body().path("id[0]")).isEqualTo(1);
    }

    @When("조회할 멤버의 ID {string} 입력 받는다")
    public void 조회할멤버의ID입력받는다(String string) {
        response = RestAssured
                .given()
                .when().get("member/"+string);
    }

    @Then("특정멤버 status 코드 {string}을 수신한다")
    public void 특정멤버status코드을수신한다(String arg0) {
        assertThat(response.statusCode()).isEqualTo(Integer.parseInt(arg0));
    }

//    @And("member 정보를 수신한다")
//    public void member정보를수신한다() {
//
//    }
}
