# extensions

## 題目描述 (Description)

This is a really weird text file. Can you find the flag?
Get the flag from [TXT](https://challenge-files.picoctf.net/c_fickle_tempest/31fe772e6a4c71e867af0b2a93818e06d8f8ebf8af2a9615495d00356ff576da/flag.txt).

### 提示 (Hints)

1. Hint 1
   How do operating systems know what kind of file it is? (It's not just the ending!)
2. Hint 2
   Make sure to submit the flag as picoCTF{XXXXX}

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載flag.txt，無法看出內容是什麼，只看到亂碼。
    但能在其中看到IDHR、sRGB、gAMA，能推斷出他大概是PNG檔。
    打開powershell之後把flag.txt改為flag.png即可，指令如下：
```text
Rename-Item mystery.txt mystery.png

```
    打開圖片，即可得到flag。


## Flag

```text
picoCTF{now_you_know_about_extensions}
```