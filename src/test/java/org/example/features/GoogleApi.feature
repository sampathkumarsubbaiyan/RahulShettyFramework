Feature:Google api validation

  @AddPlaceApi
  Scenario Outline: Verify the add place api works fine
    Given request payload is provided with "<name>" and "<phonenumber>"
    And user calls "AddPlaceApi" place api with "POST" method
    Then api call got success code with 200
    And validate the "scope" and "APP"
    And user calls "GetPlaceApi" place api with "GET" method
    Then user validates the "<name>"

    Examples:
    |name|phonenumber|
    |neeranjan|9123549320   |
    |Sangu  |   9095158420     |