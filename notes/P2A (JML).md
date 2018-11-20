# P2A - JML

### Syntax

- `\result`: Result of the method
- `\old(E)`: Value of expression `E` before the method
- `C1 ==> C2`: Condition 1 implies condition 2
- `C1 ? E1 : E2`: If condition 1 holds expression 1 holds. Else expression 2 holds.
- `\forall`, `\exists` universal and existential quantification

### Class invariants
Invariants belong to classes.
- This should always hold
```
// If this guest has a room this guest will always be in that room
// @ invariant room != null ==> room.guest == this
```

#### Public invariant
Uses only publicly visible methods
```java
// @ public invariant getValue() >= 0;
```

#### Private invariant
Talks about the internal state, not visible to the caller.
```java
// @ private invariant value >= 0;
```

### Postconditions
Postconditions belong to methods.
- Method should ensure this
- Caller can rely on this
```java
// always returns a positive value
// @ ensures \result => 0;
```

```java
// ensure that the value increases by one
// @ ensures getValue() == \old(getValue()) + 1;
```


### Pure functions
```java
// The function has no side effects
// @ pure
public int getValue() {
    return value;
}
```

### Preconditions
```java
// @ requres val >= 0;
// @ ensures getValue() == val;
public void setValue(int val) {
    value = val;
}
```

### examples
#### Complex condition
```java
public int dollars () {
    return amount / 100;
}

public int cents() {
    return amount % 100;
}

// @ ensures (\old(dollars()) + dollars) * 100 +
//            \old(cents()) + cents ==
//            dollars() * 100 + cents();

public void add (int dollars, int cents) {
    // ...
}
```

#### Specific conditions
Unsafe: you assume that the caller checks if the MAX value is reached. But this is part of the philosophy.
```java
// Reset can only be called when the MAX value is reached
// @ requres getValue() == Counter.MAX;
public void reset() {
 //
}
```

#### Input caps
```java
// @ 0 <= code && code <= 999
```
