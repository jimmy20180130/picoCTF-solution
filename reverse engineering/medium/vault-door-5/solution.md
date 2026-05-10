# vault-door-5

## 題目描述 (Description)

In the last challenge, you mastered octal (base 8), decimal (base 10), and hexadecimal (base 16) numbers, but this vault door uses a different change of base as well as URL encoding!
The source code for this vault is here: [VaultDoor5.java](https://challenge-files.picoctf.net/c_fickle_tempest/676c61b70bd76ad210af911bd9cc981a14c6dd2c81ad6f8c79e7de9688b6564b/VaultDoor5.java)

### 提示 (Hints)

1. Hint 1  
    You may find an encoder/decoder tool helpful, such as https://encoding.tools/
2. Hint 2  
    Read the wikipedia articles on URL encoding and base 64 encoding to understand how they work and what the results look like.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```java
    public boolean checkPassword(String password) {
        String urlEncoded = urlEncode(password.getBytes());
        String base64Encoded = base64Encode(urlEncoded.getBytes());
        String expected = "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVm"
                        + "JTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2"
                        + "JTM0JTVmJTY0JTMxJTM5JTM0JTM4JTY0JTM0JTY1";
        return base64Encoded.equals(expected);
    }
    ```
    用base64 decode後得到：
    ```text
    %63%30%6e%76%33%72%74%31%6e%67%5f%66%72%30%6d%5f%62%61%35%65%5f%36%34%5f%64%31%39%34%38%64%34%65
    ```
    用URL decode後得到：
    ```text
    c0nv3rt1ng_fr0m_ba5e_64_d1948d4e
    ```
    即為flag。

## Flag

```text
picoCTF{c0nv3rt1ng_fr0m_ba5e_64_d1948d4e}
```