package stepdefinition.SampleUser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import util.POJO.sampleUser.CreateSampleUserPOJO;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static util.utility.ConfigReader.getSampleUserUrl;

public class SampleUserSD {

    RequestSpecification request;
    Response response;
    String responseJsonStr;

    @Given("Create user payload is created")
    public void create_user_payload_is_created() {


        RequestSpecification requestCreateUser = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type","application/json")
                .build();

         request = given().log().all().spec(requestCreateUser).body(
                "{\n" +
                "    \"name\": \"Shashi\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");

    }
    @When("user call AddUser request with POST Method call")
    public void user_call_add_user_request_with_post_method_call() {

         response =  request.when().post("/api/users");
    }

    @Then("API call should get success with status code {string}")
    public void api_call_should_get_success_with_status_code(String statusCode) {

        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

         responseJsonStr = response.then().log().all().spec(responseSpec).extract().asString();

        System.out.println("responseJsonStr="+responseJsonStr);
    }

    @Then("{string} should be {string}")
    public void should_be(String jsonPath, String expectedJsonValue) {

        JsonPath js = new JsonPath(responseJsonStr);

        String actual = js.get(jsonPath);

        System.out.println("expectedJsonValue="+expectedJsonValue);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expectedJsonValue,"Json value does not match");

    }

    @Given("Create user payload is created using POJO")
    public void createUserPayloadIsCreatedUsingPOJO() throws IOException {
   /*     RequestSpecification requestCreateUser = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type","application/json")
                .build();*/

        RequestSpecification requestCreateUser = new RequestSpecBuilder()
                .setBaseUri(getSampleUserUrl())
                .addHeader("Content-Type","application/json")
                .build();


        CreateSampleUserPOJO ob = new CreateSampleUserPOJO();
        ob.setName("Vipin");
        ob.setJob("Test Lead");

        request = given().log().all().spec(requestCreateUser)
                .body(ob);

    }
}
