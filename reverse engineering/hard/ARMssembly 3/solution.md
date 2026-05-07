# ARMssembly 3

## 題目描述 (Description)

What integer does this program print?
Flag format: picoCTF{XXXXXXXX} -> (hex, lowercase, no 0x, and 32 bits. ex. 5614267 would be picoCTF{0055aabb})
Use argument a: 4101707659
File: [chall_2.S](https://challenge-files.picoctf.net/c_wily_courier/b331fbacb5f1bef5d88fb5a1ffead53e3183dfe5f72d3ce945ca843e6ae21750/chall_3.S)

### 提示 (Hints)

1. Hint 1
   beep boop beep boop...

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```text
    main:
		stp	x29, x30, [sp, -48]!
		add	x29, sp, 0
		str	w0, [x29, 28]
		str	x1, [x29, 16]
		ldr	x0, [x29, 16]
		add	x0, x0, 8
		ldr	x0, [x0]
		bl	atoi
		bl	func1
		str	w0, [x29, 44]
		adrp	x0, .LC0
		add	x0, x0, :lo12:.LC0
		ldr	w1, [x29, 44]
		bl	printf
		nop
		ldp	x29, x30, [sp], 48
		ret
		.size	main, .-main
		.ident	"GCC: (Ubuntu/Linaro 7.5.0-3ubuntu1~18.04) 7.5.0"
		.section	.note.GNU-stack,"",@progbits
    ```
    main只有呼叫func1跟輸出結果。

    ```text
    func1:
		stp	x29, x30, [sp, -48]!
		add	x29, sp, 0
		str	w0, [x29, 28]
		str	wzr, [x29, 44]
		b	.L2
	.L2:
		ldr	w0, [x29, 28]
		cmp	w0, 0
		bne	.L4
		ldr	w0, [x29, 44]
		ldp	x29, x30, [sp], 48
		ret
		.size	func1, .-func1
		.align	2
		.global	func2
		.type	func2, %function
	.L4:
		ldr	w0, [x29, 28]
		and	w0, w0, 1
		cmp	w0, 0
		beq	.L3
		ldr	w0, [x29, 44]
		bl	func2
		str	w0, [x29, 44]
	.L3:
		ldr	w0, [x29, 28]
		lsr	w0, w0, 1
		str	w0, [x29, 28]
	func2:
		sub	sp, sp, #16
		str	w0, [sp, 12]
		ldr	w0, [sp, 12]
		add	w0, w0, 3
		add	sp, sp, 16
		ret
		.size	func2, .-func2
		.section	.rodata
		.align	3
    ```
    func1讀了input跟創了一個初始值為0的計數器，接著跳到.L2。
	.L2就是如果input不為0，就跳到.L4，接著.L4會檢查input的最後一位是否為0，如果為0就略過，若為1則跳到.L3，把最後一位往右移，並執行func2，將計數器加三，直到input為0，最後回到main輸出結果。
	總而言之，這是一個檢查輸入轉成二進位後有幾個1的程式，所以4101707659轉成二進位後是11110100011110110010101110001011，有19個1。
	19*3=57，flag格式為00000039。

## Flag

```text
picoCTF{00000039}
```