package util.payload;

import util.POJO.chatServer.CreateChatUserPOJO;

import java.util.ArrayList;

public class ChatServerPayLoads {


    public static CreateChatUserPOJO getCreateUserPojoObject()
    {
        CreateChatUserPOJO ob = new CreateChatUserPOJO();

        ob.setName("Bhushan");
        ob.setSurname("Patil");
        ob.setUsername("bhushan");
        ob.setPassword("b1234");
        ob.setChat_nickname("bhushan123");
        ob.setEmail("bhushan@gmail.com");

        ArrayList<Integer> dept= new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        ArrayList<Integer> deptRead = new ArrayList<Integer>() {{

            add(2);
        }};

        ArrayList<Integer> deptGroups= new ArrayList<Integer>() {{
            add(1);
        }};

        ArrayList<Integer> userGroups= new ArrayList<Integer>() {{
            add(1);
        }};


        ob.setDepartments(dept);
        ob.setDepartments_read(deptRead);
        ob.setDepartment_groups(deptGroups);
        ob.setUser_groups(userGroups);

        return ob;
    }


    public static CreateChatUserPOJO getUserPojoObject(String name,String surname,
                                                       String username,String password,
                                                       String email,String nickName)
    {
        CreateChatUserPOJO ob = new CreateChatUserPOJO();

        ob.setName(name);
        ob.setSurname(surname);
        ob.setUsername(username);
        ob.setPassword(password);
        ob.setChat_nickname(nickName);
        ob.setEmail(email);

        ArrayList<Integer> dept= new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        ArrayList<Integer> deptRead = new ArrayList<Integer>() {{

            add(2);
        }};

        ArrayList<Integer> deptGroups= new ArrayList<Integer>() {{
            add(1);
        }};

        ArrayList<Integer> userGroups= new ArrayList<Integer>() {{
            add(1);
        }};


        ob.setDepartments(dept);
        ob.setDepartments_read(deptRead);
        ob.setDepartment_groups(deptGroups);
        ob.setUser_groups(userGroups);

        return ob;
    }
}
