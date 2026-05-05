# ARMssembly 1

## 題目描述 (Description)

For what argument does this program print "win"?
Flag format: picoCTF{XXXXXXXX} -> (hex, lowercase, no 0x, and 32 bits. ex. 5614267 would be picoCTF{0055aabb})
Variables: a = 86, b = 3, c = 3
File: [chall_1.S](https://challenge-files.picoctf.net/c_wily_courier/6c4d2297c82a12d38efa4496af195b35a73a3a8515f50c8f547cd04c4b4ba748/chall_1.S)

### 提示 (Hints)

1. Hint 1
   Shifts

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    ```text
    func:
		sub	sp, sp, #32
		str	w0, [sp, 12]
		mov	w0, 88
		str	w0, [sp, 16]
		mov	w0, 4
		str	w0, [sp, 20]
		mov	w0, 3
		str	w0, [sp, 24]
		ldr	w0, [sp, 20]
		ldr	w1, [sp, 16]
		lsl	w0, w1, w0
		str	w0, [sp, 28]
		ldr	w1, [sp, 28]
		ldr	w0, [sp, 24]
		sdiv	w0, w1, w0
		str	w0, [sp, 28]
		ldr	w1, [sp, 28]
		ldr	w0, [sp, 12]
		sub	w0, w1, w0
		str	w0, [sp, 28]
		ldr	w0, [sp, 28]
		add	sp, sp, 32
		ret
    ```
    func會將input存到[sp, 12]裡面，並賦值[sp, 16] = 88，[sp, 20] = 4，[sp, 24] = 3。
	然後經過lsl，w0 = (w1在右邊加4個0)，等價於 w0 * (2^w1)，所以現在的 w0 = 88 * 2^4 = 88 * 16 = 1408。
	再經過sdiv，w0 = w1 / w0，得 w0 = 1408 / 3 = 469。
	最後經過sub，w0 = w1 - w0，為w0 = 469 - input，並將w0回傳至main。

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
		str	w0, [x29, 44]
		ldr	w0, [x29, 44]
		bl	func
		cmp	w0, 0
		bne	.L4
		adrp	x0, .LC0
		add	x0, x0, :lo12:.LC0
		bl	puts
		b	.L6
	.L4:
		adrp	x0, .LC1
		add	x0, x0, :lo12:.LC1
		bl	puts
	.LC0:
		.string	"You win!"
		.align	3
	.LC1:
		.string	"You Lose :("
		.text
		.align	2
		.global	main
		.type	main, %function
    ```
    在main的尾段會比較w0是否為0，若不等於會跳到L4，但都會跳到LC1，就輸了。
	所以應該要讓w0 = 0，這樣才能進入LC0，得到結果。
	所以贏的條件是輸入為469，轉成hex就是1d5。


## Flag

```text
picoCTF{000001d5}
```