@admin
Feature: Admin

Background:
  Given Admin is logged in
  And Admin is on the home page

#Admin creates a product positive
Scenario:
  Given Admin is on the home page
  When Admin clicks edit products
  And Admin clicks on create new product
  And Admin fills in name "Product Name"
  And Admin fills in description "Product Description"
  And Admin fills in image URL "https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554__340.jpg"
  And Admin fills in price "12.00"
  Then Admin clicks create product
  Then Product screen should be up
#Admin creates a product negative
Scenario Outline:
  Given Admin is on the home page
  When Admin clicks edit products
  And Admin clicks on create new product
  And Admin fills in name "<name>"
  And Admin fills in description "<description>"
  And Admin fills in image URL "<imageURL>"
  And Admin fills in price "<price>"
  Then Admin clicks create product
  Then Notification for missing "<error>" should appear
Examples:
  |name         |description         |imageURL                                                          |price|error       |
  |             |Product Description |https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554__340.jpg|12   |name        |
  |Product Name |                    |https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554__340.jpg|12   |description |
  |Product Two  |Product Two Desc    |                                                                  |13   |imageURL    |
  |Product Three|Product Three Desc  |https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554__340.jpg|     |price       |

#Admin edits a product positive
Scenario:
  Given Admin is on the home page
  When Admin clicks edit products
  And Admin fills in name "Moar catz"
  And Admin fills in description "This catz fur sal"
  And Admin fills in image URL "https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554__340.jpg"
  And Admin fills in price "999"
  And Admin clicks update
  And Admin clicks create product
  Then Product should update name with "Moar catz"
  And description with "This catz fur sal"
  And image with "https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554__340.jpg"
  And price with "999"
#Admin edits a product negative