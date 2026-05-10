# vault-door-7

## 題目描述 (Description)

This vault uses bit shifts to convert a password string into an array of integers. Hurry, agent, we are running out of time to stop Dr. Evil's nefarious plans!
The source code for this vault is here: [VaultDoor7.java](https://challenge-files.picoctf.net/c_fickle_tempest/aba9467d0608d26f53ee4d07ea28da087b13c350aed779044e89c437f6ca3b66/VaultDoor7.java)

### 提示 (Hints)

1. Hint 1  
    Use a decimal/hexadecimal converter such as this one: https://www.mathsisfun.com/binary-decimal-hexadecimal-converter.html
2. Hint 2  
    You will also need to consult an ASCII table such as this one: https://www.asciitable.com/

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```java
    public int[] passwordToIntArray(String hex) {
        int[] x = new int[8];
        byte[] hexBytes = hex.getBytes();
        for (int i=0; i<8; i++) {
            x[i] = hexBytes[i*4]   << 24
                 | hexBytes[i*4+1] << 16
                 | hexBytes[i*4+2] << 8
                 | hexBytes[i*4+3];
        }
        return x;
    }

    public boolean checkPassword(String password) {
        if (password.length() != 32) {
            return false;
        }
        int[] x = passwordToIntArray(password);
        return x[0] == 1096770097
            && x[1] == 1952395366
            && x[2] == 1600270708
            && x[3] == 1601398833
            && x[4] == 1716808014
            && x[5] == 1734305081
            && x[6] == 1681274424
            && x[7] == 1700935729;
    }
    ```
    根據上面的程式碼，可以得知程式先把32bytes的password先切成4個bytes的小區塊，總共有八個，並轉成int形式儲存。
    可理解為將每個byte分別轉成hex並左移，第一個byte在0xab000000，第二個byte在0x00cd0000，依此類推。
    所以我們只需要把拿來比較的int還原，即可得flag。
    即為：先轉hex，再依序右移，最後取得個別文字。
    回推後即可得flag。

## Flag

```text
picoCTF{A_b1t_0f_b1t_sh1fTiNg_e9d668eb81}
```