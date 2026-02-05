# Matryoshka doll

## 題目描述 (Description)

Matryoshka dolls are a set of wooden dolls of decreasing size placed one inside another. What's the final one?
Image: [dolls.jpg](https://challenge-files.picoctf.net/c_wily_courier/9bf118825bda566d4622b19d243e75877e2c17db745281bc5b0d11efd2278161/dolls.jpg)

### 提示 (Hints)

1. Hint 1
   Wait, you can hide files inside files? But how do you find them?
2. Hint 2
   Make sure to submit the flag as picoCTF{XXXXX}

## 解題思路 (Solution Walkthrough)

1.  **第一步**：只有一張圖片，於是我直接用 `zsteg` 查看，發現這張圖片裡面好像有包含其他檔案
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$ zsteg -a dolls.jpg   
   [?] 379121 bytes of extra data after image end (IEND), offset = 0x4286c
   extradata:0         .. file: Zip archive data, made by v3.0 UNIX, extract using at least v2.0, last modified Dec 19 2025 19:01:30, uncompressed size 383920, method=deflate
      00000000: 50 4b 03 04 14 00 00 00  08 00 2f 98 93 5b 39 e0  |PK......../..[9.|
      00000010: 11 1b 35 c8 05 00 b0 db  05 00 13 00 1c 00 62 61  |..5...........ba|
      00000020: 73 65 5f 69 6d 61 67 65  73 2f 32 5f 63 2e 6a 70  |se_images/2_c.jp|
      00000030: 67 55 54 09 00 03 0a a1  45 69 0a a1 45 69 75 78  |gUT.....Ei..Eiux|
      00000040: 0b 00 01 04 00 00 00 00  04 00 00 00 00 ec fc 67  |...............g|
      00000050: 58 53 5f d7 2e 8e d2 a4  86 26 4a 27 40 40 10 90  |XS_......&J'@@..|
      00000060: 2e d2 42 13 10 50 8a 82  0a d2 8b 4a 93 de 12 3a  |..B..P.....J...:|
      00000070: 82 84 a2 14 01 11 81 d0  45 3a 2a bd 43 e8 28 bd  |........E:*.C.(.|
      00000080: 28 3d b4 04 10 08 a1 85  fe 4f fc 3d cf f3 be 7b  |(=.......O.=...{|
      00000090: bf fb ff ed 7c 38 e7 da  87 eb 0a 59 59 6b ce b1  |....|8.....YYk..|
      000000a0: d6 1c 73 8c 7b dc 63 ae  b1 56 f4 43 7d 2d 5a 6a  |..s.{.c..V.C}-Zj|
      000000b0: 76 6a 22 22 22 5a 1d 6d  0d 43 22 22 12 3a 22 22  |vj"""Z.m.C"".:""|
      000000c0: 32 43 4a 72 fc 9e 5e 41  48 3c 11 11 e0 85 a3 ba  |2CJr..^AH<......|
      000000d0: fa 43 1d 75 75 9e 87 9e  6e 2f 1d 5f bd 20 22 d2  |.C.uu...n/._. ".|
      000000e0: 8e 4e 49 a5 30 31 ea 63  0e 45 7d 78 7c d5 94 87  |.NI.01.c.E}x|...|
      000000f0: c4 f0 ae 5b ae 36 2d cf  8d 08 66 35 d5 62 1e 61  |...[.6-...f5.b.a|
   ...
   ```

2.  **第二步**：於是使用 `binwalk` 來把隱藏的檔案提取出來
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$ binwalk -e dolls.jpg 

   DECIMAL       HEXADECIMAL     DESCRIPTION
   --------------------------------------------------------------------------------
   272492        0x4286C         Zip archive data, at least v2.0 to extract, compressed size: 378933, uncompressed size: 383920, name: base_images/2_c.jpg

   WARNING: One or more files failed to extract: either no utility was found or it's unimplemented
   ```

3.  **第三步**：重複上述的動作就能在最後看到 flag.txt，並成功取得 flag

## Flag

```text
picoCTF{LL9lb1dR4QbGe4l4iWCvGq9pdtwt7392}
```