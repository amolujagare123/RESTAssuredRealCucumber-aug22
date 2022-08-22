package stepdefinition.chatServer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import util.POJO.chatServer.CreateChatUserPOJO;
import util.payload.APIChatResources;
import util.payload.APIResources;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static util.SpecObject.ChatSpecObject.getChatRequestSpecificationObject;
import static util.payload.ChatServerPayLoads.getCreateUserPojoObject;
import static util.payload.ChatServerPayLoads.getUserPojoObject;
import static util.utility.ConfigReader.getChatServerUrl;

public class CharServerCreateUserSD {

    RequestSpecification request;
    Response response;
    String responseJsonStr;

    @Given("Create Chat user payload is created")
    public void create_chat_user_payload_is_created() throws IOException {

       /* PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestChatUser = new RequestSpecBuilder()
                .setAuth(auth)
                .setBaseUri(getChatServerUrl())
              //  .addHeader("Content/Type", "application/json")
                .build();

         request = given().log().all().spec(requestChatUser)
                .body("{\n" +
                        "  \"username\": \"vaishali12345\",\n" +
                        "  \"password\": \"1234\",\n" +
                        "  \"email\": \"v@example.org\",\n" +
                        "  \"name\": \"vaishali\",\n" +
                        "  \"surname\": \"P\",\n" +
                        "  \"chat_nickname\": \"vi\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}");
*/

        request = given().log().all().spec(getChatRequestSpecificationObject())
                .body("{\n" +
                        "  \"username\": \"vaishali12345\",\n" +
                        "  \"password\": \"1234\",\n" +
                        "  \"email\": \"v@example.org\",\n" +
                        "  \"name\": \"vaishali\",\n" +
                        "  \"surname\": \"P\",\n" +
                        "  \"chat_nickname\": \"vi\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}");

    }
    @When("user call AddChatUser request with POST Method call")
    public void user_call_add_chat_user_request_with_post_method_call() {

         response = request.when().post("/restapi/user");

    }
    @Then("Chat server API call should get success with status code {string}")
    public void chat_server_api_call_should_get_success_with_status_code(String statusCode) {

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                            .expectStatusCode(Integer.parseInt(statusCode))
                            .build();

         responseJsonStr = response.then().log().all().spec(responseSpec).extract().asString();

        System.out.println("responseJsonStr="+responseJsonStr);

    }

    @Then("{string} equals {string}")
    public void should_be(String jsonPath, String expectedJsonValue) {

        JsonPath js = new JsonPath(responseJsonStr);

        boolean actual = js.get(jsonPath);

        System.out.println("expectedJsonValue="+expectedJsonValue);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,Boolean.parseBoolean(expectedJsonValue),"Json value does not match");

    }

    @Given("Create chat user payload is created using POJO")
    public void createChatUserPayloadIsCreatedUsingPOJO() throws IOException {

       /* PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestChatUser = new RequestSpecBuilder()
                .setAuth(auth)
                .setBaseUri(getChatServerUrl())
                //  .addHeader("Content/Type", "application/json")
                .build();


        request = given().log().all().spec(requestChatUser)
                .body(getCreateUserPojoObject());*/

        request = given().log().all().spec(getChatRequestSpecificationObject())
                .body(getCreateUserPojoObject());

    }


    @When("user calls {string} request with {string} Method")
    public void userCallsRequestWithMethod(String requestType, String method) {

        APIChatResources resourceAPI =APIChatResources.valueOf(requestType);
        System.out.println("My resource = "+resourceAPI.getResource());

        switch (method)
        {
            case "POST"    :  response = request.when().post(resourceAPI.getResource()); break;
            case "DELETE" :  response = request.when().delete(resourceAPI.getResource()); break;
            case "PUT" :  response = request.when().put(resourceAPI.getResource()); break;
            case "GET"    :  response = request.when().get(resourceAPI.getResource()); break;
        }
    }

    @Given("Update chat user payload is created using POJO with values {string},{string},{string},{string},{string},{string}")
    public void updateChatUserPayloadIsCreatedUsingPOJOWithValues(String name, String surname, String username, String password, String email, String nickName) throws IOException {

        request = given().log().all().spec(getChatRequestSpecificationObject())
                .body(getUserPojoObject(name,surname,username,password,email,nickName));


    }


    @Given("chat user basic payload is created")
    public void chatUserBasicPayloadIsCreated() throws IOException {
        request = given().log().all().spec(getChatRequestSpecificationObject());
    }
}
