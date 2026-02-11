# Disk, disk, sleuth!

## 題目描述 (Description)

Use `srch_strings` from the sleuthkit and some terminal-fu to find a flag in this disk image.
[dds1-alpine.flag.img.gz](https://challenge-files.picoctf.net/c_wily_courier/89797cb52348a4096884e4f58164b42a892f8cac34b91d887491f44a5f144718/dds1-alpine.flag.img.gz)

### 提示 (Hints)

1. Hint 1
   Have you ever used `file` to determine what a file was?
2. Hint 2
   Relevant terminal-fu in picoGym: https://play.picoctf.org/practice/challenge/85
3. Hint 3
   Mastering this terminal-fu would enable you to find the flag in a single command: https://play.picoctf.org/practice/challenge/48
4. Hint 4
   Using your own computer, you could use qemu to boot from this disk!

## 解題思路 (Solution Walkthrough)

1.  **第一步**：先解壓縮，發現裡面是一個光碟映像檔

2.  **第二步**：使用 strings 成功找出 flag
   ```
   ┌──(kali㉿kali)-[~/Desktop/dds1-alpine.flag.img]
   └─$ strings dds1-alpine.flag.img| grep "pico"
   ffffffff81399ccf t pirq_pico_get
   ffffffff81399cee t pirq_pico_set
   ffffffff820adb46 t pico_router_probe
   SAY picoCTF{f0r3ns1c4t0r_n30phyt3_5e56e786}
   ```

## Flag

```text
picoCTF{f0r3ns1c4t0r_n30phyt3_5e56e786}
```