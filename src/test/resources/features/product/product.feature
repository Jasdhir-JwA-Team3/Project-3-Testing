@product
Feature: Product

	Background:
  		Given User is logged in
  		And User is on the home page

	# CHECK PRODUCT(S)
	Scenario: Check product list
  		Then User should see products

	# VIEW PRODUCT
	Scenario Outline: View Selected Product in Expanded Mode
  		When User views "<product>"
  		And Expands the product
  		Then User should be on "<product_url>"
  		And User confirms name "<product_name>"
  		And User confirms description "<product_desc>"
  		And User confirms prices "<product_price>"
	  Examples:
  		| product 	   | product_url 					  | product_name | product_desc 			  	  | product_price |
  		| headphone    | http://localhost:3000/products/1 | Headphones   | A nice pair of headphones 	  | Price: $20.00 |
  		| teeshirt	   | http://localhost:3000/products/2 | TeeShirt	 | A nice TeeShirt 		  	   	  | Price: $45.00 |
  		| shopping bag | http://localhost:3000/products/3 | Shopping Bag | A reusable shopping bag   	  | Price: $2.50  |
  		| hat		   | http://localhost:3000/products/4 | Hat			 | A fancy cap for a fancy person | Price: $10.00 |
  		| coat		   | http://localhost:3000/products/5 | Coat		 | A nice coat 				   	  | Price: $80.00 |

	# FILTER PRODUCT
	Scenario Outline: Product filter positive
  		When User search "<real_product>"
  		Then Product should be visible
	  Examples:
  		| real_product |
  		| headphones   |
  		| teeshirt	   |
  		| shopping bag |
  		| hat		   |
  		| coat		   |

	Scenario Outline: Product filter negitive
  		When User search "<fake_product>"
  		Then Product should not be visible
	  Examples:
  		| fake_product |
  		| icecream	   |
  		| cup		   |
  		| speaker	   |
  		| dog toy	   |
  		| chair 	   |

	#PRODUCT REVIEW
  @ProductReview
  	Scenario Outline: Create review
	  	When User views "<product>"
	  	And User selects star rating
  		And User enter review "<review>"
  		Then User clicks "submit review" button
		When User finds product review
		And User clicks "delete" button
		Then Product review should be deleted

	  Examples:
	  | product 	 | review |
	  | headphone 	 | This is a great product! |
	  | teeshirt 	 | This is a great product! |
	  | shopping bag | This is a great product! |
	  | hat 		 | This is a great product! |
	  | coat 		 | This is a great product! |
