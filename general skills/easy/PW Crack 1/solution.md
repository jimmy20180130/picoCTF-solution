# PW Crack 1

## 題目描述 (Description)

Can you crack the password to get the flag?
Download the password checker [here](https://artifacts.picoctf.net/c/11/level1.py) and you'll need the encrypted [flag](https://artifacts.picoctf.net/c/11/level1.flag.txt.enc) in the same directory too.

### 提示 (Hints)

1. Hint 1
   To view the file in the webshell, do: $ nano level1.py
2. Hint 2
   To exit nano, press Ctrl and x and follow the on-screen prompts.
3. Hint 3
   The str_xor function does not need to be reverse engineered for this challenge.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看完level1.py之後，第19行有一個if迴圈檢測輸入是否為：
```text
1e1a
```
    執行level1.py，輸入1e1a後，即可得到flag。


## Flag

```text
picoCTF{545h_r1ng1ng_fa343060}
```