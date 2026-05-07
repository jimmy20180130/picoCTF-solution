# ARMssembly 2

## 題目描述 (Description)

What integer does this program print?
Flag format: picoCTF{XXXXXXXX} -> (hex, lowercase, no 0x, and 32 bits. ex. 5614267 would be picoCTF{0055aabb})
Use argument a: 2401941830
File: [chall_2.S](https://challenge-files.picoctf.net/c_wily_courier/9cd1c10476d54d12ea8afa429f75bf5a1fd2851b2acbd2235ecb7e1f96ba97cf/chall_2.S)

### 提示 (Hints)

1. Hint 1
   Loops

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
    main看起來就只有呼叫func1跟輸出結果。

    ```text
    func1:
		sub	sp, sp, #32
		str	w0, [sp, 12]
		str	wzr, [sp, 24]
		str	wzr, [sp, 28]
		b	.L2
	.L3:
		ldr	w0, [sp, 24]
		add	w0, w0, 3
		str	w0, [sp, 24]
		ldr	w0, [sp, 28]
		add	w0, w0, 1
		str	w0, [sp, 28]
	.L2:
		ldr	w1, [sp, 28]
		ldr	w0, [sp, 12]
		cmp	w1, w0
		bcc	.L3
		ldr	w0, [sp, 24]
		add	sp, sp, 32
		ret
		.size	func1, .-func1
		.section	.rodata
		.align	3
    ```
    func1讀了input跟創了兩個初始值為0的計數器，接著跳到.L2。
	.L2簡單來說就是如果[sp, 28]比input小，就跳到.L3，接著.L3把[sp, 24]加上3，[sp, 28]加上1，直到[sp, 28]大於等於input，最後回到main輸出結果。
	總而言之，這就是一個把輸入乘三的程式，所以2401941830*3=7205825490。

2.  **第二步**：
	因為7205825490>2^32，發生溢位的狀況，所以運行的結果會是7205825490-4294967296=2910858194。
	轉成hex後變成ad802bd2。

## Flag

```text
picoCTF{ad802bd2}
```