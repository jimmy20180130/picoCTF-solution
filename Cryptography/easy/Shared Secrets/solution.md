# Shared Secrets

## 題目描述 (Description)

A message was encrypted using a shared secret... but it looks like one side of the exchange leaked something. Can you piece together the secret and get the flag?
Download the [message](https://challenge-files.picoctf.net/c_plain_mesa/39ec90f3ea5bd19a237fde56ae856cc8ce64efda551c38d3da908bcef8ed9c7a/message.txt). And source [code](https://challenge-files.picoctf.net/c_plain_mesa/39ec90f3ea5bd19a237fde56ae856cc8ce64efda551c38d3da908bcef8ed9c7a/encryption.py)

### 提示 (Hints)

1. Hint 1  
    What do you get if you combine a public key with a known private one?

## 解題思路 (Solution Walkthrough)

1. **第一步**：它的邏輯上是將 flag 的每個位元組與 `shared % 256` 進行 XOR 運算

    ```py
    flag = b"picoCTF{...}"
    enc = bytes([x ^ (shared % 256) for x in flag])
    ```

2. **第二步**：因為題目很好心，shared 需要的資料都在 message.txt 裡面，於是寫一個腳本讓他再一次 XOR 即可得到 flag

## Flag

```text
picoCTF{dh_s3cr3t_1bcf19a9}
```
