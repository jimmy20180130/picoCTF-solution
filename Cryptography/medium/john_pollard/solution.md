# john_pollard

## 題目描述 (Description)

Sometimes RSA [certificates](https://challenge-files.picoctf.net/c_fickle_tempest/1856eb14e19d22938afedaf8af8bc267f94616566c1f7b6e9c34d0c890e4908f/cert) are breakable

### 提示 (Hints)

1. Hint 1
   The flag is in the format picoCTF{p,q}
2. Hint 2
   Try swapping p and q if it does not work

## 解題思路 (Solution Walkthrough)

1.  **第一步**：在powershell輸入
    ```text
    openssl x509 -in cert -text -noout
    ```
    得到4966306421059967，factordb分解為67867967,73176001。
    交換一次之後就得到flag了。

## Flag

```text
picoCTF{73176001,67867967}
```