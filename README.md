[# Petstore RestAssured API testing 

Below I have provided the project structure, how to run the project, scenarios covered and improvements I would do in the future, in addition the same project has been provided in Postman


## Project Structure

```
petstore-restassured-testng-API/
├── pom.xml
├── README.md
└── src/
    └── test/
        └── java/
            └── PetstoreApiTests.java
```

---

##How to Run

2. Navigate to the project directory > srv > test > java and Run PetstoreAPITests
---

**Covered Scenarios**

### Anything about your Pets scenarios
- Create a new pet
- Update a pet
- Delete a pet

### Orders
- Create an order
- Update (simulate re-post)
- Delete an order

### Users operations
- Create a user
- Update user
- Delete user

---
## Improvements

- Similar to UI automation - provide scenarios in BBD
- JSON schema validations
- Negative test cases and provide full coverage of asked scenarios
- Detailed reports what scenario steps pass/fail
- CI/CD integration - whenever a change is pushed
- Data-driven tests
- add common variables to the config file


##  Challenges
- adding tests in order - due hardcoded - it involved duplicate test data to update / post / delete data without breaking existing tests


## Project Structure in postman

```
Petsore API demo
├── Everything about your pets
    ├── post
        └── 200
        └── 400
        └── 404
    └── Get
        └── 200
        └── 400
        └── 404
    └── Update
        └── 200
        └── 400
        └── 404
    └── Delete
        └── 200
        └── 400
        └── 404
        
├── Acess Petstore order
    ├── post
        └── 200
        └── 400
        └── 404
    └── Get
        └── 200
        └── 400
        └── 404
    └── Update
        └── 200
        └── 400
        └── 404
    └── Delete
        └── 200
        └── 400
        └── 404
├── User Operations
    ├── post
        └── 200
        └── 400
        └── 404
    └── Get
        └── 200
        └── 400
        └── 404
    └── Update
        └── 200
        └── 400
        └── 404
    └── Delete
        └── 200
        └── 400
        └── 404
```
