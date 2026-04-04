# fixme1.py

## 題目描述 (Description)

Fix the syntax error in this Python script to print the flag.
[Download Python script](https://artifacts.picoctf.net/c/25/fixme1.py)

### 提示 (Hints)

1. Hint 1  
    Indentation is very meaningful in Python
2. Hint 2  
    To view the file in the webshell, do: `$ nano fixme1.py`
3. Hint 3
    To exit `nano`, press Ctrl and x and follow the on-screen prompts.
4. Hint 4  
    The `str_xor` function does not need to be reverse engineered for this challenge.

## 解題思路 (Solution Walkthrough)

1. **第一步**：把 `print('That is correct! Here\'s your flag: ' + flag)` 前面的縮排移除即可取得 flag

## Flag

```text
picoCTF{1nd3nt1ty_cr1515_6a476c8f}
```
