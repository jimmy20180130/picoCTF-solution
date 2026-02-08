# PW Crack 5

## 題目描述 (Description)

Can you crack the password to get the flag?
Download the password checker [here](https://artifacts.picoctf.net/c/33/level5.py) and you'll need the encrypted [flag](https://artifacts.picoctf.net/c/33/level5.flag.txt.enc) and the [hash](https://artifacts.picoctf.net/c/33/level5.hash.bin) in the same directory too. Here's a [dictionary](https://artifacts.picoctf.net/c/33/dictionary.txt) with all possible passwords based on the password conventions we've seen so far.

### 提示 (Hints)

1. Hint 1
   Opening a file in Python is crucial to using the provided dictionary.
2. Hint 2
   You may need to trim the whitespace from the dictionary word before hashing. Look up the Python string function, strip
3. Hint 3
   The str_xor function does not need to be reverse engineered for this challenge.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：這次是給了一個dictionary，所以要先讀檔再逐行比對。
    我先把dictionary的內容逐行讀取進來，使用strip()轉成字串，接著執行solution.py。
    因為dictionary很長，經過一段時間的等待，就可以得到flag了。

## Flag

```text
picoCTF{h45h_sl1ng1ng_fffcda23}
```