package util.payload;

public enum APIChatResources {

    AddChatUser("/restapi/user"),
    DeleteChatUser("/restapi/user/102"),
    UpdateChatUser("/restapi/user/106"),
    GetChatUser("/restapi/user/106"),
    GetAllChatUsers("/restapi/getusers");

    String resource;


    APIChatResources(String resource) {

        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
