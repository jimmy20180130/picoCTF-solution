# DISKO 1

## 題目描述 (Description)

Can you find the flag in this disk image?
Download the disk image [here](https://artifacts.picoctf.net/c/538/disko-1.dd.gz).

### 提示 (Hints)

1. Hint 1  
    Maybe Strings could help? If only there was a way to do that?

## 解題思路 (Solution Walkthrough)

1. **第一步**：解壓縮完以後用 `strings disko-1.dd | grep "picoCTF"` 即可得到 flag

## Flag

```text
picoCTF{1t5_ju5t_4_5tr1n9_e3408eef}
```
