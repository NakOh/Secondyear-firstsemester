
Include Irvine16.inc

Write PROTO char:BYTE

.data
str1 BYTE "Time: " , 0

.code

main PROC

	mov ax,@data
	mov ds,ax


	mov dx,OFFSET str1
	call WriteString
	mov ah, 2Ch
	int 21h
	movzx eax,ch
	call WritePaddedDec

	mov ah,2
	mov dl, ':'
	int 21h

	movzx eax, cl
	call WritePaddedDec

	mov ah,2
	mov dl, ':'
	int 21h
	movzx eax,dh
	call WritePaddedDec
	call Crlf

	exit

main ENDP


	WritePaddedDec PROC

		.IF eax < 10
			push eax
			push edx
			mov ah,2
			mov dl, '0'
			int 21h
			pop edx
			pop eax

			.ENDIF

			call WriteDec
			ret

			WritePaddedDec ENDP

            END main