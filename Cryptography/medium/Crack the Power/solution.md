# Crack the Power

## 題目描述 (Description)

We received an encrypted message. The modulus is built from primes large enough that factoring them isn’t an option, at least not today. See if you can make sense of the numbers and reveal the flag.
Download the [message](https://challenge-files.picoctf.net/c_amiable_citadel/064d4179839d2d7423ffdb19ce407b8ab56ac27afbb579983a98ced35a174ea4/message.txt).

### 提示 (Hints)

1. Hint 1
   When certain values in the encryption setup are smaller than usual, it opens up unexpected shortcuts to recover the plaintext
2. Hint 2
   Consider whether you can invert the encryption without factoring `n`.
3. Hint 3
   Read more about Coppersmith's_attack [here](https://en.wikipedia.org/wiki/Coppersmith's_attack)

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看到 message.txt 裡面有 n, e, c，推斷這個是和 RSA 有關

2.  **第二步**：由於 e 非常小 (明顯小於 65537)，於是我嘗試使用 [Coppersmith's Attack](https://ctf-wiki.org/zh-tw/crypto/asymmetric/rsa/rsa_coppersmith_attack/)，並請 AI 寫一個腳本來解，即可取得到 flag

## Flag

```text
picoCTF{t1ny_e_4da5fb4d}
```