# ABSOLUTE NANO

## 題目描述 (Description)

You have complete power with nano.
Think you can get the flag?

### 提示 (Hints)

1. Hint 1
   What can you do with nano?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：一開始嘗試使用 cat，不出意外的失敗了
   ```
   ctf-player@challenge:~$ cat flag.txt 
   cat: flag.txt: Permission denied
   ```

2.  **第二步**：上網查了很久發現可以看看 /etc/sudoers 這個檔案，他是 Linux 中的權限清單
   ```
   sudo nano /etc/sudoers

   #includedir /etc/sudoers.d
   ctf-player ALL=(ALL) NOPASSWD: /bin/nano /etc/sudoers

3.  **第三步**：於是加入這行 `ctf-player ALL=(ALL) NOPASSWD: /bin/nano flag.txt`，之後使用 `sudo /bin/nano flag.txt` 即可得到 flag

## Flag

```text
picoCTF{n4n0_411_7h3_w4y_7fcf8f8d}
```