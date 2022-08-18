package util.SpecObject;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static util.utility.ConfigReader.getChatServerUrl;

public class ChatSpecObject {

    public static RequestSpecification getChatRequestSpecificationObject() throws IOException {
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestChatUser = new RequestSpecBuilder()
                .setAuth(auth)
                .setBaseUri(getChatServerUrl())
                .build();
        return requestChatUser;
    }
}
