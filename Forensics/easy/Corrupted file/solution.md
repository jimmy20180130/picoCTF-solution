# Corrupted file

## 題目描述 (Description)

This file seems broken... or is it? Maybe a couple of bytes could make all the difference. Can you figure out how to bring it back to life?
Download the file [here](https://challenge-files.picoctf.net/c_amiable_citadel/8646393bf40c0026e51065e57963b604edf0a9a73371e01d1af2865c050d3e68/file).

### 提示 (Hints)

1. Hint 1
   Try checking the file’s header.
2. Hint 2
   JPEG
3. Hint 3
   Tools like xxd or hexdump can help you inspect and edit file bytes.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載檔案並使用 010 Editor 打開後，我發現檔案開頭是
   `5C 78 FF E0 00 10 4A 46 49 46 00 01 01 00 00 01 \xÿà�JFIF���`

2.  **第二步**：查詢後得知 `JPEG File Interchange Format` 的標頭應是以下的格式 `FF D8 FF E0`，所以將 `5C 78` 改為 `FF D8` 即可
   
3.  **第三步**：看到圖片上印有完整的 flag

## Flag

```text
picoCTF{r3st0r1ng_th3_by73s_939a65f5}
```