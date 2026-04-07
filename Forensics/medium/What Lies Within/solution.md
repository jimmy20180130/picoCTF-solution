# What Lies Within

## 題目描述 (Description)

There's something in the [building](https://challenge-files.picoctf.net/c_fickle_tempest/c0eec6af0f04316e2bdc4a9f095afd0e2d0121f5e543dbc4a65bb0038d72a993/buildings.png). Can you retrieve the flag?

### 提示 (Hints)

1. Hint 1  
    There is data encoded somewhere... there might be an online decoder.

## 解題思路 (Solution Walkthrough)

1. **第一步**：這種題目就先用 `exiftool` 看 flag 有沒有在 metadata 裡面，沒有的話再用 `zsteg`，都沒有再想其他辦法

    ```text
    b1,r,lsb,xy         .. text: "^5>R5YZrG"
    b1,rgb,lsb,xy       .. text: "picoCTF{h1d1ng_1n_th3_b1t5}"
    b1,abgr,msb,xy      .. file: OpenPGP Secret Key
    b2,b,lsb,xy         .. text: "XuH}p#8Iy="
    b3,abgr,msb,xy      .. text: "t@Wp-_tH_v\r"
    b4,r,lsb,xy         .. text: "fdD\"\"\"\" "
    b4,r,msb,xy         .. text: "%Q#gpSv0c05"
    b4,g,lsb,xy         .. text: "fDfffDD\"\""
    b4,g,msb,xy         .. text: "f\"fff\"\"DD"
    b4,b,lsb,xy         .. text: "\"$BDDDDf"
    b4,b,msb,xy         .. text: "wwBDDDfUU53w"
    b4,rgb,msb,xy       .. text: "dUcv%F#A`"
    b4,bgr,msb,xy       .. text: " V\"c7Ga4"
    b4,abgr,msb,xy      .. text: "gOC_$_@o"
    ```

## Flag

```text
picoCTF{h1d1ng_1n_th3_b1t5}
```
