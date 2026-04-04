# Password Profiler

## 題目描述 (Description)

We intercepted a suspicious file from a system, but instead of the password itself, it only contains its SHA-1 hash. Using OSINT techniques, you are provided with personal details about the target. Your task is to leverage this information to generate a custom password list and recover the original password by matching its hash.
Download the following files:
[userinfo](https://challenge-files.picoctf.net/c_plain_mesa/3c16fb8e48ddae444f6840e81660a5a8cb2d30b69092b04f619d6ac34676a919/userinfo.txt): Contains the personal details.
[hash](https://challenge-files.picoctf.net/c_plain_mesa/3c16fb8e48ddae444f6840e81660a5a8cb2d30b69092b04f619d6ac34676a919/hash.txt): Contains the SHA-1 hash of the password.
[check_password](https://challenge-files.picoctf.net/c_plain_mesa/3c16fb8e48ddae444f6840e81660a5a8cb2d30b69092b04f619d6ac34676a919/check_password.py): Script to test passwords against the hash.

### 提示 (Hints)

1. Hint 1  
    [CUPP](https://github.com/Mebus/cupp) is a Python tool for generating custom wordlists from personal data.

## 解題思路 (Solution Walkthrough)

1. **第一步**：看提示發現要用 `CUPP`

2. **第二步**：使用 `CUPP` 生成密碼清單 (`python cupp.py -i`)

3. **第三步**：將清單儲存成 `passwords.txt` 並使用 `python check_password.py` 即可取得 flag

## Flag

```text
picoCTF{Aj_15901990}
```
