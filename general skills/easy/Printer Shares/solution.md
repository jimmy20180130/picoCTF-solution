# Printer Shares

## 題目描述 (Description)

Oops! Someone accidentally sent an important file to a network printer—can you retrieve it from the print server?

### 提示 (Hints)

1. Hint 1  
    knowing how SMB protocol works would be helpful!
2. Hint 2  
    smbclient and smbutil are good tools

## 解題思路 (Solution Walkthrough)

1. **第一步**：照提示用 `smbclient` 試試看

    ```text
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ smbclient -L //mysterious-sea.picoctf.net -p 58049 -N

            Sharename       Type      Comment
            ---------       ----      -------
            shares          Disk      Public Share With Guests
            IPC$            IPC       IPC Service (Samba 4.19.5-Ubuntu)
    ```

2. **第二步**：連接 shares 並取得 flag.txt 到本地後再用 cat，即可取得 flag

    ```text
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ smbclient //mysterious-sea.picoctf.net/shares -p 58049 -N
    Try "help" to get a list of possible commands.
    smb: \> get flag.txt 
    getting file \flag.txt of size 37 as flag.txt (0.0 KiloBytes/sec) (average 0.0 KiloBytes/sec)
    ```

## Flag

```text
picoCTF{5mb_pr1nter_5h4re5_7a400ec3}
```

## 參考資料

1. https://medium.com/@sudoroot523/picoctf-challenge-printer-shares-11e9e50220af
