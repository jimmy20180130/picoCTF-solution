# First Grep

## 題目描述 (Description)

Can you find the flag in the file? This would be really tedious to look through manually, something tells me there is a better way.
The flag is in this [file](https://challenge-files.picoctf.net/c_fickle_tempest/d0b2e96347614d19414d591c946a1789fa8bd35487fcbfabf9437d0acfcaa503/file).

### 提示 (Hints)

1. Hint 1  
    grep tutorial

## 解題思路 (Solution Walkthrough)

1. **第一步**：用 `grep` 即可

    ```text
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ strings file | grep -o "picoCTF{.*}"                                                                                    
    picoCTF{grep_is_good_to_find_things_e3C4b360}
    ```

## Flag

```text
picoCTF{grep_is_good_to_find_things_e3C4b360}
```
