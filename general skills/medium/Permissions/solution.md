# Permissions

## 題目描述 (Description)

Can you read files in the root file?
The system admin has provisioned an account for you on the main server:
ssh -p 62205 picoplayer@saturn.picoctf.net
Password: yX-YQgX-vS
Can you login and read the root file?

### 提示 (Hints)

1. Hint 1
   What permissions do you have?

## 解題思路 (Solution Walkthrough)

1. **第一步**：依照題目指示ssh，然後cd到根目錄，發現沒有權限進root，身分為picoplayer。
    接著看看有什麼sudo指令能用，然後發現可以用vi
    所以就去[GTFOBins](https://gtfobins.org/gtfobins/vi/#shell)看看有什麼提權指令，找到了：
    ```text
    vi -c ':!/bin/sh' /dev/null
    ```
    執行上述指令後，就獲得了root權限，進去root之後，就可以得到flag了。

## Flag

```text
picoCTF{uS1ng_v1m_3dit0r_55878b51}
```
