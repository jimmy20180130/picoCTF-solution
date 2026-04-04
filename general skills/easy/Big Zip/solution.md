# Big Zip

## 題目描述 (Description)

Unzip this archive and find the flag.
- [Download zip file](https://artifacts.picoctf.net/c/504/big-zip-files.zip)

### 提示 (Hints)

1. Hint 1  
    Can grep be instructed to look at every file in a directory and its subdirectories?

## 解題思路 (Solution Walkthrough)

1. **第一步**：使用 `rg "picoCTF"` 即可取得 flag

    ```text
    ┌──(kali㉿kali)-[~/Desktop/big-zip-files]
    └─$ rg "picoCTF"
    folder_pmbymkjcya/folder_cawigcwvgv/folder_ltdayfmktr/folder_fnpfclfyee/whzxrpivpqld.txt
    1:information on the record will last a billion years. Genes and brains and books encode picoCTF{gr3p_15_m4g1c_ef8790dc}
    ```

## Flag

```text
picoCTF{gr3p_15_m4g1c_ef8790dc}
```
