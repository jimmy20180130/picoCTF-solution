asm3:
	<+0>:	endbr32 
	<+4>:	push   ebp
	<+5>:	mov    ebp,esp
	<+7>:	xor    eax,eax
	<+9>:	mov    ah,BYTE PTR [ebp+0xb]
	<+12>:	shl    ax,0x10
	<+16>:	sub    al,BYTE PTR [ebp+0xd]
	<+19>:	add    ah,BYTE PTR [ebp+0xc]
	<+22>:	xor    ax,WORD PTR [ebp+0x10]
	<+26>:	nop
	<+27>:	pop    ebp
	<+28>:	ret    

