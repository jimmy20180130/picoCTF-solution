# strings it

## 題目描述 (Description)

Can you find the flag in [file](https://challenge-files.picoctf.net/c_fickle_tempest/a35dc624cfda858ed12a4bce57f832dad3b433bad6cde2b98e25fae4bc8ff760/strings) without running it?

### 提示 (Hints)

1. Hint 1  
    strings

## 解題思路 (Solution Walkthrough)

1. **第一步**：用 `grep` 即可取得 flag

    ```text
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ strings strings | grep -o "picoCTF{.*}" 
    picoCTF{5tRIng5_1T_60eA8fdA}
    ```

## Flag

```text
picoCTF{5tRIng5_1T_60eA8fdA}
```
