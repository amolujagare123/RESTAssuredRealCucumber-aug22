package util.payload;

import util.POJO.chatServer.CreateChatUserPOJO;
import util.POJO.sampleUser.CreateSampleUserPOJO;

import java.util.ArrayList;

public class SampleUserPayLoads {


    public static CreateSampleUserPOJO getSampleUserPojoObject()
    {
        CreateSampleUserPOJO ob = new CreateSampleUserPOJO();
        ob.setName("Vipin");
        ob.setJob("Test Lead");
        return ob;
    }
}
