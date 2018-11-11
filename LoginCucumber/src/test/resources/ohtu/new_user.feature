Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation is successful with valid username and password
    Given command new user is selected
    When username "user" and password "userpass123" are entered
    Then system will respond with "new user registered"

  Scenario: creation fails with already taken username and valid password
    Given command new user is selected
    And username "user" and password "userpass123" are entered
    And command new user is selected
    When username "user" and password "userpass123" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with too short username and valid password
    Given command new user is selected
    When username "us" and password "userpass123" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and too short password
    Given command new user is selected
    When username "user" and password "userpa1" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and password enough long but consisting of only letters
    Given command new user is selected
    When username "user" and password "userpassword" are entered
    Then system will respond with "new user not registered"

  Scenario: can login with successfully generated account
    Given command new user is selected
    And username "eero" and password "salainen1" are entered
    And command login is selected
    When username "eero" and password "salainen1" are entered
    Then system will respond with "logged in"
