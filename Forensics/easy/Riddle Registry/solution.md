# Riddle Registry

## 題目描述 (Description)

Hi, intrepid investigator! 📄🔍 You've stumbled upon a peculiar PDF filled with what seems like nothing more than garbled nonsense. But beware! Not everything is as it appears. Amidst the chaos lies a hidden treasure—an elusive flag waiting to be uncovered.
Find the PDF file here [Hidden Confidential Document](https://challenge-files.picoctf.net/c_amiable_citadel/9eb01e29bada8f3c16abe23682c2df28e91a5f9904e505f007e017cc5fb24593/confidential.pdf) and uncover the flag within the metadata.

### 提示 (Hints)

1. Hint 1
   Don't be fooled by the visible text; it’s just a decoy!
2. Hint 2
   Look beyond the surface for hidden clues

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載 pdf 以後，我發現有一些字被塗黑了，仔細查看後皆沒有發現有疑似 flag 的字串

2.  **第二步**：之後直接把 pdf 以 vscode 內建的文字檢視器開啟，發現 `Author` 的地方有一串可疑的字串：
   ```
   /Author (cGljb0NURntwdXp6bDNkX20zdGFkYXRhX2YwdW5kIV9lZTQ1NDk1MH0\075)
   ```
   觀察字串結尾的 `\075`，這在 ASCII 八進位表示中對應 `=`，這是一個 Base64 編碼的特徵。整理後的字串為 `cGljb0NURntwdXp6bDNkX20zdGFkYXRhX2YwdW5kIV9lZTQ1NDk1MH0=`。

3.  **第三步**：提取 Flag。
    *   使用工具解碼後得到 flag 為 `picoCTF{puzzl3d_m3tadata_f0und!_ee454950}`。

## Flag

```text
picoCTF{puzzl3d_m3tadata_f0und!_ee454950}
```