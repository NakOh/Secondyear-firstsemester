TITLE Practice Q05 (20110050.asm)
	INCLUDE Irvine32.inc

	.data
	.code
	main PROC
	;Shift left
	mov al, 8Fh			; AL = 10001111b
	call DumpRegs		
	shl al, 1			; CF = 1, AL = 11110b
	call DumpRegs
	mov bl, 10000000b   
	shl bl, 2           ; CF = 0, AL = 11110b
	call DumpRegs
	mov cx, 10h			
	shl cx, 4			; CX = 100h, multiple by 16
	call DumpRegs

	;Shift Right
	mov al, 00000010b
	shr al, 2			; CF= 1, AL= 0b
	call DumpRegs
	mov bx, 400h
	shr bx, 4			; BX = 40h , divide by 8           
	call DumpRegs

	; Shift Arithmetic Left, Right
	mov eax, 0FF80h			;EAX = 0000FF80h
	call DumpRegs			 
	sal eax, 16				;EAX = FF800000h
	call DumpRegs
	sar eax, 16				;EAX = FFFFFF80h
	call DumpRegs

	; Rotate Left, Right

	mov ax, 6A4Bh
	rol ax, 4			;AX = A4B6h
	call DumpRegs		
	ror ax, 4			;AX = 6A4Bh
	call DumpRegs


	;Rotate Carry Left, Right

	clc
	mov bl, 88h			; CF = 1, BL = 10000b
	call DumpRegs
	rcl bl, 1			; CF = 0, BL = 100001b
	call DumpRegs
	rcl bl, 1			; CF = 1, BL = 100001b
	call DumpRegs		
	stc
	mov cl, 10h			; CL = 10000b , CF = 1
	call DumpRegs
	rcr cl, 1			; CL = 10001000b, CF = 0
	call DumpRegs
	exit
	main ENDP
	END main