# PW Crack 4

## 題目描述 (Description)

Can you crack the password to get the flag?
Download the password checker [here](https://artifacts.picoctf.net/c/20/level4.py) and you'll need the encrypted [flag](https://artifacts.picoctf.net/c/20/level4.flag.txt.enc) and the [hash](https://artifacts.picoctf.net/c/20/level4.hash.bin) in the same directory too.
There are 100 potential passwords with only 1 being correct. You can find these by examining the password checker script.

### 提示 (Hints)

1. Hint 1
   A for loop can help you do many things very quickly.
2. Hint 2
   The str_xor function does not need to be reverse engineered for this challenge.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看完level4.py之後，最後有一個list包含了100個密碼。
    這次就不能一個一個慢慢輸入了，與PW Crack 3同理，我將level3.py改寫成solution.py。
    執行solution.py後，即可得到flag。


## Flag

```text
picoCTF{fl45h_5pr1ng1ng_cf341ff1}
```