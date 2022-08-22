package util.SpecObject;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.utility.ConfigReader.getChatServerUrl;

public class ChatSpecObject {

    public static RequestSpecification getChatRequestSpecificationObject() throws IOException {


        String timestamp = new SimpleDateFormat("_yyyddMM_hhmmss").format(new Date());


        PrintStream log = new PrintStream(new FileOutputStream("log/log"+timestamp+".txt"));

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestChatUser = new RequestSpecBuilder()
                .setAuth(auth)
                .setBaseUri(getChatServerUrl())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();
        return requestChatUser;
    }
}
