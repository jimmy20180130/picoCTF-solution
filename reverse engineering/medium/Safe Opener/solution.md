# Safe Opener

## 題目描述 (Description)

Can you open this safe?
I forgot the key to my safe but this [program](https://artifacts.picoctf.net/c/83/SafeOpener.java) is supposed to help me with retrieving the lost key. Can you help me unlock my safe?
Put the password you recover into the picoCTF flag format like:
```text
picoCTF{password}
```

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載題目給的程式後，發現程式會在輸入正確密碼時會print Sesame open。
    程式第六行有提到Base64，加上第31行有給encodedkey，所以我就把encodedkey用Base64 decode，得到：
    ```text
    pl3as3_l3t_m3_1nt0_th3_saf3
    ```
    將這段文字放入picoCTF{}內，即為答案。

## Flag

```text
picoCTF{pl3as3_l3t_m3_1nt0_th3_saf3}
```