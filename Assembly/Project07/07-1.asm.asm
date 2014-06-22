TITLE Practice 07-1   (Practice07-1.asm)


	INCLUDE Irvine16.inc
	.code
	main PROC
		mov	ax, @data
		mov ds, ax

L1:
	mov ah,1
	int 21h
	cmp al, '0'
	jne L1

	exit

main ENDP
END main