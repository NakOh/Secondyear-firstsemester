TITLE Practice5-Q3
INCLUDE Irvine32.inc

ENTER_KEY = 13
.data
InvalidInputMsg BYTE " : Invalid input", 13, 10, 0

.code
main PROC
	call Clrscr

StateA:
	call GetNext
	cmp al, '+'
	je StateB
	cmp al, '-'
	je StateB
	call IsDecimal
	jz StateC
	call DisplayErrorMsg
	jmp Quit

StateB:
	call GetNext
	call IsDecimal
	jz StateC
	call DisplayErrorMsg
	jmp Quit

StateC:
	call GetNext
	call IsDecimal
	jz StateC
	cmp al, ENTER_KEY
	je Quit
	call DisplayErrorMsg
	jmp Quit

Quit:
	call Crlf
	exit
main ENDP


GetNext PROC
	call ReadChar
	call WriteChar
	ret
GetNext ENDP


DisplayErrorMsg PROC
	push edx
	mov edx, OFFSET InvalidInputMsg
	call WriteString
	pop edx
	ret
DisplayErrorMsg ENDP


IsDecimal PROC
	cmp al, '0'
	jb ID1
	cmp al, '9'
	ja ID1
	test ax, 0
ID1: ret
IsDecimal ENDP
END main