TITLE Practice 04 - Q02  (student id_1.asm)

	INCLUDE Irvine32.inc

	.data
	stringMix BYTE "MixedCase", 0
	stringSize = ( $ - stringMix)
	stringUpper BYTE stringSize DUP(0)
	stringPrint BYTE " -> : " ,0

	.code

	main PROC

	mov esi, OFFSET stringMix
	mov ecx, LENGTHOF stringMix
	mov edx, OFFSET stringUpper
	call UpperString

	mov edx, OFFSET stringUpper
	call WriteString
	call Crlf
	exit
	main ENDP

	UpperString PROC

	mov ebx,0
L1: mov al, [esi];
    call WriteChar ; al= 69h
	and al, 11011111b ; al=49h
	call PrintChar ; al= 49h
	call Crlf
	mov [edx+ebx], al ; al= 49h
	inc ebx
	inc esi
	loop L1

	ret
	UpperString ENDP

	PrintChar PROC
	push edx
	mov edx, OFFSET stringPrint
	call WriteString
	call WriteChar
	pop edx
	ret
	PrintChar ENDP

	END main