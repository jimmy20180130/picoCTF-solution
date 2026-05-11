# ARMssembly 4

## 題目描述 (Description)

What integer does this program print?
Flag format: picoCTF{XXXXXXXX} -> (hex, lowercase, no 0x, and 32 bits. ex. 5614267 would be picoCTF{0055aabb})
Use argument a: 1854822502
File: [chall_4.S](https://challenge-files.picoctf.net/c_wily_courier/0e076eed44b47b1ce7824bb90f82d061300cf0e1125f2ce6f38a60426f4a059e/chall_4.S)

### 提示 (Hints)

1. Hint 1
   Switching things up

## 解題思路 (Solution Walkthrough)

1.  **第一步**：
    整段程式過於複雜，所以我畫了一張流程圖便於理解。
	有一個需要注意的點是func4的部分：
	```text
	func4:
	stp	x29, x30, [sp, -48]!
	add	x29, sp, 0
	str	w0, [x29, 28]
	mov	w0, 17
	str	w0, [x29, 44]
	ldr	w0, [x29, 44]
	bl	func1
	str	w0, [x29, 44]
	ldr	w0, [x29, 28]
	ldp	x29, x30, [sp], 48
	ret
	.size	func4, .-func4
	.align	2
	.global	func5
	.type	func5, %function
	```
	中間有一段func1(17)並return 7，但func4又把最一開始的input放回w0並return，所以可以直接跳過中間的func1。

2.  **第二步**：
	寫一段程式碼還原即可。

## Flag

```text
picoCTF{6e8e58d9}
```