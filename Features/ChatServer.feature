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

