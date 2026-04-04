# SUDO MAKE ME A SANDWICH

## 題目描述 (Description)

Can you read the flag? I think you can!

### 提示 (Hints)

1. Hint 1  
    What is sudo?
2. Hint 2  
    How do you know what permission you have?

## 解題思路 (Solution Walkthrough)

1. **第一步**：先用 `sudo -l` 查看可用的指令，發現 `(ALL) NOPASSWD: /bin/emacs`

2. **第二步**：接著使用 `sudo /bin/emacs`，然後按 `alt+x` 輸入 shell，接著使用 `cat flag.txt` 即可取得 flag

## Flag

```text
picoCTF{ju57_5ud0_17_9a782247}
```

## 參考資料

1. https://medium.com/@cyberawareness/sudo-make-me-a-sandwich-picoctf-2026-e1bffe1d6b05