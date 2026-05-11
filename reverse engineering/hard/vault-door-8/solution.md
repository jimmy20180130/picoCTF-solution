# vault-door-8

## 題目描述 (Description)

Apparently Dr. Evil's minions knew that our agency was making copies of their source code, because they intentionally sabotaged this source code in order to make it harder for our agents to analyze and crack into! The result is a quite mess, but I trust that my best special agent will find a way to solve it.
The source code for this vault is here: [VaultDoor8.java](https://challenge-files.picoctf.net/c_fickle_tempest/7b22d7252d03694e5cb7f1b4d68ad41d724666a0835a2460753d19738271a7e1/VaultDoor8.java)

### 提示 (Hints)

1. Hint 1  
    Clean up the source code so that you can read it and understand what is going on.
2. Hint 2  
    Draw a diagram to illustrate which bits are being switched in the scramble() method, then figure out a sequence of bit switches to undo it. You should be able to reuse the switchBits() method as is.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```java
    public char[] scramble(String password) {
        /* Scramble a password by transposing pairs of bits. */
        char[] a = password.toCharArray();

        for (int b=0; b<a.length; b++) {
            char c = a[b];
            c = switchBits(c,1,2);
            c = switchBits(c,0,3);
            /* c = switchBits(c,14,3); c = switchBits(c, 2, 0); */
            c = switchBits(c,5,6);
            c = switchBits(c,4,7);
            c = switchBits(c,0,1);
            /* d = switchBits(d, 4, 5); e = switchBits(e, 5, 6); */
            c = switchBits(c,3,4);
            c = switchBits(c,2,5);
            c = switchBits(c,6,7);
            a[b] = c;
        }
            
        return a;
    }
    ```
    底下有定義switchBits(c,p1,p2)，就是交換字元c裡第p1位和第p2位的bit，這裡不多贅述。
    所以我把轉換過程倒過來：
    ```text
    6,7
    2,5
    3,4
    0,1
    4,7
    5,6
    0,3
    1,2
    ```
    根據題目給的判斷條件回推，即可得到flag。
    ```text
    expected = {0xF4, 0xC0, 0x97, 0xF0, 0x77, 0x97, 0xC0, 0xE4, 0xF0, 0x77, 0xA4, 0xD0, 0xC5, 0x77, 0xF4, 0x86, 0xD0, 0xA5, 0x45, 0x96, 0x27, 0xB5, 0x77, 0xF1, 0xC2, 0xD1, 0xB4, 0xD1, 0xB4, 0xF1, 0xF1, 0x85}
    ```

## Flag

```text
picoCTF{s0m3_m0r3_b1t_sh1fTiNg_785c5c77d}
```