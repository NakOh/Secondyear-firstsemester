TITLE practice02  (student id.asm)
INCLUDE irvine32.inc

	expr1 equ 10*10
	expr2 equ <"10*10", 0ah, 0dh>

.data
	; Question-2
	mystring byte "This is long string, containing"
			 byte "any number of characters", 0
	mystring_len = ($ - myString)

	arrayB BYTE 10h, 20h ; ���ϴ� ��ŭ �迭 ����
	arraybsize = ($ - arrayB)  ;

	arrayW WORD 0030h, 0040h ; ���ϴ� ��ŭ �迭 ����
	arraywsize = ($ - arrayW) / 2 ;

	arrayD DWORD 00000050h, 00000060h ; ���ϴ� ��ŭ �迭 ����
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
	mov eax, 20h	; eax�� 20h ����
	add eax, 2h		; eax�� 2h�� ������
	mov ebx, 10h	; ebx�� 10h�� ����
	mul ebx			; eax�� ebx�� ������
	sub eax, 21h	; eax�� 21h�� ����
	inc eax			; eax�� ���� 1������Ŵ
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
	mov eax, 00000000h ; �������� �ʱ�ȭ
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