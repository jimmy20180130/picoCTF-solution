# miniRSA

## 題目描述 (Description)

Let's decrypt this.
Can you decrypt this [ciphertext](https://challenge-files.picoctf.net/c_fickle_tempest/85842c29b0cfe5b651df70af3ae29e233ba1fb1fea0e969d0bd6328220e3d589/ciphertext)? Something seems a bit small.

### 提示 (Hints)

1. Hint 1
   RSA tutorial
2. Hint 2
   How could having too small an e affect the security of this 2048 bit key?
3. Hint 3
   Make sure you don't lose precision, the numbers are pretty big (besides the e value)

## 解題思路 (Solution Walkthrough)

1.  **第一步**：發現e非常小，此時對c開e次方根就可以獲得明文。

## Flag

```text
picoCTF{n33d_a_lArg3r_e_3ed950f0}
```