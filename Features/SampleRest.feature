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