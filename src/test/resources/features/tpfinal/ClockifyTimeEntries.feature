@TPFinal @TimeEntries
Feature: Time Entries CRUD

  Background:
    Given I have the account in Clockify with the X-Api-Key created
    And I have the Workspace Id

  @Get @UserTimeEntries @Success @Smoke  @Now
  Scenario Outline: (A) Get all the time entries of the user correctly
    And I have the User Id
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And status code <status> is obtained
    Then I get in response all the time entries for the user
    Examples:
      | operation | entity       | jsonName               | status |
      | GET       | TIME_ENTRIES | timeEntries/get_all_rq | 200    |

  @Post @NewTimeEntry @Success @Smoke
  Scenario Outline: (B) Post a new time entry
    And I have the User Id
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And status code <status> is obtained
    Then I validate that the new time entry was saved correctly
    Examples:
      | operation | entity       | jsonName                | status |
      | POST      | TIME_ENTRIES | timeEntries/post_new_rq | 201    |

  @Put @EditTimeEntry @Success @Smoke
  Scenario Outline: (C) Put changes for an existing time entry
    And I have the User Id
    And I have the Time Entry Id
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And status code <status> is obtained
    Then I validate that the time entry was modified correctly
    Examples:
      | operation | entity       | jsonName                   | status |
      | PUT       | TIME_ENTRIES | timeEntries/put_changes_rq | 200    |

  @Delete @DeleteTimeEntry @Success @Smoke
  Scenario Outline: (D) Delete an existing time entry
    And I have the User Id
    And I have the Time Entry Id
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And status code <status> is obtained
    Then I validate that the time entry was deleted correctly
    Examples:
      | operation | entity       | jsonName              | status |
      | DELETE    | TIME_ENTRIES | timeEntries/delete_rq | 204    |