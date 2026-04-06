# So Meta

## 題目描述 (Description)

Find the flag in this [picture](https://challenge-files.picoctf.net/c_fickle_tempest/fea53d4b5a95f9e78fc25c77dd5332d9ef4aa71d2e64ea96bbe171e0300741b2/pico_img.png).

### 提示 (Hints)

1. Hint 1  
    What does meta mean in the context of files?
2. Hint 2  
    Ever heard of metadata?

## 解題思路 (Solution Walkthrough)

1. **第一步**：這題你看他的題目名稱叫做 `So Meta`，所以跟 metadata 有關，使用 `exiftool pico_img.png` 即可得到 flag

    ```text
    ExifTool Version Number         : 13.50
    File Name                       : pico_img.png
    Directory                       : .
    File Size                       : 109 kB
    File Modification Date/Time     : 2026:04:06 04:44:27-04:00
    File Access Date/Time           : 2026:04:06 04:44:40-04:00
    File Inode Change Date/Time     : 2026:04:06 04:44:39-04:00
    File Permissions                : -rwxrw-rw-
    File Type                       : PNG
    File Type Extension             : png
    MIME Type                       : image/png
    Image Width                     : 600
    Image Height                    : 600
    Bit Depth                       : 8
    Color Type                      : RGB
    Compression                     : Deflate/Inflate
    Filter                          : Adaptive
    Interlace                       : Noninterlaced
    Software                        : Adobe ImageReady
    XMP Toolkit                     : Adobe XMP Core 5.3-c011 66.145661, 2012/02/06-14:56:27
    Creator Tool                    : Adobe Photoshop CS6 (Windows)
    Instance ID                     : xmp.iid:A5566E73B2B811E8BC7F9A4303DF1F9B
    Document ID                     : xmp.did:A5566E74B2B811E8BC7F9A4303DF1F9B
    Derived From Instance ID        : xmp.iid:A5566E71B2B811E8BC7F9A4303DF1F9B
    Derived From Document ID        : xmp.did:A5566E72B2B811E8BC7F9A4303DF1F9B
    Artist                          : picoCTF{s0_m3ta_bc056477}
    Image Size                      : 600x600
    Megapixels                      : 0.360
    ```

## Flag

```text
picoCTF{s0_m3ta_bc056477}
```
