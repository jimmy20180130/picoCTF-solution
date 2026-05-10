# vault-door-6

## 題目描述 (Description)

This vault uses an XOR encryption scheme.
The source code for this vault is here: [VaultDoor6.java](https://challenge-files.picoctf.net/c_fickle_tempest/71b3c781eb39e5cac19d553c3b3377d3bf561dcb08d6e65fecc7638e2afe3b63/VaultDoor6.java)

### 提示 (Hints)

1. Hint 1  
    If X ^ Y = Z, then Z ^ Y = X. Write a program that decrypts the flag based on this fact.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```java
    public boolean checkPassword(String password) {
        if (password.length() != 32) {
            return false;
        }
        byte[] passBytes = password.getBytes();
        byte[] myBytes = {
            0x3b, 0x65, 0x21, 0xa , 0x38, 0x0 , 0x36, 0x1d,
            0xa , 0x3d, 0x61, 0x27, 0x11, 0x66, 0x27, 0xa ,
            0x21, 0x1d, 0x61, 0x3b, 0xa , 0x2d, 0x65, 0x27,
            0xa , 0x33, 0x31, 0x31, 0x61, 0x60, 0x33, 0x67,
        };
        for (int i=0; i<32; i++) {
            if (((passBytes[i] ^ 0x55) - myBytes[i]) != 0) {
                return false;
            }
        }
        return true;
    }
    ```
    根據hint的提示，只要把myBytes XOR 0x55即可得flag，因為XOR可逆。

## Flag

```text
picoCTF{n0t_mUcH_h4rD3r_tH4n_x0r_fdd45f2}
```