# BankID BankAxept – Technical Case Interview – Fullstack Developer

Welcome to the technical case interview for the fullstack developer position at BankID BankAxept AS. This document contains the following sections:

* **Your tasks** – outlines the problems we would like you to solve.
* **Our expectations** – lays out our expectation so it’s clear where you should focus your time.
* **How we review** – We want to be open about how we’re assessing our candidate’s solutions, this helps us maintain consistency as well as provides you with further clarity about what we are looking for
* **Open ended questions** we may discuss during the interview – gives pointers around the kind of questions we may ask during the assessment.

## Table of Contents

* [Your tasks](#your-tasks)
  * [Task A: Implementing business logic in the Java Spring Boot REST API](#task-a-implementing-business-logic-in-the-java-spring-boot-rest-api)
    * [API Documentation](#api-documentation)
    * [Product Catalog](#product-catalog)
    * [Requirements](#requirements)
  * [Task B: Frontend styling and logic using Svelte and SvelteKit](#task-b-frontend-styling-and-logic-using-svelte-and-sveltekit)
    * [Requirements](#requirements-1)
* [Our expectations](#our-expectations)
* [How we review](#how-we-review)
* [Open ended questions we may discuss during the interview](#open-ended-questions-we-may-discuss-during-the-interview)


## Your tasks

We have provided you with a starting project which implements a Web Application and a correcponding REST API that simulates a Ecommerce application.

Your task is split into two parts.

* Task A: Implementing business logic in the Java Spring Boot REST API
* Task B: Frontend styling and logic using Svelte and SvelteKit

You can choose to do them in any order you like, but we recommend to start with the task you are most comfortable with.

### Task A: Implementing business logic in the Java Spring Boot REST API

The Ecommerce API exposes a single endpoint that performs a checkout operation that takes a list of products and return the total cost - with any discounts applied.

**Your task is to implement the business logic for the checkout operation following the requirements below.**

The API is implemented using Spring Boot and Java 17. You can find the source code in the [./ecommerce-api](./ecommerce-api/) folder.

_NOTE: If you prefer to implement the API in another language, you are free to do so. You can either implement the API in another folder in this repository or create a new repository and send us the link._

### API Documentation

#### Request
```http request
POST /api/v1/checkout
Accept: application/json
Content-Type: application/json

["0001", "0004"]
```

#### Response
```http response
HTTP/1.1 200 OK
Content-Type: application/json
    
{"price": 1030.00}
```

### Product Catalog

|Product ID|Name|Price|Discount|
|---|---|---|---|
|0001|Rolex Watch|1000.00|3 for 2000.00|
|0002|Michael Kors Purse|80.00|2 for 120.00|
|0003|iPhone XS|400.00||
|0004|Casio Watch|30.00||


### Requirements

There are a few requirements to take into consideration:

* Product may have an applicable discount. For example, if the user attempts to checkout three or six Rolex watches, they will receive the discount price once or twice, respectively.
* There is no limit to the number of items or combinations of products a user can checkout.
* There is no limit to the number of times a discount can be used.
* Similarly, a user can checkout a single item if they wish.

### Task B: Frontend styling and logic using Svelte and SvelteKit

The web app is built using [SvelteKit](https://kit.svelte.dev/). You can find the source code in the root of the repository.

_NOTE: If you prefer to implement the frontend in another framework, you are free to do so. You can either implement the frontend in another folder in this repository or create a new repository and send us the link._

The web app is a simple ecommerce app that allows the user to add products to a cart and get the total price, including discounts.

There are some problems with the current implementation:

* The current items in the cart are not shown and it is not possible to remove items from the cart.
* The user need to press a button to calculate the total price of the cart.
* The user interface is not styled. We have provided a [design in Figma](https://www.figma.com/file/VjvlYsZCoHNObTOk3OlCAn/BIDBAX-Tech-Interview-Assignment-Project-Tyr---Checkout?type=design&mode=design&t=cQyrqv3MRSe3R75V-1) that you can use as a reference.

### Requirements

**Your task is to implement the following requirements**

1. Implement logic to show the added products in the cart.
2. Implement logic to show the total price of the cart on every cart update. 
   * The total price should be calculated on the backend using the Ecommerce API
   * You need to change the logic from clicking a button to automatically calculate the total price when the cart is updated.
3. To the best of your ability (and time!), style the user interface as close as possible to the [given design in figma](https://www.figma.com/file/VjvlYsZCoHNObTOk3OlCAn/BIDBAX-Tech-Interview-Assignment-Project-Tyr---Checkout?type=design&mode=design&t=cQyrqv3MRSe3R75V-1).

## Our expectations

We expect you to spend around 3-5 hours on this assignment. We are not expecting you to finish all the tasks, as we don’t want this task to take over your evenings - nor do we want to impose an unnecessarily stressful deadline.

How you approach the problem is more important to us than completing the challenge, therefore we expect you to include the following:
* An ANSWER.md file that describes how you approached the problem and what you would improve if you were given more time
* Whether you are submitting your solution via Github or compressing the solution into one zip file, we would appreciate if you include the .git folder with your commit history. This provides us with a view on how you break down problems and how you incrementally work your way towards the final solution.
* Automated testing is an important part of how we work in BankID High & OIDC team, so we expect you include some in your solution.

## How we review

When reviewing your solution, we try to make sure we’re consistent in our evaluation by following five core themes:
* **Correctness** – We don’t expect you to handle all possible edge cases, but we do expect the solution to adhere to the core requirements laid out in this document.
* **Documentation** – For us, this is more about what you choose to document, and the commit history, and less about covering the codebase in comments.
* **Testing** – We also evaluate your approach to automated testing and whether there’s a reasonable mix of functional (or integration) tests and unit tests.
* **Readability** – Writing code in a team requires having empathy for how other team members will interpret that code. Here we look for things like duplication, method names, variable names, and consistency.
* **Application architecture** – We look at whether the solution follows a conventional architecture based on the language and framework. We also expect to see some modularization with a few separate components that have clear responsibilities.

## Open ended questions we may discuss during the interview

* What would you do differently if you had more time?
* What was your experience in working with these technologies? Did you learn anything new?
* What was the most challenging part of the assignment?
* How would you implement CI/CD?
* Where would you deploy this application and why? Which option do you prefer over others?
* What testing did you do and why?
* Handling edge cases
* Securing the API
* Scalability
* Availability

Thank you for reading and thanks for taking part in our interview process. We look forward to receiving your solution.

The BankID High Engineering Team.

