# Overriding Equals Method

Provide an example scenario where overriding the equals() method is necessary in Java. 

Explain the key considerations when implementing this method, such as ensuring it aligns with the hashCode() method. 

Include code examples if possible.

# Solution

Overriding the equals() method in Java is essential when you want to define what it means for two instances of a class to be considered "equal" beyond the default identity comparison (==).

By default, equals() in Object compares memory addresses (this == other), not logical content.

So even if two `Person`  objects have the same `id`, they wouldn't be considered equal unless they are the exact same instance.

If you override equals(), `you must also override hashCode()` to maintain the general contract: equal objects must have the same hash code. 
This is critical when objects are stored in hash-based collections like HashSet or HashMap.

### Key Considerations

|          |                                                                                          |
|-------------|-------------------------------------------------------------------------------------------------------|
| Symmetry    | a.equals(b) must return the same result as b.equals(a)                                                |
| Consistency | a.equals(b) should consistently return the same result unless the properties used in equality change. | 


