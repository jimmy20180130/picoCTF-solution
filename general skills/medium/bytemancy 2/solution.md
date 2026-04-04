# bytemancy 2

## 題目描述 (Description)

Can you conjure the right bytes? The program's source code can be downloaded [here](https://challenge-files.picoctf.net/c_lonely_island/19e324d00cff4e033f56b6f0abc222edd18c5bb988d55147d04e21e5ace1be14/app.py).

### 提示 (Hints)

1. Hint 1  
    There's no way to print these bytes
2. Hint 2  
    Use pwntools to send raw bytes over the network

## 解題思路 (Solution Walkthrough)

1. **第一步**：看了 app.py 發現他要使用者輸入 `b"\xff\xff\xff"`

2. **第二步**：於是寫了個腳本成功拿到 flag

## Flag

```text
picoCTF{3ff5_4_d4yz_b18c7339}
```
