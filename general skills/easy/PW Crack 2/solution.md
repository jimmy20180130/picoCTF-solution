# PW Crack 2

## 題目描述 (Description)

Can you crack the password to get the flag?
Download the password checker [here](https://artifacts.picoctf.net/c/14/level2.py) and you'll need the encrypted [flag](https://artifacts.picoctf.net/c/14/level2.flag.txt.enc) in the same directory too.

### 提示 (Hints)

1. Hint 1
   Does that encoding look familiar?
2. Hint 2
   The str_xor function does not need to be reverse engineered for this challenge.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看完level2.py之後，第18行有一個if迴圈檢測輸入是否為：
```text
chr(0x34) + chr(0x65) + chr(0x63) + chr(0x39)
```
    用ascii轉換後，可得：
```text
4ec9
```
    執行level2.py，輸入4ec9後，即可得到flag。


## Flag

```text
picoCTF{tr45h_51ng1ng_9701e681}
```