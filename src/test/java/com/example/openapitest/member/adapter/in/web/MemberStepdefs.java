package com.example.openapitest.member.adapter.in.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MemberStepdefs {

    //Get
    @When("클라이언트가 member호출한다")
    public void 클라이언트가Member호출한다() {
        given().when().get("/member").then().log().all();

    }

    //Create
    private Map<String, Object> requestData = new HashMap<>();

    @Given("클라이언트가 Member를 추가한다")
    public void 클라이언트가Member를추한다() {
        requestData.put("name", "testcase1");
    }

    @When("클라이언트가 Member 생성을 요청한다")
    public void 클라이언트가Member생성을요청한다() {

        given().contentType("application/json")
            .body(requestData).log().all()
            .when().post("/member")
            .then()
            .assertThat().body("name", equalTo("testcase1")).log().all();
    }


    // Update
    @Given("클라이언트가 Member를 수정한다")
    public void 클라이언트가_Member를_수정한다() {
        requestData.put("id", 74);
        requestData.put("name", "fuckkingBDD");
    }

    @When("클라이언트가 Member 수정을 요청한다")
    public void 클라이언트가_Member_수정을_요청한다() {
        given()
            .contentType("application/json")
            .pathParam("id",74)
            .body(requestData).log().all()
            .when().put("/member/{id}")
            .then().statusCode(200)
            .assertThat().body("id",equalTo(74))
            .assertThat().body("name", equalTo("fuckkingBDD")).log().all();
    }

    @Then("클라이언트가 Member 수정이 됬는지 검증한다")
    public void 클라이언트가_Member_수정이_됬는지_검증한다() {

//        assertThat(requestData.get(id));

    }
}


