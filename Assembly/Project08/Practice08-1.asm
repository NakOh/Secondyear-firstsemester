TITLE practice 08-1

Include Irvine16.inc

.code
main PROC
	mov ax,@data
	mov ds,ax
	call ClrScr

L1:	mov ah,10h
	int 16h
	call DumpRegs
	cmp al,1Bh
	jne L1

	call ClrScr

	exit

main ENDP
END main

;Á¤´ä. 1.Alt+F9 2.Shift + F1 3.F9 4.s 5.Crtl+P