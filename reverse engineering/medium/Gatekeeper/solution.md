# Gatekeeper

## 題目描述 (Description)

What’s behind the numeric gate? You only get access if you enter the *right* kind of number. You can download the program file [here](https://challenge-files.picoctf.net/c_green_hill/5257839687f1f598bc62247237a80e7bf2e3aeef525d51eaf42bbd0738a835c1/gatekeeper).

### 提示 (Hints)

1. Hint 1
   Tools like **Ghidra**, **IDA Free**, or **Radare2** can analyze the binary’s logic.
2. Hint 2
   The program’s output isn’t straightforward; reversing the string and cleaning out extra text may help you recover the flag.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：先看一下他的邏輯，基本上輸入的東西長度要等於三，且轉換成十進位以後要大於 999 且小於等於 9999，所以直接輸入十進位的數字基本上不可能
   ```c
   int __fastcall main(int argc, const char ** argv, const char ** envp) {
      int v4; // [rsp+8h] [rbp-38h]
      int v5; // [rsp+Ch] [rbp-34h]
      char s[40]; // [rsp+10h] [rbp-30h] BYREF
      unsigned __int64 v7; // [rsp+38h] [rbp-8h]

      v7 = __readfsqword(0x28 u);
      printf("Enter a numeric code (must be > 999 ): ");
      fflush(stdout);
      __isoc99_scanf("%31s", s);
      v5 = strlen(s);

      // 檢查是否全由數字組成，不是的話就把他當十六進位的數字來解讀
      if ((unsigned int) is_valid_decimal(s)) {
         v4 = atoi(s);

      } else {
         if (!(unsigned int) is_valid_hex(s)) {
            puts("Invalid input.");
            return 1;
         }
         v4 = strtol(s, 0, 16);
      }

      if (v4 > 999) {
         if (v4 <= 9999) {
            if (v5 == 3)
            reveal_flag();
            else
            puts("Access Denied.");
         } else {
            puts("Too high.");
         }
      } else {
         puts("Too small.");
      }
      return 0;
   }
   ```

2.  **第二步**：於是我嘗試輸入 1000 的十六進位 (3E8)，發現成功了，拿到一串混淆過的 flag
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$  nc green-hill.picoctf.net 62632
   Enter a numeric code (must be > 999 ): 3E8
   Access granted: }e78ftc_oc_ipde8cftc_oc_ipc_99ftc_oc_ip9_TGftc_oc_ip_xehftc_oc_ip_tigftc_oc_ipid_3ftc_oc_ip{FTCftc_oc_ipocipftc_oc_ip
   ```

3.  **第三步**：混淆 flag 的方法如下，他是從字串的最後一位開始往前減，直到 0 為止，如果 i 是四的倍數就印出 `ftc_oc_ip`，於是寫了一個腳本成功取得 flag
   ```c
   for ( i = n - 1; i >= 0; --i )
   {
      putchar(ptr[i]);
      if ( (i & 3) == 0 )
         printf("ftc_oc_ip");
   }
   ```

## Flag

```text
picoCTF{3_digit_hex_GT_999_cc8ed87e}
```