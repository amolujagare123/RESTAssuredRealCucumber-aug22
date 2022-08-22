Feature: all rest request about reqres.in

  @SampleCreateUser
  Scenario: verify the user is created successfully or not
    Given Create user payload is created
  #  Given Create user payload is created using POJO
    When user call AddUser request with POST Method call
    Then API call should get success with status code "201"
    Then "name" should be "Vipin"

  @SampleCreateUserPOJO
  Scenario: verify the user is created successfully or not
  #  Given Create user payload is created
    Given Create user payload is created using POJO
    When user call AddUser request with POST Method call
    Then API call should get success with status code "201"
    Then "name" should be "Vipin"



  @SampleUpdateUserPOJO
  Scenario: verify the user is updated successfully or not
    Given Update user payload is created using POJO
    When user call UpdateUser request with PUT Method call
    Then API call should get success with status code "200"
    Then "name" should be "Amol"


  @SampleGetUser
  Scenario: verify the user is retrieved successfully or not
    Given Get user payload is created
    When user call GetUser request with GET Method call
    Then API call should get success with status code "200"
    Then "data.first_name" should be "Janet"


  @SampleDeleteUser
  Scenario: verify the user is deleted successfully or not
    Given Delete user payload is created
    When user call DeleteUser request with DELETE Method call
    Then API call should get success with status code "204"
   # Then "data.first_name" should be "Janet"


  @SampleCreateUserPOJOParam @Param
  Scenario: verify the user is created successfully or not
    Given Create user payload is created using POJO
    When user call "AddUser" request with "POST" Method call
    Then API call should get success with status code "201"
    Then "name" should be "Vipin"

  @SampleDeleteUserParam @Param
  Scenario: verify the user is deleted successfully or not
    Given Delete user payload is created
    When user call "DeleteUser" request with "DELETE" Method call
    Then API call should get success with status code "204"

  @SampleUpdateUserPOJOParam  @Param
  Scenario: verify the user is updated successfully or not
    Given Update user payload is created using POJO
    When user call "UpdateUser" request with "PUT" Method call
    Then API call should get success with status code "200"
    Then "name" should be "Amol"


  @SampleGetUserParam @Param
  Scenario: verify the user is retrieved successfully or not
    Given Get user payload is created
    When user call "GetUser" request with "GET" Method call
    Then API call should get success with status code "200"
    Then "data.first_name" should be "Janet"

  @SampleGetAllUserParam @Param
  Scenario: verify the all users are retrieved successfully or not
    Given Get user payload is created
    When user call "GetAllUsers" request with "GET" Method call
    Then API call should get success with status code "200"