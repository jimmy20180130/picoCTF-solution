# PW Crack 3

## 題目描述 (Description)

Can you crack the password to get the flag?
Download the password checker [here](https://artifacts.picoctf.net/c/18/level3.py) and you'll need the encrypted [flag](https://artifacts.picoctf.net/c/18/level3.flag.txt.enc) and the [hash](https://artifacts.picoctf.net/c/18/level3.hash.bin) in the same directory too.
There are 7 potential passwords with 1 being correct. You can find these by examining the password checker script.

### 提示 (Hints)

1. Hint 1
   To view the level3.hash.bin file in the webshell, do: $ bvi level3.hash.bin
2. Hint 2
   To exit bvi type :q and press enter.
3. Hint 3
   The str_xor function does not need to be reverse engineered for this challenge.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看完level3.py之後，最後有一個list包含了7個密碼：
```text
pos_pw_list = ["8799", "d3ab", "1ea2", "acaf", "2295", "a9de", "6f3d"]
```
    當然我們可以一個一個慢慢輸入，最多只要嘗試七次，但能交給電腦就盡量交給電腦，所以我稍微改寫了程式碼(見solution.py)。
    執行solution.py後，即可得到flag。


## Flag

```text
picoCTF{m45h_fl1ng1ng_6f98a49f}
```