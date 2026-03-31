# Timestamped Secrets

## 題目描述 (Description)

Someone encrypted a message using AES in ECB mode but they weren’t very careful with their key. Turns out it’s derived from something as simple as the current time! Can you uncover the key and decrypt the flag?
Download the encrypted message: [message](https://challenge-files.picoctf.net/c_plain_mesa/b19c5e3f2718b9801566712aedc717c50da08ba2e79240001f92aec41875ed9c/message.txt)
You may also find the encryption script helpful: [code](https://challenge-files.picoctf.net/c_plain_mesa/b19c5e3f2718b9801566712aedc717c50da08ba2e79240001f92aec41875ed9c/encryption.py)

### 提示 (Hints)

1. Hint 1
   `encryption.py` is a redacted example of the program

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看到 `encryption.py` 他是使用 timestamp 作為 key，加上 message.txt 又有提供 timestamp，於是寫一個腳本即可取得 flag

## Flag

```text
picoCTF{sa3S_sEc9t_fbcf37a3}
```