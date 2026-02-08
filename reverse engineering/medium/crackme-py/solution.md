# crackme-py

## 題目描述 (Description)

[crackme_gen.py](https://challenge-files.picoctf.net/c_wily_courier/e866c1dfc766e03bb80e7c92c523d185e6fd1d2e993c67e952916c7ad50009ae/crackme_gen.py)

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載題目提供的python檔，閱讀後發現decode_secret()跟choose_greatest()函式，以及在最上面有一段密文。
    程式預設跑choose_greatest()函式，但裡面什麼都沒有，所以我把程式改成運行decode_secret(bezos_cc_secret)，
    就直接得到flag了。

## Flag

```text
picoCTF{1m_4_p34nut_810cf782288e77}
```