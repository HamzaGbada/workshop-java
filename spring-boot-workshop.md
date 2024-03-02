---
_class: lead
paginate: true
backgroundColor: #fff
#backgroundImage: url('https://marp.app/assets/hero-background.svg')
auto-scaling: true
---

[//]: # (![bg left]&#40;https://marp.app/assets/marp.svg&#41;)

# Workshop on Spring Boot

Hamza Gbada


---

# Contents

1. Introduction to Spring Boot
2. Exploring Spring Boot
3. JPA: Simplifying Data Persistence in Java Applications
4. Building RESTful API with Spring Boot
5. Demo: Building an Application with Spring Boot
   - Introduction to 3-tier Architecture
   - Coding the 3-tier Application
   - Building and Deploying the 3-tier Application
6. References


---

### Introduction to Spring


The **Spring Framework** is an **open-source** framework for building Java applications. It provides comprehensive infrastructure support for developing enterprise Java applications. Spring's core feature is **dependency injection**, which helps manage object dependencies and promotes loose coupling between components.

---

| Year | Description                                                                        |
|------|------------------------------------------------------------------------------------|
| 2002 | Created as an alternative to J2EE frameworks.                                      |
| 2004 | First version (1.0) released with IoC and AOP features.                            |
| 2006 | Version 2.0 released with Java 5 features (annotations, generics).                 |
| 2009 | Version 3.0 released with emphasis on annotation-based configuration.              |
| 2013 | Version 4.0 released with enhanced Java 8 support and introduction of Spring Boot. |


---

### Exploring Spring Boot

**Spring Boot** is a Java-based framework that simplifies the development of stand-alone, production-grade applications using the Spring Framework.

Spring Boot automates common tasks, such as dependency management, application setup, and embedded server configuration, allowing developers to focus more on writing business logic and less on infrastructure concerns.

---

| Year               | Description                                                                                  |
|--------------------|----------------------------------------------------------------------------------------------|
| 2013               | Introduced to simplify Spring application development.                                       |
| 2014               | First stable release (1.0) with auto-configuration, etc.                                     |
| 2016               | Version 1.4 released with improvements in metrics, testing, and logging.                     |
| 2017               | Version 2.0 released with compatibility for Spring Framework 5 and Java 9.                   |
| 2020               | Version 2.3 released with startup actuator endpoints, improved metrics, and GraalVM support. |

---

| Year               | Description                                                                                                                                  |
|--------------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| 2022               | Version 2.7: Improved reactive programming support, enhanced developer experience with Spring Native and Micrometer enhancements             |
| Nov 2022           | Version 3.0.0: Major improvements to reactive programming framework, introduction of reactive web client for non-blocking HTTP communication |
| May 2023 - Present | Version 3.1.x: Continued focus on reactive programming features, security enhancements                                                       |
| Nov 2023 - Present | Version 3.2.x: Further improvements in reactive programming and cloud integration, continued focus on security and performance               |

---


### JPA: Simplifying Data Persistence in Java Applications

JPA, the Java Persistence API, acts as a bridge between Java objects and relational databases, making data storage and retrieval more seamless. Key features include:

- **Object-Relational Mapping (ORM):** Maps Java classes to database tables and properties to columns, simplifying data storage.
- **Annotations vs. XML:** Uses annotations for mapping details, offering a concise and maintainable approach over XML.
- **Querying with JPQL:** Allows writing queries against mapped objects using Java Persistence Query Language (JPQL), similar to SQL.
- **Relationships and Transactions:** Supports modeling relationships between entities and manages transactions for data consistency.

Benefits of JPA include improved productivity, reduced boilerplate code, database independence, and simplified data access.

---
#### ORM vs JPA vs Hibernate

- **ORM (Object-Relational Mapping):**
   - Concept: Maps objects in an object-oriented language (like Java) to relational database tables.
   - Functionality: Provided by frameworks such as Hibernate and JPA.
   - Example: Maps a `Customer` Java class to a `customers` table in the database.

---

- **JPA (Java Persistence API):**
   - **A Java Specification**: Defines standard interfaces and annotations for ORM frameworks.
   - Benefits: Promotes consistency and interoperability between ORM implementations.
   - Example: Both Hibernate and EclipseLink are JPA-compliant frameworks.

---

- **Hibernate:**
   - Framework: Popular open-source ORM framework implementing JPA.
   - Functionality: Provides ORM features, query language (JPQL), and transaction management.
   - Relationship: Can be used directly or via Spring Data JPA, which builds upon JPA.

---

- **Summary:**
   - ORM maps objects to databases.
   - JPA standardizes ORM implementations in Java.
   - Hibernate is a framework implementing JPA, offering additional features.

---

### Building RESTful API with Spring Boot

#### What is REST API ?

**Representational State Transfer (REST)**: REST is an architectural style that emphasizes a stateless client-server relationship. It utilizes standard HTTP methods (GET, POST, PUT, DELETE) to perform operations on resources identified by URLs.

---

1. **Stateless Communication:** RESTful APIs enable stateless communication between clients and servers, where each request contains all necessary information for the server to fulfill it.

2. **HTTP Methods:** They utilize standard HTTP methods like GET, POST, PUT, and DELETE to perform CRUD operations on resources identified by unique URLs.

3. **Resource-Based Architecture:** Resources are identified by URIs and manipulated using representations, typically in JSON or XML format.

4. **Uniform Interface:** REST APIs maintain a uniform and predictable interface, promoting simplicity, scalability, and ease of use for clients.

5. **Common Use Cases:** RESTful APIs are widely used for building web services, enabling communication between different systems, and facilitating the development of microservices architectures.

---

**Example:**

Consider a simple RESTful API for managing a collection of books. 

```java
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // POST create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        return ResponseEntity.created(location).body(savedBook);
    }

    // PUT update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    // DELETE delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

```

---

### Demo: Building an Application with Spring Boot

**Dependency Injection in Spring Boot:**

1. **Definition**:
   - Dependency Injection (DI) is a design pattern implemented in Spring Boot where the framework manages the creation and injection of dependencies into a class or component.

2. **Inversion of Control (IoC)**:
   - IoC is a core principle of Spring Boot where control of object creation and lifecycle is shifted from the application code to the Spring framework.

---

3. **Decoupling Components**:
   - DI helps in decoupling components by removing the responsibility of creating dependencies from the dependent classes.

4. **Configuration through Annotations**:
   - Spring Boot uses annotations like `@Autowired` and `@Component` to configure and inject dependencies automatically.

5. **Benefits**:
    - Enhances modularity and testability by promoting loose coupling between components.
    - Simplifies configuration and management of dependencies, improving code readability and maintainability.
---
**Type of Injection**

1. **Constructor Injection**:
   - Constructor injection involves passing dependencies as parameters to a class constructor. Spring Boot automatically injects the required dependencies when creating instances of the class.

```java
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

---

2. **Setter Injection**:
   - Setter injection involves providing setter methods in a class for dependencies to be set. Spring Boot uses setter methods annotated with `@Autowired` to inject dependencies.

```java
@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
```

---

3. **Field Injection**:
   - Field injection involves directly injecting dependencies into class fields. Spring Boot allows using the `@Autowired` annotation directly on class fields to achieve dependency injection.

```java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
}
```

---

#### Introduction to 3-tier Architecture

## Introduction to 3-Tier Architecture

The 3-tier architecture, also known as three-layered architecture, is a fundamental **design pattern** for building scalable and maintainable software applications. It separates the application into three distinct logical and often physical tiers:
**1. Presentation Layer (REST API Layer)**
**2. Service Layer (Business Logic Layer)**
**3. Data Access Layer (Persistence Layer)**

---

![img_2.png](img_2.png)

---

**1. Presentation Layer (REST API Layer):**
- **Function:** Handles user requests and responses, acting as a bridge between users and the application.
- **Components:** Web controllers, mobile app elements, or desktop UI components.
- **Responsibilities:**
    - Receives and validates user input.
    - Communicates with the service layer for data manipulation.
    - Formats and presents data in desired formats like JSON or HTML.

---

**2. Service Layer (Business Logic Layer):**
- **Function:** Houses the core business logic, enforcing rules and processing data.
- **Components:** Services, business logic modules, and domain objects.
- **Responsibilities:**
    - Implements business rules and logic.
    - Coordinates data operations with the data access layer.
    - Validates and enforces application-specific rules.

---

**3. Data Access Layer (Persistence Layer):**
- **Function:** Handles data storage and retrieval from the database, shielding complexities from other layers.
- **Components:** Database access objects (DAOs), repositories, and data access frameworks like JPA.
- **Responsibilities:**
    - Establishes connections to the database.
    - Translates service requests into database operations.
    - Retrieves and persists data.
    - Manages exceptions and error handling related to data access.

---

**Benefits of 3-Tier Architecture:**
- **Improved Maintainability:** Clear separation makes parts of the application easier to modify and test independently.
- **Increased Scalability:** Each tier can be scaled according to its specific requirements, allowing for efficient resource allocation.
- **Enhanced Reusability:** Business logic can be reused across different presentation layers, promoting code efficiency.
- **Clear Separation of Concerns:** Each layer has distinct responsibilities, leading to a more organized codebase and easier troubleshooting.

---


#### Coding the 3-tier Application

## Spring Boot Application - Association Management

**1. Project Description:**

Develop a simple Spring Boot application to manage an association's members and events.

---

**2. Functional Requirements:**

* **Member Management:**
    * Create new members with details like name, contact information, and membership type.
    * View a list of all members with basic information.
    * Search for members by name or contact information.
    * Edit existing member details.
    * Delete members (consider deactivation instead of permanent deletion).
* **Event Management:**
    * Create new events with details like title, description, date, and time.
    * View a list of upcoming events.
    * Search for events by title or date.
    * Edit existing event details.
    * Delete upcoming events (consider archiving events instead of permanent deletion).

---

**3. Non-Functional Requirements:**

* **Database:** Use an in-memory database like H2 for development and consider migration to a more robust database for production.
* **Error Handling:** Implement proper error handling and provide meaningful messages to the user.

---

#### Building and Deploying the 3-tier Application

Deploying a Spring Boot application involves building a deployable artifact, such as a JAR (Java Archive) or a WAR (Web Archive), and then deploying it to a server or a cloud platform. Below are the steps to deploy a Spring Boot app and how to build a JAR:

---

##### Building a JAR for Deployment:

1. **Configure Your Spring Boot Application:**
    - Ensure that your Spring Boot application is correctly configured and functional. This includes setting up dependencies, defining application properties, and configuring any necessary components.

---

2. **Add Spring Boot Maven Plugin:**
    - In your `pom.xml` file, include the Spring Boot Maven Plugin if you're using Maven:
      ```xml
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
          </plugins>
      </build>
      ```
    - This plugin allows you to package your Spring Boot application as an executable JAR file.

---

3. **Build the JAR:**
    - Run the Maven command to build the JAR:
      ```shell
      mvn clean package
      ```
    - This command compiles your project, runs tests, and packages the application into a JAR file.

4. **Locate the JAR File:**
    - Once the build process is complete, you can find the JAR file in the `target` directory of your project.

---

##### Deploying the Spring Boot Application:

1. **Choose a Deployment Environment:**
    - Determine where you want to deploy your Spring Boot application. This could be a local server, a cloud platform like AWS or Heroku, or a containerized environment like Docker.

2. **Transfer the JAR File:**
    - Copy the generated JAR file to the deployment environment. You can use tools like SCP, FTP, or file sharing services for this purpose.

---

3. **Run the JAR:**
    - Once the JAR file is on the server, you can run it using the Java command:
      ```shell
      java -jar your-application.jar
      ```
    - Replace `your-application.jar` with the name of your JAR file.

4. **Access the Application:**
    - Once the application is running, you can access it using the appropriate URL or IP address, depending on your deployment environment and network configuration.



---

### References
- Ben Salah, D. (n.d.). Programming Frameworks. tahabensalah.net. Retrieved March 1, 2024, from https://tahabensalah.net/edu/fwk.pdf
- Lamouchi, N. (n.d.). Playing with Java Microservices on Kubernetes and OpenShift. Nebrass Lamouchi. http://books.google.ie/books?id=Fk6FDwAAQBAJ&printsec=frontcover&dq=Playing+with+Java+Microservices+on+Kubernetes+and+OpenShift&hl=&cd=1&source=gbs_api