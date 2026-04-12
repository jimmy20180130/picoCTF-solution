# asm1

## 題目描述 (Description)

What does asm1(0x3fa) return? Submit the flag as a hexadecimal value (starting with '0x'). NOTE: Your submission for this question will NOT be in the normal flag format. [Source](https://challenge-files.picoctf.net/c_fickle_tempest/6ccb8e41f43acc909f5d4ab56fb3e8f825575db4e33b94da272ce0133fefee87/test.S)

### 提示 (Hints)

1. Hint 1
   assembly conditions

## 解題思路 (Solution Walkthrough)

1.  **第一步**：觀察程式給的組合語言，輸入為0x3fa，為1018，
   ```text
   <+7>:	   cmp    DWORD PTR [ebp+0x8],0x2a7
	<+14>:	jg     0x11d3 <asm1+38>
   ```
   0x2a7為679，1018>679，所以直接跳到第38行。

   ```text
   <+38>:	cmp    DWORD PTR [ebp+0x8],0x48b
	<+45>:	jne    0x11e4 <asm1+55>
   ```
   0x48b為1163，1018!=1163，所以直接跳到55行。

   ```text
   <+58>:	add    eax,0x15
	<+61>:	pop    ebp
	<+62>:	ret    
   ```
   0x15是21，1018+21=1039，程式結束，轉換成16進制即為0x40f。


## Flag

```text
0x40f
```