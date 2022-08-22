Feature: all rest request about chat server

  @ChatCreateUser
  Scenario: verify the user is created successfully or not
    Given Create Chat user payload is created
  #  Given Create user payload is created using POJO
    When user call AddChatUser request with POST Method call
    Then Chat server API call should get success with status code "400"
    Then "error" should be "true"


  @ChatCreateUserPojo
  Scenario: verify the user is created successfully or not
  #  Given Create Chat user payload is created
    Given Create chat user payload is created using POJO
    When user call AddChatUser request with POST Method call
    Then Chat server API call should get success with status code "400"
    Then "error" equals "true"


  @ChatCreateUserPojoEnum  @WithEnum
  Scenario: verify the user is created successfully or not
    Given Create chat user payload is created using POJO
    When user calls "AddChatUser" request with "POST" Method
    Then Chat server API call should get success with status code "400"
    Then "error" equals "true"


  @ChatUpdateUserPojoEnum  @WithEnum
  Scenario: verify the user is Updated successfully or not
    Given Update chat user payload is created using POJO with values "updatedName1","updatedSurname1","updatedusername1","updatedpassword1","updated@Email1.com","updatedNickname1"
    When user calls "UpdateChatUser" request with "PUT" Method
    Then Chat server API call should get success with status code "200"
    Then "error" equals "false"


  @ChatDeleteUserPojoEnum  @WithEnum
  Scenario: verify the user is deleted successfully or not
    Given chat user basic payload is created
    When user calls "DeleteChatUser" request with "DELETE" Method
    Then Chat server API call should get success with status code "200"
    Then "error" equals "false"

  @ChatGetSingleUserPojoEnum  @WithEnum
  Scenario: verify the user is retrieved successfully or not
    Given chat user basic payload is created
    When user calls "GetChatUser" request with "GET" Method
    Then Chat server API call should get success with status code "200"
    Then "error" equals "false"



  @ChatGetAllUserPojoEnum  @WithEnum
  Scenario: verify the user is retrieved successfully or not
    Given chat user basic payload is created
    When user calls "GetAllChatUsers" request with "GET" Method
    Then Chat server API call should get success with status code "200"
    Then "error" equals "false"