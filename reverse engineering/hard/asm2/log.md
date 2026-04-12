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

