package com.example.openapitest.member.adapter.in.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberStepdefs {

    private Response response;

    //Get
    @When("클라이언트가 member호출한다")
    public void 클라이언트가Member호출한다() {
        given().when().get("/member").then().log().all();

    }

    //Create
    private Map<String, Object> member;

    @Given("클라이언트가 Member를 추가한다")
    public void 클라이언트가Member를추한다() {
        member = new HashMap<>();
        member.put("name", "testcase1");
    }

    @When("클라이언트가 Member 생성을 요청한다")
    public void 클라이언트가Member생성을요청한다() {
        response = RestAssured.
        given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(ContentType.JSON)
                .body(member)
                .when().post("/member");

    }


    // Update
    @Given("클라이언트가 Member를 수정한다")
    public void 클라이언트가_Member를_수정한다() {
        member = new HashMap<>();
        member.put("id", 8);
        member.put("name", "updateTest");
    }

    @When("클라이언트가 Member 수정을 요청한다")
    public void 클라이언트가_Member_수정을_요청한다() {
        response = RestAssured.given()
            .contentType("application/json")
            .pathParam("id",8)
            .body(member).log().all()
            .when().put("/member/{id}");

    }

    @Then("클라이언트가 Member 수정이 됬는지 검증한다")
    public void 클라이언트가_Member_수정이_됬는지_검증한다() {
        assertThat((String)response.body().path("name")).isEqualTo("updateTest");
    }

    @When("클라이언트가 Member 삭제 요청한다")
    public void 클라이언트가Member삭제요청한다() {
        response = RestAssured.given().pathParam("id",18).when().log().all().delete("/member/{id}");
    }

//    @Then("클라이언트가 Member 삭제 됬는지 검증한다")
//    public void 클라이언트가Member삭제됬는지검증한다() {
//        assertThat((String)response.body().path("id")).isEqualTo(1);
//    }
}


