package util.payload;

public enum APIResources {

    AddUser("/api/users"),
    DeleteUser("/api/users/2"),
    UpdateUser("/api/users/2"),
    GetUser("/api/users/2"),
    GetAllUsers("/api/users?page=2");

    String resource;


    APIResources(String resource) {

        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
