# droids0

## 題目描述 (Description)

Where do droid logs go. Check out this [file](https://challenge-files.picoctf.net/c_fickle_tempest/8a5028cf509544247e42398da9ffaa69a93225064a331dbf5a31066d44157f3f/zero.apk).

### 提示 (Hints)

1. Hint 1
   Try using an emulator or device
2. Hint 2
   https://developer.android.com/studio

## 解題思路 1 (Solution Walkthrough 1)

1.  **第一步**：用 jadx 分析 zero.apk，發現取得 flag 的函式在這裡
   ```Java
   /* loaded from: classes.dex */
   public class FlagstaffHill {
      public static native String paprika(String str);

      public static String getFlag(String input, Context ctx) {
         Log.i("PICO", paprika(input));
         return "Not Today...";
      }
   }
   ```

2.  **第二步**：接著用 ida pro 分析 `libhellojni.so`，發現底下這段，它的邏輯是
   先取得使用者輸入的字串 (`v8`)，如果 dill(v8) 的結果與 1 進行位元與運算後不為 0 (即結果為真)，程式就會繼續跑下去，不過 dill 永遠都會回傳 1 就是了。取得 `v8` 以後程式會呼叫 `marjoram`
   ```C
   __int64 __fastcall Java_com_hellocmu_picoctf_FlagstaffHill_paprika(__int64 a1, __int64 a2, __int64 a3)
   {
      char *v4; // [xsp+8h] [xbp-58h]
      __int64 v5; // [xsp+28h] [xbp-38h]
      char v6; // [xsp+3Fh] [xbp-21h]
      __int64 v7; // [xsp+40h] [xbp-20h]

      v7 = (*(__int64 (__fastcall **)(__int64, __int64, _QWORD))(*(_QWORD *)a1 + 1352LL))(a1, a3, 0);
      v6 = dill() & 1;
      (*(void (__fastcall **)(__int64, __int64, __int64))(*(_QWORD *)a1 + 1360LL))(a1, a3, v7);
      if ( (v6 & 1) != 0 )
         v4 = (char *)marjoram();
      else
         v4 = "try again";
      v5 = (*(__int64 (__fastcall **)(__int64, char *))(*(_QWORD *)a1 + 1336LL))(a1, v4);
      free(v4);
      return v5;
   }
   ```
   `marjoram` 基本上就是傳入金鑰 (notexist) 和加密後的 Flag (記憶體中 unk_1D32 的地方) 給 `unscramble`
   ```C
   _BYTE *marjoram()
   {
      int v0; // w0
      char *v2; // [xsp+8h] [xbp-28h]

      v2 = strdup("notexist");
      v0 = strlen("notexist");
      return unscramble((__int64)&unk_1D32, 35, (__int64)v2, v0);
   }
   ```
   `unscramble` 則是使用 XOR 解密得到 flag
   ```C
   _BYTE *__fastcall unscramble(__int64 a1, int a2, __int64 a3, int a4)
   {
      int v5; // [xsp+0h] [xbp-30h]
      int i; // [xsp+4h] [xbp-2Ch]
      _BYTE *v7; // [xsp+8h] [xbp-28h]

      v7 = calloc(a2, 1u);
      v5 = 0;
      for ( i = 0; i < a2; ++i )
      {
         v7[i] = *(_BYTE *)(a1 + i) ^ *(_BYTE *)(a3 + v5 % a4);
         ++v5;
      }
      return v7;
   }
   ```

3.  **第三步**：後來查看了 `unk_1D32` 的資料，並寫了一個腳本來取得 flag
   ```
   .rodata:0000000000001D32 unk_1D32        DCB 0x1E                ; DATA XREF: marjoram+14↑o
   .rodata:0000000000001D33                 DCB    6
   .rodata:0000000000001D34                 DCB 0x17
   .rodata:0000000000001D35                 DCB  0xA
   .rodata:0000000000001D36                 DCB 0x3B ; ;
   .rodata:0000000000001D37                 DCB 0x3D ; =
   .rodata:0000000000001D38                 DCB 0x35 ; 5
   .rodata:0000000000001D39                 DCB  0xF
   .rodata:0000000000001D3A                 DCB  0xF
   .rodata:0000000000001D3B                 DCB 0x41 ; A
   .rodata:0000000000001D3C                 DCB 0x19
   .rodata:0000000000001D3D                 DCB  0xA
   .rodata:0000000000001D3E                 DCB 0x17
   .rodata:0000000000001D3F                 DCB 0x1A
   .rodata:0000000000001D40                 DCB 0x16
   .rodata:0000000000001D41                 DCB 0x5A ; Z
   .rodata:0000000000001D42                 DCB    1
   .rodata:0000000000001D43                 DCB    1
   .rodata:0000000000001D44                 DCB 0x17
   .rodata:0000000000001D45                 DCB    0
   .rodata:0000000000001D46                 DCB 0x56 ; V
   .rodata:0000000000001D47                 DCB  0xB
   .rodata:0000000000001D48                 DCB 0x1A
   .rodata:0000000000001D49                 DCB    0
   .rodata:0000000000001D4A                 DCB 0x40 ; @
   .rodata:0000000000001D4B                 DCB    2
   .rodata:0000000000001D4C                 DCB  0xD
   .rodata:0000000000001D4D                 DCB 0x4B ; K
   .rodata:0000000000001D4E                 DCB  0xB
   .rodata:0000000000001D4F                 DCB    0
   .rodata:0000000000001D50                 DCB    0
   .rodata:0000000000001D51                 DCB    0
   .rodata:0000000000001D52                 DCB  0xB
   .rodata:0000000000001D53                 DCB 0x1D
   .rodata:0000000000001D54                 DCB    9
   .rodata:0000000000001D55                 DCB    0
   ```

## 解題思路 2 (Solution Walkthrough 2)

1. **第一步**：直接打開 android studio 的模擬器，裝好 zero.apk 後按它的按鈕，即可在 Logcat 裡面看到 flag
   ```
   PICO                    com.hellocmu.picoctf                 I  picoCTF{a.moose.once.bit.my.sister}
   ```

## Flag

```text
picoCTF{a.moose.once.bit.my.sister}
```