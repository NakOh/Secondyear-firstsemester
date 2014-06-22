TITLE PassWord 
	
.model small
.stack 100h
.386

loopCount = 8

.data
 buffer BYTE loopCount+1 DUP(0);

.code

main PROC
	mov ax, @data
	mov ds, ax

	mov ecx, loopCount
	call Password
	call Crlf

	mov cx, 8
	mov dx, OFFSET buffer
	call WriteString
	call Crlf
	.exit

	main ENDP

Password PROC
	mov esi, 0

L1 :
	mov ah, 7
	int 21h
	mov buffer[esi] , al

	mov ah,2
	mov dl, '*'
	int 21h

	inc	esi
	loop L1

	ret
password ENDP


Crlf PROC
	mov ah,2
	mov dl, 0Ah
	int 21h

	mov ah,2
	mov dl, 0Dh
	int 21h



Crlf ENDP



WriteString PROC

	mov ah, 40h
	mov bx, 1
	int 21h
	ret


WriteString ENDP
END main
