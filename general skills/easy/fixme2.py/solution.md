# fixme2.py

## 題目描述 (Description)

Fix the syntax error in the Python script to print the flag.
[Download Python script](https://artifacts.picoctf.net/c/5/fixme2.py)

### 提示 (Hints)

1. Hint 1  
    Are equality and assignment the same symbol?
2. Hint 2  
    To view the file in the webshell, do: `$ nano fixme2.py`
3. Hint 3  
    To exit `nano`, press Ctrl and x and follow the on-screen prompts.
4. Hint 4
    The `str_xor` function does not need to be reverse engineered for this challenge.

## 解題思路 (Solution Walkthrough)

1. **第一步**：把 `if flag = "":` 改成 `if flag == "":` 即可取得 flag

## Flag

```text
picoCTF{3qu4l1ty_n0t_4551gnm3nt_4863e11b}
```
