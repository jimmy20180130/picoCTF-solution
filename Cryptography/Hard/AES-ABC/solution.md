# AES-ABC

## 題目描述 (Description)

AES-ECB is bad, so I rolled my own cipher block chaining mechanism - Addition Block Chaining!
You can find the source here: [aes-abc.py](https://challenge-files.picoctf.net/c_fickle_tempest/99b83265b3966137cc7004e4cb4890d04bc68b526a45f80563d1bdb0036c693c/aes-abc.py). The AES-ABC flag is [body.enc.ppm](https://challenge-files.picoctf.net/c_fickle_tempest/99b83265b3966137cc7004e4cb4890d04bc68b526a45f80563d1bdb0036c693c/body.enc.ppm)

### 提示 (Hints)

1. Hint 1
   You probably want to figure out what the flag looks like in ECB form...

## 解題思路 (Solution Walkthrough)

1.  **第一步**：題目給了密文以及AES加密過程，但aes-abc.py是從明文轉換成密文，因此需要逆運算才能還原圖片。
   原題的加密方式在第二步會詳細解說，現在先跳過。
   ```python
   print(data[:20])
   ```
   讀檔後先檢查header，確認為圖片後，開始把之後的內容切成每個都是16 bytes的block。

2.  **第二步**：切完block之後，開始執行逆運算。
   這題自創的ABC加密模式定義區塊大小為16bytes，模數為：

   ```math
   UMAX = 256^{16} = 2^{128}
   ```

   加密流程如下：

   ```math
   C'_0 = IV
   ```
   為初始條件

   ```math
   C'_i = (C_i + C'_{i-1}) \bmod 2^{128}
   ```
   其中：
   $C_i$ 為AES加密後的block
   $C'_i$ 為輸出密文區塊

### 解密推導(模運算超出高中範圍)：

   由加密公式：

   ```math
   C'_i = (C_i + C'_{i-1}) \bmod 2^{128}
   ```

   兩邊同時減去 $C'_{i-1}$：

   ```math
   C'_i - C'_{i-1} \equiv C_i \pmod{2^{128}}
   ```

   因此可得：

   ```math
   C_i = (C'_i - C'_{i-1}) \bmod 2^{128}
   ```
### 展開形式

   ```math
   C_1 = (C'_1 - C'_0) \bmod 2^{128}
   ```

   ```math
   C_2 = (C'_2 - C'_1) \bmod 2^{128}
   ```

   ```math
   C_3 = (C'_3 - C'_2) \bmod 2^{128}
   ```
   依此類推

### 結論

   只要給$C_i$與$C'_i$，就能得到明文。
   不需要知道key就能解密是因為題目出的AES加密只是加減法轉換，就如凱薩密碼表一樣，不同圖片區塊仍與其他區塊有差異。
   因此雖然解密內容與原圖顏色不一定相同，仍能從其中辨識出原本圖片的輪廓。

3.  **第三步**：解出明文後，再把.ppm轉成.png即可得到flag。
   眼睛不好還解不出來這題QAQ

## Flag

```text
picoCTF{d0Nt_r0ll_yoUr_0wN_aES}
```