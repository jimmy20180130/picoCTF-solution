# New Caesar

## 題目描述 (Description)

We found a brand new type of encryption, can you break the secret code? (Wrap with picoCTF{})
fegdeogdgecoeocgcgchcfcffccfca [new_caesar.py](https://challenge-files.picoctf.net/c_wily_courier/27c48aec1b62b7c91fb548af379da1eac1ae8034199085a254dc3d274cc1bf05/new_caesar.py)

### 提示 (Hints)

1. Hint 1
   How does the cipher work if the alphabet isn't 26 letters?
2. Hint 2
   Even though the letters are split up, the same paradigms still apply

## 解題思路 (Solution Walkthrough)

1.  **第一步**：觀察 `new_caesar.py`，可以發現他的字母只有 a~p，且 key 的長度為 1，於是寫了一個腳本把所有的可能都列出來

## Flag

```text
picoCTF{et_tu?_77866c61}
```