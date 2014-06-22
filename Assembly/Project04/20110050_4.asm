TITLE Practice Q04 

	

INCLUDE Irvine32.inc

	.data
	val1 BYTE 10
	val2 BYTE 10
	tempX BYTE ?
	tempY BYTE ?
	.code
	main PROC
	mov al, val1
	cmp al, val2
	je L1
	jne L2

L1 : mov tempX, 1
	 mov tempY, 2
	 jmp L3

L2 : mov tempX,2
	 mov tempY,1

L3 : movzx eax, tempX
	 movzx ebx, tempY
	 call DumpRegs

	 exit
	 main ENDP
	 END main
