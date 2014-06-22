TITLE Practice Q06-2

	INCLUDE Irvine32.inc

	.data

	nameESP BYTE "ESP : ",0
	nameStack BYTE " Stack : " , 0
	nameEBP BYTE " EBP : ", 0

	.code

	main PROC

	push 6
	push 5
	call AddTwo
	exit

	main ENDP

	AddTwo PROC

	push ebp
	mov ebp,esp
	mov eax, [ebp+12]
add eax, [ebp+8]
pop ebp
	ret

	AddTwo ENDP

	PrintALL PROC

	mov edx, OFFSET  nameESP
	call WriteString
	mov eax, esp
	add eax, 4
	call WriteHex
	mov edx, OFFSET nameStack
	call WriteString
	mov eax, [esp+4]
call WriteHex
	mov edx, OFFSET nameEBP
	call WriteString
	mov eax, ebp
	call WriteHex
	call Crlf
	ret
	PrintALL ENDP
	END main

		
	;EIP = 010C1030 ESP = 002BFD40 처음 값

	;EIP = 010C1032 ESP = 002BFD3C PUSH5

	;EIP = 010C1034 ESP = 002BFD38 PUSH6 

	;EIP = 010C1040 ESP = 002BFD34 ADD 지난후

	;EIP = 010C1041 ESP = 002BFD30 PUSH ebp 지난후

	;EIP = 010C1043 ESP = 002BFD30 EBP = 002BFD30 EFL = 00000246    +12한후
	
	;EIP = 010C1046 mov 지난후

	;EIP = 010C1049 add 지난후 


	;EIP = 010C104A ESP = 002BFD34 EBP = 002BFD48 POP 지난후


	;EIP = 010C1039 ESP = 002BFD38 ret 지난후
