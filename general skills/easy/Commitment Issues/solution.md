# Commitment Issues

## 題目描述 (Description)

I accidentally wrote the flag down. Good thing I deleted it!
You download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_titan/138/challenge.zip)

### 提示 (Hints)

1. Hint 1  
    Version control can help you recover files if you change or lose them!
2. Hint 2  
    Read the chapter on Git from the picoPrimer [here](https://primer.picoctf.org/#_git_version_control)
3. Hint 3
    You can 'checkout' commits to see the files inside them

## 解題思路 (Solution Walkthrough)

1. **第一步**：使用 `git log -p`，再使用 `git show b562f0b425907789d11d2fe2793e67592dc6be93` 即可取得 flag

## Flag

```text
picoCTF{s@n1t1z3_c785c319}
```
