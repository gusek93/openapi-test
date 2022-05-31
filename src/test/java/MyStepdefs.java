import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;

import static io.restassured.RestAssured.given;

public class MyStepdefs {

    private Response response;

    @Before
    public void setup() {
        RestAssured.baseURI="http://localhost:8080";
    }

    @When("클라이언트가 전체 맴버 목록을 요청한다")
    public void 클라이언트가전체맴버목록을요청한다() {
        response = RestAssured
            .given()
            .when().get("/member");
    }


    @Then("status 코드 {string}을 수신한다")
    public void status코드을수신한다(String arg0) {
    }


    @And("n{string}개의 company를 수신한다")
    public void n개의Company를수신한다(String arg0) {
    }
}
