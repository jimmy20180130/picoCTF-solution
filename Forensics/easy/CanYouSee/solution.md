# CanYouSee

## 題目描述 (Description)

How about some hide and seek?
Download this file [here](https://artifacts.picoctf.net/c_titan/129/unknown.zip).

### 提示 (Hints)

1. Hint 1  
    How can you view the information about the picture?
2. Hint 2  
    If something isn't in the expected form, maybe it deserves attention?

## 解題思路 (Solution Walkthrough)

1. **第一步**：使用 `exiftool ukn_reality.png` 即可看到 base64 編碼的 flag

    ```text
    ExifTool Version Number         : 13.50
    File Name                       : ukn_reality.jpg
    Directory                       : .
    File Size                       : 2.3 MB
    File Modification Date/Time     : 2024:03:11 12:05:54-04:00
    File Access Date/Time           : 2026:04:04 23:11:50-04:00
    File Inode Change Date/Time     : 2026:04:04 23:11:50-04:00
    File Permissions                : -rw-------
    File Type                       : JPEG
    File Type Extension             : jpg
    MIME Type                       : image/jpeg
    JFIF Version                    : 1.01
    Resolution Unit                 : inches
    X Resolution                    : 72
    Y Resolution                    : 72
    XMP Toolkit                     : Image::ExifTool 11.88
    Attribution URL                 : cGljb0NURntNRTc0RDQ3QV9ISUREM05fYjMyMDQwYjh9Cg==
    Image Width                     : 4308
    Image Height                    : 2875
    Encoding Process                : Baseline DCT, Huffman coding
    Bits Per Sample                 : 8
    Color Components                : 3
    Y Cb Cr Sub Sampling            : YCbCr4:2:0 (2 2)
    Image Size                      : 4308x2875
    Megapixels                      : 12.4
    ```

## Flag

```text
picoCTF{ME74D47A_HIDD3N_b32040b8}
```
