TITLE Practice5-Q1

INCLUDE Irvine32.inc

.data
	stringEBP BYTE "EBP : ", 0
	stringN   BYTE ",  n : ", 0
	stringEAX BYTE ",  EAX : ", 0

.code
main PROC
	push 7
	call Factorial		;	Calculate factorial(EAX)
ReturnMain:
	call WriteDec
	call Crlf
	exit
main ENDP

PrintEBP PROC
	push edx
	push eax
	mov edx, OFFSET stringEBP
	call WriteHex
	mov edx, OFFSET stringN
	call WriteString
	mov eax, [ebp+8]
	call WriteDec
	mov edx, OFFSET stringEAX
	call WriteString
	pop eax
	call WriteDec
	call Crlf
	pop edx
	ret
PrintEBP ENDP

Factorial PROC
	push ebp
	mov ebp, esp
	mov eax, [ebp+8]
	call PrintEBP
	cmp eax, 0
	ja	L1		; input the label
	mov eax, 1  
	jmp	L2		; input the label

L1: dec eax
	push eax
	call Factorial

ReturnFact:
	mov ebx, [ebp+8]
	mul ebx
	call PrintEBP

L2: pop ebp
	ret 4
Factorial ENDP

END main

; EBP :00000005 , n :5 , eax :5
; EBP :00000004 , n :4 , eax :4
; EBP :00000003 , n :3 , eax :3
; EBP :00000002 , n :2 , eax :2
; EBP :00000001 , n :1 , eax :1
; EBP :00000000 , n :0 , eax :0
; EBP :00000001 , n :1 , eax :1
; EBP :00000002 , n :2 , eax :2
; EBP :00000006 , n :3 , eax :6
; EBP :00000018 , n :4 , eax :24
; EBP :00000078 , n :5 , eax :120


