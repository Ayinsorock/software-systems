# P1B

### Class models
*first* step: class diagram

```java
public class Hotel {}
| 1
|
▼ 1..*
public class Room {}
▲ 0..1
|
▼ 0..*
public class Guest {}
```

*relations*: `Hotel` has `Room` has `Guest`. These are called **associations**.

- `Hotel` -> `Room` OneToMany
- `Room` -> `Hotel` ManyToOne

#### Association types
- `1` Exactly one
- `0..1` Zero or one
- `1..*` More than zero
- `1..*` More than one

#### Attributes
- A `-` indicates a private property.
- A `+` indicates a public property.


### Constructors
```java
public class Hotel {
    private String name;
    private Guest guest;

    public Hotel (String name) {
        // Constructor
        this.name = name;

        // Apparently when there is no ambiguity 'this.' can be omitted
        guest = null;
    }
}
```

### Static
Static implicates that the **Class** holds the value of the variable, **not** an **instance**. So one single value is shared by all instances of the Class

```java
public class Hotel {
    public static final double VAT = 0.21;
    public String name;

    public Hotel (String name) {
        this.name = name; // name is an instance attribute, so we reach it with 'this'

        System.out.println("Hotel created with VAT: ");
        System.out.println(Hotel.VAT); // VAT is static for the class so reached with `Hotel`
    }
}
```
    