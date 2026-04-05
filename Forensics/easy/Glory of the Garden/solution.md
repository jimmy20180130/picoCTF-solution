# Glory of the Garden

## 題目描述 (Description)

This file contains more than it seems.
Get the flag from [garden.jpg](https://challenge-files.picoctf.net/c_fickle_tempest/150b6eaad43200d3dc91f98c390e4c6168620b57d0b95a7e9d04c92910bbbe16/garden.jpg).

### 提示 (Hints)

1. Hint 1  
    What is a hex editor?

## 解題思路 (Solution Walkthrough)

1. **第一步**：用 `exiftool garden.jpg` 沒看到什麼有用著資訊，於是先用 hxd editor 來看

2. **第二步**：使用 hxd editor 滑到最底下即可看到 `Here is a flag: picoCTF{more_than_m33ts_the_3y3a63b5b27}`

## Flag

```text
picoCTF{more_than_m33ts_the_3y3a63b5b27}
```
