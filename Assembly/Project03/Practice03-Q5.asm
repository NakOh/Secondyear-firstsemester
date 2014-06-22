TITLE Practice 03-Q5 (student id.asm)
;哭率 捞力全 坷弗率 辫茄己

INCLUDE Irvine32.inc
.data
	arrayB BYTE 10h,20h,30h,40h
	arrayW WORD 30 DUP(1),0,0
	arrayD DWORD 12345678h

.code
main PROC
;PTR Operator
	mov ax, WORD PTR [arrayB+2]	; AX=4030
	mov bl, BYTE PTR arrayD		; BL=78
	mov bl, BYTE PTR [arrayW+2]	; BL=01
	mov ax,	WORD PTR [arrayD+2] ; AX=1234
	mov eax, DWORD PTR arrayW	; EAX=00010001

;TYPE Operator
	mov eax, TYPE arrayB	; EAX=00000001
	mov eax, TYPE arrayW	; EAX=00000002
	mov eax, TYPE arrayD	; EAX=00000004

;LENGTHOF Operator
	mov ebx, LENGTHOF arrayB	; EBX=00000004
	mov ebx, LENGTHOF arrayW	; EBX=00000020
	mov ebx, LENGTHOF arrayD	; EBX=00000001

;SIZEOF Operator
	mov ecx,SIZEOF arrayB	; ECX=00000004
	mov ecx,SIZEOF arrayW	; ECX=00000040
	mov ecx,SIZEOF arrayD	; ECX=00000004


exit
main ENDP
END main