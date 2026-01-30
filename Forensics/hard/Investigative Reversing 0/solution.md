# Investigative Reversing 0

## 題目描述 (Description)

We have recovered a [binary](https://challenge-files.picoctf.net/c_fickle_tempest/273ec6d35c80adde1b9b4e3eadb98151e731e38fb28add3dd11704103977fe44/mystery) and an [image](https://challenge-files.picoctf.net/c_fickle_tempest/273ec6d35c80adde1b9b4e3eadb98151e731e38fb28add3dd11704103977fe44/mystery.png). See what you can make of it. There should be a flag somewhere.

### 提示 (Hints)

1. Hint 1
   Try using some forensics skills on the image
2. Hint 2
   This problem requires both forensics and reversing skills
3. Hint 3
   A hex editor may be helpful

## 解題思路 (Solution Walkthrough)

1.  **第一步**：用 ida 來反編譯 mystery，看到 main 函式如下
   ```c
   int __fastcall main(int argc, const char **argv, const char **envp)
   {
      int i; // [rsp+4h] [rbp-4Ch]
      int j; // [rsp+8h] [rbp-48h]
      FILE *stream; // [rsp+10h] [rbp-40h]
      FILE *v8; // [rsp+18h] [rbp-38h]
      _BYTE ptr[40]; // [rsp+20h] [rbp-30h] BYREF
      unsigned __int64 v10; // [rsp+48h] [rbp-8h]

      v10 = __readfsqword(0x28u);
      stream = fopen("flag.txt", "r");
      v8 = fopen("mystery.png", "a");
      if ( !stream )
         puts("No flag found, please make sure this is run on the server");
      if ( !v8 )
         puts("mystery.png is missing, please run this on the server");
      if ( (int)fread(ptr, 0x1Au, 1u, stream) <= 0 )
         exit(0);
      puts("at insert");
      fputc(ptr[0], v8);
      fputc(ptr[1], v8);
      fputc(ptr[2], v8);
      fputc(ptr[3], v8);
      fputc(ptr[4], v8);
      fputc(ptr[5], v8);
      for ( i = 6; i <= 14; ++i )
         fputc((char)(ptr[i] + 5), v8);
      fputc((char)(ptr[15] - 3), v8);
      for ( j = 16; j <= 25; ++j )
         fputc((char)ptr[j], v8);
      fclose(v8);
      fclose(stream);
      return __readfsqword(0x28u) ^ v10;
   }
   ```

2.  **第二步**：由上述程式碼可得知這個 mystery 的用途在於把 flag.txt 的前 26 bytes，規則如下
   ```
   0 ~ 5: 照原本的順序寫入
   6 ~ 14: 每個 byte +5
   15: -3
   16 ~ 25: 照原本的順序寫入
   ```

3.  **第三步**：於是寫了一個腳本成功從 mystery.png 裡面讀取出來 flag

## Flag

```text
picoCTF{f0und_1t_b3ea3199}
```