# 栈

- 复用 Array 动态数组实现栈的各种操作

```java
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}

```
