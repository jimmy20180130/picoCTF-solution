# interencdec

## 題目描述 (Description)

Can you get the real meaning from this file.
Download the file [here](https://artifacts.picoctf.net/c_titan/1/enc_flag).

### 提示 (Hints)

1. Hint 1
   Engaging in various decoding processes is of utmost importance

## 解題思路 (Solution Walkthrough)

1.  **第一步**：enc_flag 裡面有一串 base64 編碼的字串，解碼後為 `b'd3BqdkpBTXtqaGx6aHlfazNqeTl3YTNrX2xoNjBsMDBpfQ=='`，再解一次為 `wpjvJAM{jhlzhy_k3jy9wa3k_lh60l00i}`

2.  **第二步**：解出來的看起來蠻像是用凱薩密碼加密過的，於是嘗試解密，成功取得 flag

## Flag

```text
picoCTF{caesar_d3cr9pt3d_ea60e00b}
```