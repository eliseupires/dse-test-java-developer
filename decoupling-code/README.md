# Decoupling code

Write a Java program to solve the following problem:

Explain how you would use a design pattern to decouple your code from a third-party library that might be replaced in the future. 

Describe the advantages and limitations of your chosen approach, and provide a small code snippet illustrating its application.

# Solution

To decouple your code from a third-party library that might be replaced in the future, you can use the Adapter design pattern. 

This pattern allows you to define your own interface that your application code depends on, and implement adapters that bridge between this interface and the third-party library. If the library changes or is replaced, only the adapter needs to be updated—your application logic remains untouched.

| Advantage     |  |
|---------------| ------ |
|Loose coupling | The application code doesn't directly depend on the third-party API.|
|Testability | You can mock or stub your interface in tests without involving the external library.|
|Flexibility | Easily switch to a different library or even provide multiple implementations.|

| Limitation |  |
|------------| ------ |
| Additional boilerplate | Introduces extra classes and interfaces.|
| Performance overhead | Slight cost due to indirection.|
| Incomplete abstraction | Some features of the third-party library might not map cleanly to your interface.|


### Example
Imagine your app sends emails using a third-party service, but you want to keep the option open to switch to another service (like Personal Email).
```
📦src
┣ 📂main
┃ ┗ 📂java
┃ ┃ ┗ 📂com
┃ ┃ ┃ ┗ 📂decoupling
┃ ┃ ┃ ┃ ┗ 📂code
┃ ┃ ┃ ┃ ┃ ┣ 📂adapter
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SendCompanyEmailAdapter.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SendCompanyEmailClient.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SendPersonalEmailAdapter.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SendPersonalEmailClient.java
┃ ┃ ┃ ┃ ┃ ┣ 📂service
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailNotifier.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜IEmailService.java
┃ ┃ ┃ ┃ ┃ ┗ 📜DecouplingCode.java
┗ 📂test
┃ ┗ 📂java
┃ ┃ ┗ 📂com
┃ ┃ ┃ ┗ 📂decoupling
┃ ┃ ┃ ┃ ┗ 📂code
┃ ┃ ┃ ┃ ┃ ┗ 📜EmailNotifierTest.java
```
