TITLE practice02  (student id.asm)
INCLUDE irvine32.inc

	expr1 equ 10*10
	expr2 equ <"10*10", 0ah, 0dh>

.data
	; Question-2
	mystring byte "This is long string, containing"
			 byte "any number of characters", 0
	mystring_len = ($ - myString)

	arrayB BYTE 10h, 20h ; 원하는 만큼 배열 선언
	arraybsize = ($ - arrayB)  ;

	arrayW WORD 0030h, 0040h ; 원하는 만큼 배열 선언
	arraywsize = ($ - arrayW) / 2 ;

	arrayD DWORD 00000050h, 00000060h ; 원하는 만큼 배열 선언
	arraydsize = ($ - arrayD) / 4 ;

	; question-3
	val1   DWORD 12345678h    ;

	; question-4
	expression1 byte expr1
	expression2 byte expr2

.code
main PROC
	; question-1
	; (20h+2h)*10h-21h+1h = 200h
	mov eax, 20h	; eax에 20h 저장
	add eax, 2h		; eax에 2h를 더해줌
	mov ebx, 10h	; ebx에 10h를 저장
	mul ebx			; eax에 ebx를 곱해줌
	sub eax, 21h	; eax에 21h를 빼줌
	inc eax			; eax의 값을 1증가시킴
	call DumpRegs	;


	; question-2
	; myString_len = 38
	; arrayBSize = 2
	; arrayWSize = 2
	; arrayDSize = 2

	mov eax, myString_len
	mov ebx, arrayBSize
	mov ecx, arrayWSize
	mov edx, arrayDSize
	call DumpRegs

	; question-3
	mov eax, 00000000h ; 레지스터 초기화
	mov ebx, 00000000h ;
	mov ecx, 00000000h ;
	mov edx, 00000000h ;

	mov esi, offset val1 ;
	mov al, [esi]		 ;
	mov bl, [esi+1]		 ;
	mov cl, [esi+2]		 ;
	mov dl, [esi+3]		 ;
	call DumpRegs

	comment &
		little endian order
	 &

	; question-4
	mov al, expression1
	call WriteInt
	call Crlf
	mov edx, OFFSET expression2
	call WriteString

exit
main ENDP
END main