# like1000

## 題目描述 (Description)

This [.tar file](https://challenge-files.picoctf.net/c_fickle_tempest/cd3d027215d8cfee8a81a7700f7b6d2f4bd33d5f481c4464e3766055408fc935/1000.tar) got tarred a lot.

### 提示 (Hints)

1. Hint 1
   Try and script this, it'll save you a lot of time

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載下來檔案以後，發現這個壓縮檔裡面還包著一個壓縮檔，並且還有一個意義不明的 filter.txt
   ```
   alkfdslkjf;lkjfdsa;lkjfdsa
   ```

2.  **第二步**：寫一個腳本把每個 tar 檔都解壓縮，最後在 1.tar 裡面看到一張圖片檔，上面就是 flag

## Flag

```text
picoCTF{l0t5_0f_TAR5}
```