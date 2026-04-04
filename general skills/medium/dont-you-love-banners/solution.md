# dont-you-love-banners

## 題目描述 (Description)

Can you abuse the banner?

### 提示 (Hints)

1. Hint 1  
    Do you know about symlinks?
2. Hint 2  
    Maybe some small password cracking or guessing

## 解題思路 (Solution Walkthrough)

1. **第一步**：題目有說伺服器在其中一個 port 有洩漏的資料，原來是 `SSH-2.0-OpenSSH_7.6p1 My_Passw@rd_@1234`

2. **第二步**：接著嘗試連線到主要的 port，並通靈一下，成功進入伺服器

    ```text
    *************************************
    **************WELCOME****************
    *************************************

    what is the password? 
    My_Passw@rd_@1234
    What is the top cyber security conference in the world?
    def con
    the first hacker ever was known for phreaking(making free phone calls), who was it?
    John Draper    
    player@challenge:~$
    ```

3. **第三步**：接著使用 `ls`，發現有 `banner` 以及 `text`，不過都沒有 flag，接著查看 `/root/flag.txt`，但發現沒權限

4. **第四步**：看了提示發現可以使用 `symlinks`，於是使用 `ln -s /root/flag.txt banner`，重新連線後即可取得 flag

## Flag

```text
picoCTF{b4nn3r_gr4bb1n9_su((3sfu11y_218ef5d6}
```

## 參考資料

1. https://ithelp.ithome.com.tw/articles/10347114