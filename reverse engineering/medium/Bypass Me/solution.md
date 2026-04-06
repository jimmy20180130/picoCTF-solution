# Bypass Me

## 題目描述 (Description)

Your task is to analyze and exploit a password-protected binary called **bypassme.bin** and binary performs input sanitization.
However, instead of guessing the password, you are expected to reverse engineer or debug the program to bypass the authentication logic and retrieve the hidden flag.
You'll need to think like an attacker using tool like [LLDB](https://lldb.llvm.org/use/tutorial.html) to uncover how the binary works under the hood and leak the correct password.

### 提示 (Hints)

1. Hint 1  
    Try disassembling the binary to understand its inner workings.
2. Hint 2  
    Pay special attention to functions available
3. Hint 3
    The password might be hidden or decoded at runtime

## 解題思路 (Solution Walkthrough)

1. **第一步**：先用 `ssh ctf-player@foggy-cliff.picoctf.net -p 49517` 連上伺服器，發現裡面有個 `bypassme.bin`，嘗試了一下，他似乎會把輸入的東西除了英文字母外的其他東西都過濾掉

2. **第二步**：使用 `scp -P 49517 ctf-player@foggy-cliff.picoctf.net:/home/ctf-player/bypassme.bin .` 把檔案下載到我的電腦上，並用 ida 開始 reverse engineering
    1. 先看到 `decode_password` 這個函數

        ```c
        void __cdecl decode_password(char *out)
        {
            int i; // [rsp+18h] [rbp-18h]
            unsigned __int8 enc[11]; // [rsp+1Dh] [rbp-13h]
            unsigned __int64 v3; // [rsp+28h] [rbp-8h]

            v3 = __readfsqword(0x28u);
            *(_QWORD *)enc = 0xC9CFF9D8CFDADFF9LL;
            *(_WORD *)&enc[8] = -10017;
            enc[10] = -49;
            for ( i = 0; (unsigned __int64)i <= 0xA; ++i )
                out[i] = enc[i] ^ 0xAA;
            out[11] = 0;
        }
        ```

    2. 可以發現有一個叫做 enc 的 hex，它的值為 `C9 CF F9 D8 CF DA DF F9`，共 8 byte
    3. 接著可以看到 `*(_WORD *)&enc[8] = -10017;`，轉換成 16 進位以後為 `D8DF`，因為前面有說他是 `_WORD`，所以佔 2 byte，故不會被截斷
    4. 最後 `-49` 轉換成 16 進位以後是 `FFCF`，因為他是一個 `unsigned __int8`，只有 1 byte，故 `FF` 會被截斷，只留下 `CF`

3. **第三步**：因為在 `x86` 的系統裡面是以 `little-endian` 存放的，所以說實際上的順序是 `F9 DF DA CF D8 F9 CF C9` + `DF D8` + `CF`
4. **第四步**：最後將每個 byte 和 `0xAA` 做 XOR 即可得到密碼

## Flag

```text
picoCTF{d3bugg3r_p0w3r_is_4w3s0m3_52875073}
```
