package com.example.openapitest.member.adapter.in.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs {
    private Response response;
    private String BASE_URL = "http://localhost:8080";


    @When("클라이언트가 \\/company 호출한다")
    public void 클라이언트가Company호출한다() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given();
        response = req.when().get("/company");
    }


    @Then("클라이언트는 status 코드 {string}을 수신한다")
    public void 클라이언트는Status코드을수신한다(String arg0) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }


    @And("클라이언트가 서버에서 {string}개의 company를 수신한다")
    public void 클라이언트가서버에서개의Company를수신한다(String arg0) {
        assertThat((int)response.body().path("id[1]")).isEqualTo(22);
    }


    @When("조회할 회사의 ID {string} 입력 받는다")
    public void 조회할회사의ID입력받는다(String arg0) {
        
    }

    @And("member 정보를 수신한다")
    public void member정보를수신한다() {
    }
}
