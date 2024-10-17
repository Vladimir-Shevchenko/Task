Task

Create and publish an API in SpringBoot.

Create a POJO called Article with attributes:

id

description

weight

volume

Create methods to create, delete and update a specific item.

The business logic must be implemented in a class called for example ArticleManagerImpl, which must implement an interface called ArticleManager.

Make @Autowired for dependency injection. Since there is not much code to do, using dependency injection is not easy. Try to make an extra component.

Don't use a database. When you create an item, for example, just create the object, don't actually insert it.

Implement some unit testing with JUnit

Run the API and do some tests from postman