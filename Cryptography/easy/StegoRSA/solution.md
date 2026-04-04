# StegoRSA

## 題目描述 (Description)

A message has been encrypted using RSA. The public key is gone… but someone might have been careless with the private key. Can you recover it and decrypt the message?
Download the [flag](https://challenge-files.picoctf.net/c_plain_mesa/57932cef0608e6ef25a588a427a485649b572fe08ade8e7888f12fd7a43dca95/flag.enc) and [image](https://challenge-files.picoctf.net/c_plain_mesa/57932cef0608e6ef25a588a427a485649b572fe08ade8e7888f12fd7a43dca95/image.jpg).

### 提示 (Hints)

1. Hint 1  
    Metadata can tell you more than you expect.
2. Hint 2  
    Hex can be turned back into a key file.

## 解題思路 (Solution Walkthrough)

1. **第一步**：把圖片拿去分析分析，發現他的 comments 裡有一串東西，按照題目的說法那應該是私鑰，

2. **第二步**：接著把私鑰轉成 utf-8，flag.enc 轉成 hex 以後拿去解密即可得到 flag

## Flag

```text
picoCTF{rs4_k3y_1n_1mg_0a64c2f9}
```
