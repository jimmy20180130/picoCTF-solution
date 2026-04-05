# Invisible WORDs

## 題目描述 (Description)

Do you recognize this cyberpunk baddie? We don't either. AI art generators are all the rage nowadays, which makes it hard to get a reliable known cover image. But we know you'll figure it out. The suspect is believed to be trafficking in classics. That probably won't help crack the stego, but we hope it will give motivation to bring this criminal to justice!
Download the image [here](https://artifacts.picoctf.net/c/401/output.bmp)

### 提示 (Hints)

1. Hint 1  
    Something doesn't quite add up with this image...
2. Hint 2  
    How's the image quality?

## 解題思路 (Solution Walkthrough)

1. **第一步**：用 exiftool 沒看到什麼有意義的資訊

2. **第二步**：用 hxd editor 可以發現疑似 zip magic bytes 的東西

    ```text
    zip 的 Local file header 一定要是 50 4B 03 04
    Central directory file header (CDFH) 一定要是 50 4B 01 02
    End of central directory record (EOCD) 一定要是 50 4B 05 06
    ```

3. **第三步**：但是這個 zip 檔案它的 magic bytes 長這樣

    ```text
    Local file header: 50 4B 95 52 03 04
    Central directory file header (CDFH): 50 4B C8 10 01 02
    End of central directory record (EOCD): 50 4B 66 14 05 06
    ```

4. **第四步**：於是寫了一個 python 腳本移除中間的 bytes，接著移除不需要的 byte，發現壓縮檔可以解壓縮了

5. **第五步**：解壓縮以後 grep 裡面那個檔案就可以看到 flag 了

## Flag

```text
picoCTF{w0rd_d4wg_y0u_f0und_5h3113ys_m4573rp13c3_a11dd85d}
```

## 參考資料

1. https://en.wikipedia.org/wiki/ZIP_(file_format)
