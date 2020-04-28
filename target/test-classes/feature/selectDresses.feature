Feature: Adding to Cart

Scenario Outline:  Testing of adding the product to the cart
Given user login to the page successfully with valid credentials
When select all the product type with given value <catagory>, dress type <dressType>, name <productName> and price <price>
And click on add to cart and continue shoppting
Then catagory and dress type selected successfully

Examples:
|catagory     		|dressType				|productName			|price  	|
|WOMEN				|Summer Dresses			|Printed Chiffon Dress	|16.40		|






