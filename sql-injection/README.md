# SQL Injection

Discuss the techniques you use to prevent SQL injection attacks in web applications.

Provide examples of code showing secure implementations, such as using parameterized queries or ORMs.

Mention any additional measures you take to secure the database layer.

## Solution


SQL Injection happens when untrusted input is used to build SQL statements directly, allowing attackers to manipulate the queries. To prevent this in Spring Boot, follow these techniques:

---

###  Use ORM (like Hibernate with Spring Data JPA)

Spring Data JPA automatically uses parameterized queries behind the scenes when you use method names like `findByUsername`.

```java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
```

This translates to:
```sql
SELECT * FROM users WHERE username = ? AND password = ?
```

---

### Avoid Concatenating User Input in Queries

**Bad (vulnerable to SQL Injection):**
```java
String query = "SELECT u FROM User u WHERE u.username = '" + username + "' AND u.password = '" + password + "'";
```

**Safe with parameters:**
```java
em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
  .setParameter("username", username)
  .setParameter("password", password)
  .getSingleResult();
```

---

### Validate Input (Optional but Helpful)

```java
public class LoginRequest {
    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    private String password;
}
```

---
