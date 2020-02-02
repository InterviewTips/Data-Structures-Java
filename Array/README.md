# 数组

简介：把数据码成一排进行存放

![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580568318965-3a53b27d-cee8-4317-a56b-41c9e4777d6d.png#align=left&display=inline&height=128&name=image.png&originHeight=336&originWidth=1954&size=93662&status=done&style=stroke&width=746)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580569441389-4d68f25e-5074-40d4-8505-4db190701007.png#align=left&display=inline&height=259&name=image.png&originHeight=814&originWidth=1264&size=308111&status=done&style=stroke&width=402)

身份证号开辟空间过大

![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580569777806-e026119f-b69a-406c-bc8f-77d58c165a72.png#align=left&display=inline&height=233&name=image.png&originHeight=744&originWidth=1700&size=264160&status=done&style=stroke&width=533)

封装 java 动态数组

<a name="Rd3JB"></a>
### 使用泛型

![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580630538974-9d97cba9-f4d3-425f-b117-eeb49a23dd57.png#align=left&display=inline&height=272&name=image.png&originHeight=912&originWidth=1834&size=448855&status=done&style=stroke&width=547)

<a name="CArfO"></a>
### 动态扩缩容

```java
    // 动态扩缩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData; // 引用
    }
```

<a name="VAehr"></a>
### 时间复杂度分析
![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580634541077-fb86c096-4788-4e6f-b2d9-04121cbbe6fd.png#align=left&display=inline&height=295&name=image.png&originHeight=912&originWidth=2308&size=410490&status=done&style=stroke&width=746)<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580634575467-451ba76f-a53a-44bb-87ae-a98a026ac09b.png#align=left&display=inline&height=155&name=image.png&originHeight=480&originWidth=2306&size=246731&status=done&style=stroke&width=746)<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580634591889-f5364879-14ba-4906-9996-0dd0d3f69c5b.png#align=left&display=inline&height=38&name=image.png&originHeight=110&originWidth=2152&size=115467&status=done&style=stroke&width=746)

描述 n 趋近于无穷的情况

O(1) 与数据规模无关系

<a name="x8j5a"></a>
#### 分析动态数组时间复杂度
![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580635410085-9a404e64-a670-47be-b4f4-b611c1e5d7ec.png#align=left&display=inline&height=263&name=image.png&originHeight=928&originWidth=1488&size=257301&status=done&style=stroke&width=421)

通常考虑最差情况

![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580635601575-3191a0b0-01e3-401d-9141-84040712acb0.png#align=left&display=inline&height=253&name=image.png&originHeight=740&originWidth=1490&size=203660&status=done&style=stroke&width=510)<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580635671643-56828557-330b-49d6-8121-c74021d6a8b2.png#align=left&display=inline&height=142&name=image.png&originHeight=372&originWidth=870&size=65610&status=done&style=stroke&width=335)<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580635717133-625b2208-b487-4bee-afa4-8bb70d975403.png#align=left&display=inline&height=285&name=image.png&originHeight=724&originWidth=850&size=127295&status=done&style=stroke&width=335)

<a name="nUTO9"></a>
#### 综合时间复杂度
![image.png](https://cdn.nlark.com/yuque/0/2020/png/225582/1580635798226-967add00-5b4c-437e-afad-d90f709d39a9.png#align=left&display=inline&height=264&name=image.png&originHeight=820&originWidth=1612&size=343622&status=done&style=stroke&width=520)




