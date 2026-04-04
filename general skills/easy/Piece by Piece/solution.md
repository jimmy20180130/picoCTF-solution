# Piece by Piece

## 題目描述 (Description)

After logging in, you will find multiple file parts in your home directory. These parts need to be combined and extracted to reveal the flag.

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1. **第一步**：先使用 `ssh ctf-player@dolphin-cove.picoctf.net -p 64446`連上伺服器

2. **第二步**：發現裡面有個 `instructions.txt`

    ```text
    Hint:

   - The flag is split into multiple parts as a zipped file.
   - Use Linux commands to combine the parts into one file.
   - The zip file is password protected. Use this "supersecret" password to extract the zip file.
   - After unzipping, check the extracted text file for the flag.
    ```

3. **第三步**：於是嘗試使用 `cat part_* > flag.zip`，最後 `unzip flag.zip` 即獲得 flag

## Flag

```text
picoCTF{z1p_and_spl1t_f1l3s_4r3_fun_da494d2e}
```
