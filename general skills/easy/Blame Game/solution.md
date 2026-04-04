# Blame Game

## 題目描述 (Description)

Someone's commits seems to be preventing the program from working. Who is it?
You can download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_titan/73/challenge.zip)

### 提示 (Hints)

1. Hint 1  
    In collaborative projects, many users can make many changes. How can you see the changes within one file?
2. Hint 2  
    Read the chapter on Git from the picoPrimer [here](https://primer.picoctf.org/#_git_version_control).
3. Hint 3  
    You can use `python3 <file>.py` to try running the code, though you won't need to for this challenge.

## 解題思路 (Solution Walkthrough)

1. **第一步**：使用 `git blame .\message.py` 即可取得 flag

## Flag

```text
picoCTF{@sk_th3_1nt3rn_e9957ce1}
```
