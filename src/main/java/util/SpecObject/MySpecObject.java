package util.SpecObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class MySpecObject {

    public static RequestSpecification getRequestSpecificationObject()
    {
        RequestSpecification requestCreateUser = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type","application/json")
                .build();

        return requestCreateUser;
    }
}
