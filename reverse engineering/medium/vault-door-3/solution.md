# vault-door-3

## 題目描述 (Description)

This vault uses for-loops and byte arrays.
The source code for this vault is here: [VaultDoor3.java](https://challenge-files.picoctf.net/c_fickle_tempest/4cff24ee8b551078be8c14758fae20ab4a2dca78746aef367bc854491b8ee465/VaultDoor3.java)

### 提示 (Hints)

1. Hint 1  
    Make a table that contains each value of the loop variables and the corresponding buffer index that it writes to.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```text
    char[] buffer = new char[32];
        int i;
        for (i=0; i<8; i++) {
            buffer[i] = password.charAt(i);
        }
        for (; i<16; i++) {
            buffer[i] = password.charAt(23-i);
        }
        for (; i<32; i+=2) {
            buffer[i] = password.charAt(46-i);
        }
        for (i=31; i>=17; i-=2) {
            buffer[i] = password.charAt(i);
        }
        String s = new String(buffer);
        return s.equals("jU5t_a_sna_3lpm1cg04e_u_4_m6rb42");
    ```
    依照程式的邏輯把原本的string變回去即可。
    0-7一樣，8-15 reverse，16-31分奇偶reverse。

## Flag

```text
picoCTF{jU5t_a_s1mpl3_an4gr4m_4_u_e60bc2}
```