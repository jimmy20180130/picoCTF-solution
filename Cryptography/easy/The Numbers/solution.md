# The Numbers

## 題目描述 (Description)

The numbers... what do they mean?
[numbers.png](https://challenge-files.picoctf.net/c_fickle_tempest/7b39deba4212c233b1628c93f16639ed02ad90f51436d2a8914bb11f74a982d3/the_numbers.png)

### 提示 (Hints)

1. Hint 1
   The flag is in the format PICOCTF{}

## 解題思路 (Solution Walkthrough)

1.  **第一步**：圖片中有以下字串 `16 9 3 15 3 20 6 { 20 8 5 14 21 13 2 5 18 19 13 1 19 15 14 }`
   可以得知
   
   | 字母 | 數字 |
   |------|------|
   | p    | 16   |
   | i    | 9    |
   | c    | 3    |
   | o    | 15   |
   | t    | 20   |
   | f    | 6    |

2.  **第二步**：照著上面的推理，可以看出 c 因為是英文 a-z 中的第三個，所以數字為 3，並且其他的字母所對應的數字也有照這個規定，故可藉此規則推論出完整的 flag

## Flag

```text
picoctf{thenumbersmason}
```