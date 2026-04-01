# Secure Password Database

## 題目描述 (Description)

I made a new password authentication program that even shows you the password you entered saved in the database! Isn't that cool? [system.out](https://challenge-files.picoctf.net/c_candy_mountain/4724bf8a88a0b49eea63b1458e128d84e7f1322a8327751b9608fa059f53fbd1/system.out)
Additional details will be available after launching your challenge instance.

### 提示 (Hints)

1. Hint 1
   How does the hashing algorithm work?

## 解題思路 (Solution Walkthrough)
1.  **第一步**：把程式丟到 ida pro 裡面反編譯後，發現有個叫做 `make_secret` 的函數，基本上就是把存在 .rodata 裡面的 12 位元組的東西和 0xAA 做 XOR 運算
   ```c
   __int64 __fastcall make_secret(__int64 a1)
   {
      __int64 i; // [rsp+10h] [rbp-8h]

      for ( i = 0; obf_bytes[i]; ++i )
         *(_BYTE *)(a1 + i) = obf_bytes[i] ^ 0xAA;
      *(_BYTE *)(a1 + 12) = 0;
      return hash(a1);
   }
   ```

2.  **第二步**：接著查看函數 `hash`，上網查了一下後發現他是使用 `djb2` 算法
   ```c
   __int64 __fastcall hash(_BYTE *a1)
   {
      _BYTE *v1; // rax
      __int64 i; // [rsp+10h] [rbp-8h]

      for ( i = 5381; ; i = 33 * i + (unsigned __int8)*v1 )
      {
         v1 = a1++;
         if ( !*v1 )
            break;
      }
      return i;
   }
   ```

3.  **第三步**：寫了一個腳本，成功取得 flag
   ```
   Please set a password for your account:
   wfejpfew (隨便打)
   How many bytes in length is your password?
   23809 (隨便打)
   You entered: 23809
   Your successfully stored password:
   106 
   Enter your hash to access your account!
   15237662580160011234
   picoCTF{d0nt_trust_us3rs}
   ```

## Flag

```text
picoCTF{d0nt_trust_us3rs}
```