# Flag Hunters

## 題目描述 (Description)

Lyrics jump from verses to the refrain kind of like a subroutine call. There's a hidden refrain this program doesn't print by default. Can you get it to print it? There might be something in it for you.
The program's source code can be downloaded [here](https://challenge-files.picoctf.net/c_verbal_sleep/e1ff464c5a2ba5d8b318b6b906c72b1702784d5c25e8af610052b716b396dc51/lyric-reader.py).
Additional details will be available after launching your challenge instance.

### 提示 (Hints)

1. Hint 1
   This program can easily get into undefined states. Don't be shy about Ctrl-C.
2. Hint 2
   Unsanitized user input is always good, right?
3. Hint 3
   Is there any syntax that is ripe for subversion?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：查看 lyric-reader.py 可以發現他把 flag 藏在最前面，且中間可以給使用者輸入歌詞

2.  **第二步**：之後可以發現歌詞中程式是以分號來判斷指令的，且可以透過 RETURN 行數來回到指定的行數
   ```python
   for line in song_lines[lip].split(';'):
   ```
   ```python
   elif re.match(r"RETURN [0-9]+", line):
        lip = int(line.split()[1])
   ```

3.  **第三步**：於是在前面隨便輸入一個字串，後面加上 `RETURN 0`例如 `abc;RETURN 0` 即可成功取得 flag

## Flag

```text
picoCTF{70637h3r_f0r3v3r_b248b032}
```