# asm3

## 題目描述 (Description)

What does asm3(0xb58568e8,0xc63ab2a1,0xf9d33ef4) return? Submit the flag as a hexadecimal value (starting with '0x'). NOTE: Your submission for this question will NOT be in the normal flag format. [Source](https://challenge-files.picoctf.net/c_fickle_tempest/b3fee52f11c2963c3f6008623c66d7c0906ab439f927132ac7fbc1d53f83c4ee/test.S)

### 提示 (Hints)

1. Hint 1
   more(?) registers

## 解題思路 (Solution Walkthrough)

1.  **第一步**：先把輸入的三個值拆成題目需要的樣子：
	```text
	[ebp+0x8]=0xb58568e8 , [ebp+0xb]=0xb5
	[ebp+0xc]=0xc63ab2a1 , [ebp+0xd]=0xb2
	[ebp+0x10]=0xf9d33ef4
	```

	```text
	<+7>:	xor    eax,eax
	```
	這行的意思是eax = 0，因為自己對自己做XOR運算會得到0。

	```text
	<+9>:	mov    ah,BYTE PTR [ebp+0xb]
	<+12>:	shl    ax,0x10
	```
	ah = 0xb5，ax = 0xb500(只修改了上半部)
	把ax左移16bytes後，ax會清空成0x0000。

2.  **第二步**：
	```text
	<+16>:	sub    al,BYTE PTR [ebp+0xd]
	<+19>:	add    ah,BYTE PTR [ebp+0xc]
	<+22>:	xor    ax,WORD PTR [ebp+0x10]
	```
	al = 0x00 - BYTE PTR \[ebp+0xd\]，al = -0xb2 = 0x4e。
	ah = 0x00 + BYTE PTR \[ebp+0xc\]，ah = 0xa1。
	WORD PTR \[ebp+0x10\] = 0x3ef4，ax = 0xa14e。
	經過XOR運算後得0x9fba。



## Flag

```text
0x9fba
```