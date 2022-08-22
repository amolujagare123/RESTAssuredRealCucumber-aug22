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
import util.payload.APIResources;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static util.SpecObject.MySpecObject.getRequestSpecificationObject;
import static util.payload.SampleUserPayLoads.getSampleUserPojoObject;
import static util.utility.ConfigReader.getSampleUserUrl;

public class SampleUserSD {

    RequestSpecification request;
    Response response;
    String responseJsonStr;

    @Given("Create user payload is created")
    public void create_user_payload_is_created() {


   /*     RequestSpecification requestCreateUser = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type","application/json")
                .build();
*/

        /*RequestSpecification requestCreateUser = getRequestSpecificationObject();
                request = given().log().all().spec(requestCreateUser).body(
                "{\n" +
                "    \"name\": \"Shashi\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");*/

        request = given().log().all().spec(getRequestSpecificationObject()).body(
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

       /* RequestSpecification requestCreateUser = new RequestSpecBuilder()
                .setBaseUri(getSampleUserUrl())
                .addHeader("Content-Type","application/json")
                .build();*/


   /*     CreateSampleUserPOJO ob = new CreateSampleUserPOJO();
        ob.setName("Vipin");
        ob.setJob("Test Lead");*/

        request = given().log().all().spec(getRequestSpecificationObject())
                .body(getSampleUserPojoObject());

    }

    @Given("Update user payload is created using POJO")
    public void updateUserPayloadIsCreatedUsingPOJO() {
        request = given().log().all().spec(getRequestSpecificationObject())
                .body(getSampleUserPojoObject("Amol","Test lead"));
    }

    @When("user call UpdateUser request with PUT Method call")
    public void userCallUpdateUserRequestWithPUTMethodCall() {

        response =  request.when().put("/api/users/2");
    }

    @Given("Get user payload is created")
    public void getUserPayloadIsCreated() {
        request = given().log().all().spec(getRequestSpecificationObject());

    }

    @When("user call GetUser request with GET Method call")
    public void userCallGetUserRequestWithGETMethodCall() {

        response =  request.when().get("/api/users/2");

    }

    @Given("Delete user payload is created")
    public void delete_user_payload_is_created() {
        request = given().log().all().spec(getRequestSpecificationObject());
    }
    @When("user call DeleteUser request with DELETE Method call")
    public void user_call_delete_user_request_with_delete_method_call() {
        response =  request.when().delete("/api/users/2");
    }

   /* @When("user call {string} request with {string} Method call")
    public void userCallRequestWithMethodCall(String requestType, String method) {

        switch (requestType)
        {
            case "AddUser"    :  response = request.when().post("/api/users"); break;
            case "DeleteUser" :  response = request.when().delete("/api/users/2"); break;
            case "UpdateUser" :  response = request.when().put("/api/users/2"); break;
            case "GetUser"    :  response = request.when().get("/api/users/2"); break;
        }
    }*/

    @When("user call {string} request with {string} Method call")
    public void userCallRequestWithMethodCall(String requestType, String method) {

        APIResources resourceAPI =APIResources.valueOf(requestType);
        System.out.println("My resource = "+resourceAPI.getResource());

        switch (method)
        {
            case "POST"    :  response = request.when().post(resourceAPI.getResource()); break;
            case "DELETE" :  response = request.when().delete(resourceAPI.getResource()); break;
            case "PUT" :  response = request.when().put(resourceAPI.getResource()); break;
            case "GET"    :  response = request.when().get(resourceAPI.getResource()); break;
        }
    }
}
