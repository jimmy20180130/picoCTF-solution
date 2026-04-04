# Super SSH

## 題目描述 (Description)

Using a Secure Shell (SSH) is going to be pretty important.

### 提示 (Hints)

1. Hint 1  
    [https://linux.die.net/man/1/ssh](https://linux.die.net/man/1/ssh)
2. Hint 2  
    You can try logging in 'as' someone with `<user>`@titan.picoctf.net
3. Hint 3  
    How could you specify the port?
4. Hint 4
    Remember, passwords are hidden when typed into the shell

## 解題思路 (Solution Walkthrough)

1. **第一步**：使用 `ssh ctf-player@titan.picoctf.net -p 60382` 連進去即可得到 flag

## Flag

```text
picoCTF{s3cur3_c0nn3ct10n_8306c99d}
```
