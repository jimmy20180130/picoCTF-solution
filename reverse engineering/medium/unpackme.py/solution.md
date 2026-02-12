# unpackme.py

## 題目描述 (Description)

Can you get the flag?
Reverse engineer this [Python program](https://artifacts.picoctf.net/c/49/unpackme.flag.py).

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載題目後，發現程式本身就可以自己解密。
    只要把exec()改成print()就可以拿到flag了。
    執行結果如下：
    ```text
    pw = input('What\'s the password? ')

    if pw == 'batteryhorse':
        print('picoCTF{175_chr157m45_cd82f94c}')
    else:
        print('That password is incorrect.')
    ```

## Flag

```text
picoCTF{175_chr157m45_cd82f94c}
```