# RED

## 題目描述 (Description)

RED, RED, RED, RED
Download the image: [red.png](https://challenge-files.picoctf.net/c_verbal_sleep/831307718b34193b288dde31e557484876fb84978b5818e2627e453a54aa9ba6/red.png)

### 提示 (Hints)

1. Hint 1
   The picture seems pure, but is it though?
2. Hint 2
   Red?Ged?Bed?Aed?
3. Hint 3
   Check whatever Facebook is called now.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：檢視圖片的 metadata，發現一個 poem
   ```
   Crimson heart, vibrant and bold, 
   Hearts flutter at your sight. 
   Evenings glow softly red, 
   Cherries burst with sweet life. 
   Kisses linger with your warmth. 
   Love deep as merlot. 
   Scarlet leaves falling softly, 
   Bold in every stroke.
   ```

2.  **第二步**：找不出線索，[看到這篇文章](https://medium.com/@erichdryn/red-picoctf-writeup-515376dc78c2)以後才發現每一句的句首是 `check lsb` (Least Significant Bit)

3.  **第三步**：使用 `zsteg -a red.png` 來取得圖片中隱藏的字串，最後找到 `cGljb0NURntyM2RfMXNfdGgzX3VsdDFtNHQzX2N1cjNfZjByXzU0ZG4zNTVffQ==`，解碼後即為 flag

## Flag

```text
picoCTF{r3d_1s_th3_ult1m4t3_cur3_f0r_54dn355_}
```