# asm2

## 題目描述 (Description)

What does asm2(0xa,0x15) return? Submit the flag as a hexadecimal value (starting with '0x'). NOTE: Your submission for this question will NOT be in the normal flag format. [Source](https://challenge-files.picoctf.net/c_fickle_tempest/1b461fce4f77f2756ffeade3af119ec77d49db6fd9831387af61f9e3dec7a839/test.S)

### 提示 (Hints)

1. Hint 1
   assembly conditions

## 解題思路 (Solution Walkthrough)

1.  **第一步**：觀察程式給的組合語言，寫出solution.py。
    ```text
    asm2:
	<+0>:	endbr32                                      10,21
	<+4>:	push   ebp
	<+5>:	mov    ebp,esp
	<+7>:	sub    esp,0x10                     
	<+10>:	mov    eax,DWORD PTR [ebp+0xc]               讀21
	<+13>:	mov    DWORD PTR [ebp-0x4],eax               var1=21
	<+16>:	mov    eax,DWORD PTR [ebp+0x8]               讀10
	<+19>:	mov    DWORD PTR [ebp-0x8],eax               var2=10
	<+22>:	jmp    0x11cd <asm2+32>                      跳到32行
	<+24>:	add    DWORD PTR [ebp-0x4],0x1               var1 += 1
	<+28>:	add    DWORD PTR [ebp-0x8],0x37              var2 += 55
	<+32>:	cmp    DWORD PTR [ebp-0x8],0x84ab            if(var2 <= 33984):
	<+39>:	jle    0x11c5 <asm2+24>                      跳到24行
	<+41>:	mov    eax,DWORD PTR [ebp-0x4]               輸出var1
	<+44>:	leave  
	<+45>:	ret
    ```
    得到輸出為639，十六進制為0x27f。


## Flag

```text
0x27f
```