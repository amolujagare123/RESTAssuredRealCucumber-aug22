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

    public static CreateSampleUserPOJO getSampleUserPojoObject(String name,String job)
    {
        CreateSampleUserPOJO ob = new CreateSampleUserPOJO();
        ob.setName(name);
        ob.setJob(job);
        return ob;
    }
}
