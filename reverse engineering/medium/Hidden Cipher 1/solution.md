# Hidden Cipher 1

## 題目描述 (Description)

The flag is right in front of you; just slightly encrypted. All you have to do is figure out the cipher and the key. You can download the program files [here](https://challenge-files.picoctf.net/c_candy_mountain/e72b136fdbe2241dfa24ef41443811615436eca1b8b20af3cd4282c72a7576e0/hiddencipher.zip).

### 提示 (Hints)

1. Hint 1
   The binary can be unpacked using a tool that's often pre-installed on Linux
2. Hint 2
   The program hides a secret. Look at how it's defined and used.
3. Hint 3
   Think XOR. What happens when you XOR something twice with the same key?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：發現這個檔案被經過 upx 加殼了，於是先把殼去掉
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$ upx -d hiddencipher
                        Ultimate Packer for eXecutables
                           Copyright (C) 1996 - 2024
   UPX 4.2.4       Markus Oberhumer, Laszlo Molnar & John Reiser    May 9th 2024

         File size         Ratio      Format      Name
      --------------------   ------   -----------   -----------
      24275 <-      7196   29.64%   linux/amd64   hiddencipher

   Unpacked 1 file.
   ```

2.  **第二步**：使用 ida pro，發現有一個函式叫做 get_secret()，將每個從十進位轉成十六進位，再轉成 ASCII 以後就可以得到 `S3Cr3t`
   ```
   char *get_secret()
   {
      s_0 = 83;
      byte_4012 = 51; 
      byte_4013 = 67;
      byte_4014 = 114;
      byte_4015 = 51;
      byte_4016 = 116;
      byte_4017 = 0;
      return &s_0;
   }
   ```

3.  **第三步**：寫了一個腳本對 key 做 xor 即可取得 flag

## Flag

```text
picoCTF{xor_unpack_4nalys1s_cecbcb91}
```