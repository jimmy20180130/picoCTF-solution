# shift registers

## 題目描述 (Description)

I learned about lfsr today in school so i decided to implement it in my program. It must be safe right? [chall.py](https://challenge-files.picoctf.net/c_plain_mesa/0cd8d68d4aacefd8d1924ea6452a8727990af562d813838e2bc5b4e7a57f79f8/chall.py) [output.txt](https://challenge-files.picoctf.net/c_plain_mesa/0cd8d68d4aacefd8d1924ea6452a8727990af562d813838e2bc5b4e7a57f79f8/output.txt)

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1. **第一步**：先看程式碼
    1. 可以看到在一開始會先生成 126 bytes 的 key，但實際上會用到的只有 8 位元，因為他會和 0xFF 進行位元的 AND 運算

        ```py
        key = bytes_to_long(get_random_bytes(126))
        ...
        lfsr = key & 0xFF
        ```

    2. 由於是 8 位元，所以我們可以直接暴力破解，只需嘗試最多 2^8 = 256 次即可取得 flag
    3. 且因為他是把 key 和明文進行 XOR，根據 XOR 的對稱性，所以我們拿 key 和密文進行 XOR 即可得到原本的明文

2. **第二步**：於是寫了一個腳本並得到 flag

## Flag

```text
picoCTF{l1n3ar_f33dback_sh1ft_r3g}
```
