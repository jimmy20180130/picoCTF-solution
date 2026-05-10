# vault-door-4

## 題目描述 (Description)

This vault uses ASCII encoding for the password.
The source code for this vault is here: [VaultDoor3.java](https://challenge-files.picoctf.net/c_fickle_tempest/5c887bc56d0c788895c28b80d7b702aff7b889fc7d8edf83fe0dc25c8aa11756/VaultDoor4.java)

### 提示 (Hints)

1. Hint 1  
    Use a search engine to find an "ASCII table"
2. Hint 2  
    You will also need to know the difference between octal, decimal, and hexadecimal numbers.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```text
    public boolean checkPassword(String password) {
        byte[] passBytes = password.getBytes();
        byte[] myBytes = {
            106 , 85  , 53  , 116 , 95  , 52  , 95  , 98  ,
            0x55, 0x6e, 0x43, 0x68, 0x5f, 0x30, 0x66, 0x5f,
            0142, 0131, 0164, 063 , 0163, 0137, 0145, 060 ,
            '2' , '1' , '3' , '8' , '7' , '2' , '1' , '3' ,
        };
        for (int i=0; i<32; i++) {
            if (passBytes[i] != myBytes[i]) {
                return false;
            }
        }
        return true;
    }
    ```
    把上面的myBytes照順序轉回文字即可。

## Flag

```text
picoCTF{jU5t_4_bUnCh_0f_bYt3s_e021387213}
```