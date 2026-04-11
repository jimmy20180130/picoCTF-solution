# chrono

## 題目描述 (Description)

How to automate tasks to run at intervals on linux servers?
Use ssh to connect to this server:
Server: saturn.picoctf.net
Port: 57110
Username: picoplayer 
Password: pYkku7iMsS

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1. **第一步**：用picoplayer這個帳號ssh到指定位置：
    ```text
    ssh picoplayer@saturn.picoctf.net -p 57110
    ```
    接著登入，題目說要去autmomate task的位置，所以我輸入下列指令：
    ```text
    cat /etc/crontab
    ```
    就可以得到flag了。

## Flag

```text
picoCTF{Sch3DUL7NG_T45K3_L1NUX_7754e199}
```
