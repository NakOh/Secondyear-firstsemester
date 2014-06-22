TITLE Practice 03-Q6 (student id.asm)
;哭率 捞力全 坷弗率 辫茄己

INCLUDE Irvine32.inc

.data
aName BYTE "ASSEMBLY LANGUAGE",0
nameSize = ($ - aName) -1
nameStack BYTE "Stack : ",0
nameESP BYTE "ESP : ",0

.code
main PROC

;push the name on the stack
	mov ecx, nameSize
	mov esi, 0

L1 : movzx eax, aName[esi]
	push eax
	;mov edx,OFFSET nameStack
	;call WriteString
	;mov al,[esp]
	;call WriteChar
	;mov Edx, OFFSET nameESP
	;call WriteString
	;mov eax,esp
	;call WriteHex
	;call Crlf
	inc esi
	loop L1

	;call Crlf

;POP the name from the stack, in reverse
;and store in the aName array
	mov ecx, nameSize
	mov esi, 0

L2: 
	;mov edx,OFFSET nameStack
	;call WriteString
	;mov al,[esp]
	;call WriteChar
	;mov edx, OFFSET nameESP
	;call WriteString
	;mov eax, esp
	;call WriteHex
	;call crlf
	pop eax
	mov aName[esi],al
	inc esi
	loop L2

	;call crlf

;print the Reverse String
	mov edx, OFFSET aName
	call WriteString
	call Crlf

exit
main ENDP
END main