TITLE Practice 04 - Q03  

	INCLUDE Irvine32.inc

	.data
	StringL1 BYTE "L1 �Դϴ�",0
	StringL2 BYTE "L2 �Դϴ�",0
	StringL3 BYTE "L3 �Դϴ�",0
	StringL4 BYTE "L4 �Դϴ�",0
	StringL5 BYTE "L5 �Դϴ�",0
	StringL6 BYTE "L6 �Դϴ�",0

	.code
	
	main PROC

	
	mov eax, 0A523h
	cmp eax, 0A523h
	jne L1
	je L2
	; Jump L2 �Դϴ�.
	
L1: mov edx, OFFSET StringL1
	call WriteString
	call Crlf
L2 : mov edx,OFFSET StringL2
	 call WriteString
	 call Crlf
	 

	 mov cx, 0FFFFh
	 inc cx
	 jnz L3
	 jecxz L4
	 ; Jump L4�Դϴ�.

L3 : mov edx, OFFSET StringL3
	call WriteString
	call Crlf

L4 : mov edx, OFFSET StringL4
	 call WriteString
	 call Crlf

	
	 mov al, +127
	 cmp al, -128
	 ja L5
	 jg L6
	 ; Jump L6�Դϴ�.
L5 : mov edx, OFFSET StringL5
	 call WriteString
	 call Crlf

L6 : mov edx, OFFSET StringL6
	 call WriteString
	 call Crlf
	
	 exit
	 main ENDP
	 END main