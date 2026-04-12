# ARMssembly 0

## 題目描述 (Description)

What integer does this program print?
Flag format: picoCTF{XXXXXXXX} -> (hex, lowercase, no 0x, and 32 bits. ex. 5614267 would be picoCTF{0055aabb})
Use arguments a and b: 2593949075 and 2233560849
File: [chall.S](https://challenge-files.picoctf.net/c_wily_courier/3d0338e688cb5d1fa1ef3d8ce28d9af059626ba91ac4cbcaf527b045680688c2/chall.S)

### 提示 (Hints)

1. Hint 1
   Simple compare

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```text
    func1:
	sub	sp, sp, #16
	str	w0, [sp, 12]
	str	w1, [sp, 8]
	ldr	w1, [sp, 12]
	ldr	w0, [sp, 8]
	cmp	w1, w0
	bls	.L2
	ldr	w0, [sp, 12]
	b	.L3
    ```
    func1為比較兩數大小的函式，會return較大的數字。

    ```text
    main:
	stp	x29, x30, [sp, -48]!
	add	x29, sp, 0
	str	x19, [sp, 16]
	str	w0, [x29, 44]
	str	x1, [x29, 32]
	ldr	x0, [x29, 32]
	add	x0, x0, 8
	ldr	x0, [x0]
	bl	atoi
	mov	w19, w0
	ldr	x0, [x29, 32]
	add	x0, x0, 16
	ldr	x0, [x0]
	bl	atoi
	mov	w1, w0
	mov	w0, w19
	bl	func1
	mov	w1, w0
	adrp	x0, .LC0
	add	x0, x0, :lo12:.LC0
	bl	printf
	mov	w0, 0
	ldr	x19, [sp, 16]
	ldp	x29, x30, [sp], 48
	ret
    ```
    輸入兩數並執行func1，最終輸出func1的結果。
    答案為2593949075，轉成hex後為0x9a9c8593，去掉前面的0x，即為flag。


## Flag

```text
picoCTF{9a9c8593}
```