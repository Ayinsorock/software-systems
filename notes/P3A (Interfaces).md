# P3A - Interfaces

## Inheritance
Equivalent terminology
- `A` is an abstraction of `B`
- `B` inherits from `A`
```java
class B extends A {
 public B (arg1, arg2) {
    super(arg1);

    this.arg2 = arg2;
 }

 @Override
 public void myMethod () {
    //
 }
}
```

Java classes are derived from the `Object` class.
```java
class Object {
    public String toString(){
        //
    }

    public boolean equal(Object o) {
        //
    }
}
```

## Interfaces
A 'class without implementation'. Only declare methods and members. Do not implement anything.

For instance  `ArrayList` is an implementation of the `List` interface.
```java
List myList = new ArrayList();
```
```java
public class ArrayList implements List {
 public int size() {
    //
 }
}
```

```java
interface myInterface {
     void myMethod1();

     void myMethod2(int myInt);
}
```

Interface methods are always public. As such the public keyword can be omitted.

## Questions
 - Must all interface methods always be implemented?
 - Do interfaces only contain methods or also variables?