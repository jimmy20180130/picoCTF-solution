# Small Trouble

## 題目描述 (Description)

Everything seems secure; strong numbers, familiar parameters but something small might ruin it all. Can you recover the message?
Download the [message](https://challenge-files.picoctf.net/c_plain_mesa/ba28f654ddd49c8b67da3c21ee155a543aba9f3e9475bc321a5cb7b37a84daee/message.txt). And source [code](https://challenge-files.picoctf.net/c_plain_mesa/ba28f654ddd49c8b67da3c21ee155a543aba9f3e9475bc321a5cb7b37a84daee/encryption.py)

### 提示 (Hints)

1. Hint 1
   This might be a job for Boneh-Durfee.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：觀察encryption.py，發現d很小，符合題目的hint，可以用Boneh-Durfee Attack，即為Wiener Attack之延伸，所以我嘗試用Wiener Attack。

## Flag

```text
picoCTF{sm4ll_d_63c34244}
```