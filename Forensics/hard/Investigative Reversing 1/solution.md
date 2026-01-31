# Investigative Reversing 1

## 題目描述 (Description)

We have recovered a [binary](https://challenge-files.picoctf.net/c_fickle_tempest/3aeddcd34ea793b113c05097c002e6b3d187f224908bd1a85a8e7a1e11d15220/mystery) and a few images: [image](https://challenge-files.picoctf.net/c_fickle_tempest/3aeddcd34ea793b113c05097c002e6b3d187f224908bd1a85a8e7a1e11d15220/mystery.png), [image2](https://challenge-files.picoctf.net/c_fickle_tempest/3aeddcd34ea793b113c05097c002e6b3d187f224908bd1a85a8e7a1e11d15220/mystery2.png), [image3](https://challenge-files.picoctf.net/c_fickle_tempest/3aeddcd34ea793b113c05097c002e6b3d187f224908bd1a85a8e7a1e11d15220/mystery3.png). See what you can make of it. There should be a flag somewhere.

### 提示 (Hints)

1. Hint 1
   Try using some forensics skills on the image
2. Hint 2
   This problem requires both forensics and reversing skills
3. Hint 3
   A hex editor may be helpful

## 解題思路 (Solution Walkthrough)

1.  **第一步**：用 ida 來反編譯 mystery，看到 main 函式如下(經過修改過的)
   ```c
   int __fastcall main(int argc, const char **argv, const char **envp)
   {
      char v5; // [rsp+Dh] [rbp-63h]
      char v6; // [rsp+Eh] [rbp-62h]
      char v7; // [rsp+Fh] [rbp-61h]
      int i; // [rsp+10h] [rbp-60h]
      int j; // [rsp+14h] [rbp-5Ch]
      int k; // [rsp+18h] [rbp-58h]
      FILE *stream; // [rsp+20h] [rbp-50h]
      FILE *my1; // [rsp+28h] [rbp-48h]
      FILE *my2; // [rsp+30h] [rbp-40h]
      FILE *my3; // [rsp+38h] [rbp-38h]
      _BYTE ptr[40]; // [rsp+40h] [rbp-30h] BYREF
      unsigned __int64 v16; // [rsp+68h] [rbp-8h]

      v16 = __readfsqword(0x28u);
      stream = fopen("flag.txt", "r");
      my1 = fopen("mystery.png", "a");
      my2 = fopen("mystery2.png", "a");
      my3 = fopen("mystery3.png", "a");
      if ( !stream )
         puts("No flag found, please make sure this is run on the server");
      if ( !my1 )
         puts("mystery.png is missing, please run this on the server");
      fread(ptr, 0x1Au, 1u, stream);
      v7 = ptr[0];
      fputc(ptr[1], my3);
      fputc((char)(v7 + 21), my2);
      fputc(ptr[2], my3);
      v5 = ptr[3];
      v6 = ptr[4];
      fputc(ptr[5], my3);
      fputc(v6, my1);
      for ( i = 6; i <= 9; ++i )
      {
         ++v5;
         fputc((char)ptr[i], my1);
      }
      fputc(v5, my2);
      for ( j = 10; j <= 14; ++j )
         fputc((char)ptr[j], my3);
      for ( k = 15; k <= 25; ++k )
         fputc((char)ptr[k], my1);
      fclose(my1);
      fclose(stream);
      return __readfsqword(0x28u) ^ v16;
   }
   ```

2.  **第二步**：由上述程式碼可得知這個 mystery 的用途在於把 flag.txt 的前 26 bytes，規則如下
   
   | 原始位元組 (Index) | 運算方式         | 寫入目標檔案 |
   | ------------------ | ---------------- | ------------ |
   | ptr[0]             | +21              | mystery2.png |
   | ptr[1]             | 照原本的順序寫入 | mystery3.png |
   | ptr[2]             | 照原本的順序寫入 | mystery3.png |
   | ptr[3]             | +4               | mystery2.png |
   | ptr[4]             | 照原本的順序寫入 | mystery.png  |
   | ptr[5]             | 照原本的順序寫入 | mystery3.png |
   | ptr[6] ~ ptr[9]    | 照原本的順序寫入 | mystery.png  |
   | ptr[10] ~ ptr[14]  | 照原本的順序寫入 | mystery3.png |
   | ptr[15] ~ ptr[25]  | 照原本的順序寫入 | mystery.png  |

3.  **第三步**：於是寫了一個腳本成功從圖片裡面讀取出來 flag

## Flag

```text
picoCTF{An0tha_1_8a448cb2}
```