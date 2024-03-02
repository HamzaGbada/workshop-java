---
_class: lead
paginate: true
backgroundColor: #fff
#backgroundImage: url('https://marp.app/assets/hero-background.svg')
auto-scaling: true
---

[//]: # (![bg left]&#40;https://marp.app/assets/marp.svg&#41;)

# Workshop on Java Development

Hamza Gbada

---

# Contents

1. Introduction to Java: Understanding JVM, JDK, and JRE
2. Maven Project Management
3. Classes, Constructors, Getters, and Setters
4. Object-Oriented Programming Essentials
    - Classes and Objects
    - Abstract Classes and Interfaces
5. Polymorphism
6. Introduction to Design Patterns


---

## **Understanding Java Basics**

**JVM, JDK, and JRE ?**

* The Java Virtual Machine (JVM): A software program that executes Java bytecode (compiled code).
* The Java Development Kit (JDK): Includes the JVM, compiler, tools, and libraries for developing Java applications.
* The Java Runtime Environment (JRE): Includes the JVM and libraries needed to run Java applications.

---

![img_1.png](img_1.png)

---

**Maven Project Management**

* Maven is a build automation tool that simplifies project management by:
    * Standardizing project structure and dependencies.
    * Automating compilation, testing, and packaging.
    * Simplifying project lifecycle management.

---

**Classes, Constructors, and Getters/Setters**

* Classes: Blueprints for creating objects, defining their attributes (properties) and behaviors (methods).
* Constructors: Special methods that initialize an object's attributes when it's created.
* Getters and Setters: Methods that allow controlled access to and modification of an object's attributes.

---
**Example:**

```java
public class Student {
    // Fields or attributes
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
}
```

---

**Object-Oriented Programming Essentials**


* Classes and Objects: As discussed, classes define data and behavior, while objects are instances of those classes.
* Inheritance: Allows creating new classes (subclasses) that inherit attributes and methods from existing classes (superclasses).
* Abstract Classes and Interfaces: Define incomplete blueprints that subclasses must inherit and implement fully.

---

**Inheritance in Java**

In Java, inheritance is a fundamental object-oriented programming (OOP) concept that allows you to create hierarchical relationships between classes, enabling code reuse, flexibility, and maintainability. It's the cornerstone of OOP, fostering well-organized and efficient class structures.

---

**Key Concepts:**

- **Superclass:** A more general class that serves as the foundation for inheritance.
- **Subclass:** A more specific class that inherits properties and methods from a superclass.
- **Inheritance is "is-a" relationship:** A subclass is "a type of" its superclass.
- **Method overriding:** Subclasses can override methods inherited from the superclass to provide custom behavior.
- **Constructor chaining:** When a subclass constructor is called, it implicitly calls the superclass constructor first.

---

**Example:**

```java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void login() {
        System.out.println("User logged in successfully!");
    }
}
```
This `User` class encapsulates common attributes (name, email) and behaviors (login) applicable to users of a system.

---

```java
public class Student extends User {
    private String major;
    private int year;
    public Student(String name, String email, String major, int year) {
        super(name, email); // Call superclass constructor for common attributes
        this.major = major;
        this.year = year;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    // Override the login method to provide student-specific behavior
    @Override
    public void login() {
        super.login(); // Call superclass login first
        System.out.println("Student has also authenticated for access to student resources.");
    }
}
```
The `Student` class inherits from `User` (is-a `User`), gaining access to its attributes and methods. It adds student-specific attributes (major, year) and overrides the `login` method to provide additional actions.

---

```java
public class Teacher extends User {
    private String department;
    private List<String> coursesTaught;
    public Teacher(String name, String email, String department, List<String> coursesTaught) {
        super(name, email); // Call superclass constructor for common attributes
        this.department = department;
        this.coursesTaught = coursesTaught;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public List<String> getCoursesTaught() {
        return coursesTaught;
    }
    public void setCoursesTaught(List<String> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }
    // Override the login method to provide teacher-specific behavior
    @Override
    public void login() {
        super.login(); // Call superclass login first
        System.out.println("Teacher has also authenticated for access to teacher resources.");
    }
}
```
---

The `Teacher` class inherits from `User` and adds teacher-specific attributes (department, coursesTaught) and overrides the `login` method for custom behavior.

**Explanation:**

- `Student` and `Teacher` inherit common attributes (name, email) and behavior (`login`) from `User`, demonstrating code reuse.
- They add specific attributes and behaviors, tailoring the classes to their roles.

---

**Example: Class vs Abstract Class**
1. **Abstract Class**:
    - An abstract class can have abstract methods (methods without a body) and concrete methods.
    - Abstract methods are declared without implementation and must be implemented by the subclass.
    - Abstract classes cannot be instantiated directly; they are meant to be extended by subclasses.

---

In the `Shape` class, `calculateArea()` is an abstract method, lacking implementation in the `Shape` class itself. Concrete subclasses extending `Shape` must implement `calculateArea()`. Additionally, `Shape` contains concrete methods like `getColor()`, offering shared functionality accessible to subclasses.
```java
public abstract class Shape {
    private String color;
    public Shape(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    // Abstract method: subclasses must implement this
    public abstract double calculateArea();
}
```
---

2. **Regular Class**:
    - All methods defined in a regular class are fully implemented.
    - Objects of a regular class can be instantiated using the `new` keyword.

```java
public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
```

---

**Key Differences**:
- An abstract class can have both abstract and concrete methods, whereas a regular class can only have concrete methods.
- Abstract classes cannot be instantiated directly, while regular classes can be.
- Subclasses of an abstract class must provide implementations for all abstract methods, whereas subclasses of a regular class inherit all methods and may override them if needed.

---
**Example: Abstract Class vs Interface**

**Interface Example:**
```java
interface Animal {
    void sound(); // Method declaration
    void eat(); // Method declaration
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
    public void eat() {
        System.out.println("Dog is eating...");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("Cat meows");
    }
    public void eat() {
        System.out.println("Cat is eating...");
    }
}
```

---

**Explanation:**
- **Interface `Animal`**: Defines method declarations without implementations.
- **Classes `Dog` and `Cat`**: Implement the `Animal` interface and provide implementations for all methods declared in the interface.

---

**Abstract Class Example:**

```java
abstract class Animal {
    abstract void sound(); // Abstract method
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}
```

---

**Explanation:**
- **Abstract class `Animal`**: Defines an abstract method `sound()` and a concrete method `eat()`.
- **Subclasses `Dog` and `Cat`**: Extend the abstract class `Animal` and provide implementations for the `sound()` method.

---
**Differences:**

|                    | Abstract Class                        | Interface                                          |
|--------------------|---------------------------------------|----------------------------------------------------|
| Abstract Methods   | Allows abstract and concrete methods. | Limited to method declarations (abstract methods). |
| Constructors       | Permits constructors.                 | Does not allow constructors.                       |
| Instance Variables | Allows instance variables (fields).   | Doesn't permit instance variables (fields).        |

---

|                    | Abstract Class                                                     | Interface                                    |
|--------------------|--------------------------------------------------------------------|----------------------------------------------|
| Inheritance        | Supports **single** inheritance from abstract or concrete classes. | Allows **multiple** interface inheritance.   |
| Implementation     | Provides partial class implementation.                             | Defines a contract for implementing classes. |
| Method Inheritance | Facilitates method overriding and overloading.                     | Enables multiple method inheritance.         |

---

## **Polymorphism**
Polymorphism in Java allows objects of different classes to be treated as objects of a common type. There are two types of polymorphism in Java: **compile-time polymorphism** (method overloading) and **runtime polymorphism** (method overriding)

---

#### 1. Compile-Time Polymorphism (Method Overloading):

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
    String add(String a, String b) {
        return a + b;
    }
}
public class PolymorphismExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Method Overloading
        int result1 = calculator.add(5, 10);
        double result2 = calculator.add(3.5, 7.2);
        String result3 = calculator.add("Hello", "World");
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
    }
}
```

---

**Explanation:**
- The `Calculator` class has three `add` methods with different parameter types.
- The `main` method demonstrates method overloading by calling each version of the `add` method with different argument types.
- The same method name is used for different types of parameters.

---

#### 2. Runtime Polymorphism (Method Overriding):

```java
class Animal {
    void makeSound() {
        System.out.println("Generic Animal Sound");
    }
}
class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    void makeSound() {
        System.out.println("Cat meows");
    }
}
public class PolymorphismExample {
    public static void main(String[] args) {
        Animal animal1 = new Dog(); // Upcasting
        Animal animal2 = new Cat(); // Upcasting
        // Method Overriding
        animal1.makeSound(); // Calls Dog's makeSound
        animal2.makeSound(); // Calls Cat's makeSound
    }
}
```
---

**Explanation:**
- The `Animal` class has a `makeSound` method.
- The `Dog` and `Cat` classes override the `makeSound` method.
- In the `main` method, objects of `Dog` and `Cat` are assigned to references of type `Animal` (upcasting).
- The `makeSound` method is called on each `Animal` reference, and the overridden version in the actual object's class is executed.

---

## **Introduction to Design Patterns**

* Design patterns are proven solutions to common programming problems, promoting:
    * Code reusability.
    * Maintainability.
    * Flexibility.

---
**Example:**

 **Singleton pattern:**
The Singleton Pattern ensures that a class has only one instance and provides a global access point to that instance. It's useful for managing shared resources or global state. The pattern restricts instantiation of a class to a single object, controlled by a static method, ensuring consistent access and resource management throughout the application.

```java
public class Database {
    private String name;
    private int creds;
    private static Database instance;
    private Database(String name, int creds) {
        this.name = name;
        this.creds = creds;
    }
    public static Database getInstance(String name, int creds){
        if(instance == null){
            instance = new Database(name, creds);
        }
        return instance;
    }   
}
```
---

### Explanation:

1. **Private Constructor:**
    - The `Database` class has a private constructor, meaning it cannot be instantiated from outside the class. This prevents other classes from creating instances of `Database` directly.

2. **Static Instance Variable:**
    - The class contains a static variable named `instance` of type `Database`. This variable holds the single instance of the class that is created.

---

3. **getInstance() Method:**
    - The `getInstance()` method is a static method responsible for providing access to the single instance of the `Database` class.
    - It first checks if the `instance` variable is `null`. If it is, it creates a new instance of the `Database` class using the private constructor.
    - If the `instance` variable is not `null`, it simply returns the existing instance.

---

### Example Usage:

```java
public class SingletonExample {
    public static void main(String[] args) {
        Database db1 = Database.getInstance("MyDB", 12345);
        Database db2 = Database.getInstance("AnotherDB", 54321);

        // Both db1 and db2 point to the same instance of Database
        System.out.println(db1 == db2);  // Output: true
    }
}
```

In the `main()` method, we obtain instances of the `Database` class using the `getInstance()` method. Since the `getInstance()` method ensures that only one instance of the `Database` class is created, both `db1` and `db2` will refer to the same object. The output of the comparison `db1 == db2` will be `true`.

