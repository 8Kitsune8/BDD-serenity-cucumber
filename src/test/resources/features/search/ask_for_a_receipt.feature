Feature: Ask for a receipt

  Background:
    Given Sarah has a Caffeinate-Me account

  Scenario: Order several items
    Given Sara has ordered:
      | Quantity | Product          |
      | 1        | large cappuccino |
      | 1        | muffin           |
    When she asks for a receipr
    Then she should receive a receipt totalling:
      | Subtotal | Service Fee | Total |
      | 3.50     | 0.18        | 3.68  |