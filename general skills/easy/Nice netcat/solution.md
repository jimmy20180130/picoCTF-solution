# Nice netcat...

## 題目描述 (Description)

There is a nice program that you can talk to by using this command in a shell:

### 提示 (Hints)

1. Hint 1  
    You can practice using netcat with this picoGym problem: what's a netcat?
2. Hint 2  
    You can practice reading and writing ASCII with this picoGym problem: Let's Warm Up

## 解題思路 (Solution Walkthrough)

1. **第一步**：連進去以後返回一長串數字

    ```text
    112 
    105 
    99 
    111 
    67 
    84 
    70 
    123 
    103 
    48 
    48 
    100 
    95 
    107 
    49 
    116 
    116 
    121 
    33 
    95 
    110 
    49 
    99 
    51 
    95 
    107 
    49 
    116 
    116 
    121 
    33 
    95 
    97 
    57 
    52 
    101 
    55 
    125 
    10
    ```

2. **第二步**：這些數字為 ASCII 編碼，轉換為 utf-8 即為 flag

## Flag

```text
picoCTF{g00d_k1tty!_n1c3_k1tty!_a94e7}
```
