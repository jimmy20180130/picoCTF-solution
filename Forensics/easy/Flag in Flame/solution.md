# Flag in Flame

## 題目描述 (Description)

The SOC team discovered a suspiciously large log file after a recent breach. When they opened it, they found an enormous block of encoded text instead of typical logs. Could there be something hidden within? Your mission is to inspect the resulting file and reveal the real purpose of it. The team is relying on your skills to uncover any concealed information within this unusual log.
Download the encoded data here: [Logs Data](https://challenge-files.picoctf.net/c_amiable_citadel/ade5acd5e8e7082fc52cbbb6b297da484b0656fa4ce51b3b923c9d2c0f4a93f7/logs.txt). Be prepared—the file is large, and examining it thoroughly is crucial .

### 提示 (Hints)

1. Hint 1
   Use base64 to decode the data and generate the image file.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：我發現 logs.txt 裡面有一堆亂碼，看起來像是 base64 編碼的資料 (jpg 檔案)，所以我嘗試將這些亂碼解碼成二進位資料，並存成一個圖片檔案 (可參考 `solution.js`)

2.  **第二步**：看到圖片裡面有這一個字串，而且裡面有 0~F，於是就把他轉成 ASCII，並順利的得到 flag
   `7069636F4354467B666F72656E736963735F616E616C797369735F69735F616D617A696E675F37383265353563397D`

## Flag

```text
picoCTF{forensics_analysis_is_amazing_782e55c9}
```