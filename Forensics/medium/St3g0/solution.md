# St3g0

## 題目描述 (Description)

Download this image and find the flag.
- [Download image](https://artifacts.picoctf.net/c/217/pico.flag.png)

### 提示 (Hints)

1. Hint 1  
    We know the end sequence of the message will be `$t3g0`.

## 解題思路 (Solution Walkthrough)

1. **第一步**：看到題目是 steg，就知道是隱寫術了，於是使用 `zsteg -a pico.flag.png` 然後就拿到 flag 了

    ```text
    b1,r,lsb,xy         .. text: "~__B>VG?G@"
    b1,rgb,lsb,xy       .. text: "picoCTF{7h3r3_15_n0_5p00n_a9a181eb}$t3g0"
    ```

## Flag

```text
picoCTF{7h3r3_15_n0_5p00n_a9a181eb}
```
