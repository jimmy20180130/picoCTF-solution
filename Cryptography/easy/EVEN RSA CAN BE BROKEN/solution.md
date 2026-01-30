# EVEN RSA CAN BE BROKEN???

## 題目描述 (Description)

This service provides you an encrypted flag. Can you decrypt it with just N & e?
Additional details will be available after launching your challenge instance.

### 提示 (Hints)

1. Hint 1
   How much do we trust randomness?
2. Hint 2
   Notice anything interesting about N?
3. Hint 3
   Try comparing N across multiple requests

## 解題思路 (Solution Walkthrough)

1.  **第一步**：用 nc 訪問伺服器後得到
   ```
   N: 16636768217368339289891682920816090285440190983961425525967115667926643866528664250197607406204437919882794925457858827204142882676702533775506073752579414 
   e: 65537 
   cyphertext: 10467280955887798588447777982830707902225986308851750542892411129830553759927485006670721545272711204770530827784171133909888990488475059115256464139582617
   ```

2.  **第二步**：可以發現上面的 N 是偶數，很簡單就可以分解了，於是寫了一個腳本成功得到 flag

## Flag

```text
picoCTF{tw0_1$_pr!m375129bb1}
```