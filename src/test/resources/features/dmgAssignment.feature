@dmgAssignment
Feature: DMG Home Assignment scenarios

  Scenario: DMG Home Assignment
    Given I have navigated to the Daily Mail Main site
    Then the date will be correct
    When I navigate to the Sport menu
    Then the secondary navigation will open
    When I click into the Football sub-category
    And I click the first article
    And I go to the article's gallery
    Then the previous and next icon will be present
    When I click next in the gallery
    Then the counter changes to 2
    When I close the gallery view
    And I hover over the gallery
    And I click facebook on the gallery
    Then the facebook dialog will open
    When I click the fullscreen icon on the embedded video
    Then the video will change size
    When I click the fullscreen icon on the embedded video
    Then the video will change size
    When I navigate to Liverpool in the league table
    Then the points and position will be displayed