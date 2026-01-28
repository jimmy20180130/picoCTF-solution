# M1n10n'5_53cr37

## 題目描述 (Description)

Get ready for a mischievous adventure with your favorite Minions! 🕵️‍♂️💥 They’ve been up to their old tricks, and this time, they've hidden the flag in a devious way within the Android source code. Your task is to channel your inner Minion and dive into the disassembled or decompiled code. Watch out, because these little troublemakers have hidden the flag in multiple sneaky spots or maybe even pulled a fast one and concealed it in the same location!
Put on your overalls, grab your magnifying glass, and get cracking. The Minions have left clues, and it's up to you to follow their trail and uncover the flag. Can you outwit these playful pranksters and find their secret? Let the Minion mischief begin!
Find the android apk here [Minions Mobile Application](https://challenge-files.picoctf.net/c_amiable_citadel/980b3f164f672b2bf1d687f5bb7be785cccc6bf6b6ae47805691344117939a68/minions.apk) and try to get the flag.

### 提示 (Hints)

1. Hint 1
   Do you know how to disassemble an apk file?
2. Hint 2
   Any interesting source files?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載 apk 並安裝，發現他提醒使用者要看 values 裡面的 Banana，查看後發現一串字串 `OBUWG32DKRDHWMLUL53TI43OG5PWQNDSMRPXK3TSGR3DG3BRNY4V65DIGNPW2MDCGFWDGX3DGBSDG7I=`

2.  **第二步**：這串字串看起來像是 base64 編碼過後的，之後通靈完以後發現其實是 base32 編碼過後的

## Flag

```text
picoCTF{1t_w4sn7_h4rd_unr4v3l1n9_th3_m0b1l3_c0d3}
```