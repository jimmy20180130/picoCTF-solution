# Transformation

## 題目描述 (Description)

I wonder what this really is...
[enc](https://challenge-files.picoctf.net/c_wily_courier/acd4ffc228784496e0a2c6445bba7646a457dcf13d9faca2f390c0d6259c25cb/enc) ''.join([chr((ord(flag[i]) << 8) + ord(flag[i + 1])) for i in range(0, len(flag), 2)])

### 提示 (Hints)

1. Hint 1
   You may find some decoders online

## 解題思路 (Solution Walkthrough)

1.  **第一步**：題目敘述已經提供了生成 enc 的方法，基本上就是把每兩個字元（8 bits + 8 bits）透過 bitwise left shift 與加法合併為一個 16-bit 整數再以 Unicode 字元形式儲存，於是照著它的方法寫出一個腳本成功還原出 flag

## Flag

```text
picoCTF{16_bits_inst34d_of_8_b7f62ca5}
```