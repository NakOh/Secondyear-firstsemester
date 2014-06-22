TITLE practice 08-3

.model small
.stack 100h
.386

bufferSize=20

.data
	buffer BYTE bufferSize+1 DUP(0);

.code

main PROC
	mov ax, @data
	mov ds, ax

	call Password
	call Crlf

	mov cx, SIZEOF buffer
	mov dx, OFFSET buffer
	call WriteString
	call Crlf
	.exit

main ENDP


Password PROC

	mov esi,0
	mov dh,0
	mov dl,0
	mov bl,1

L1:		
		mov ah, 10h
		int 16h
		cmp al,0Dh
		je L2
		mov buffer[esi],al
		
		mov ah,3
		mov bh,0
		int 10h

		mov ah,9
		mov al,'*'
		mov cx,1
		int 10h

		mov ah,2
		inc dl
		int 10h

		inc esi
		inc bl
		jmp L1



L2:
	ret
Password ENDP


crlf proc


	mov ah, 2
	mov dl, 0ah
	int 21h

	mov ah, 2
	mov dl, 0dh
	int 21h

	ret

crlf endp

writestring proc


	mov ah, 40h
	mov bx, 1
	int 21h
	ret

writestring endp
end main