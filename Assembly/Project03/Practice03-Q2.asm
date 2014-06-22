TITLE Practice 03-Q2 (student id.asm)
;왼쪽 이제홍 오른쪽 김한성

INCLUDE Irvine32.inc


.data
	val1 WORD 1000h
	val2 WORD 2000h

.code
main PROC
;MOVZX 명령어 소스 피연산자를 목적지 피연산자로 복사하고 16비트 혹은 32비트로 제로확장한다.(확장된 비트들을 0으로 채운다.)
	mov bx,0A69Bh
	movzx eax,bx  ;EAX= 0000A69Bh
	movzx edx,bl  ;EDX= 0000009Bh
	movzx cx,bl   ;CX= 009Bh
	call DumpRegs
;MOVSX 명령어 소스 피연산자의 내용을 목적지 피연산자로 복사하고 값을 16비트 또는 32비트로 부호확장한다.(확장된 비트들을 부호비트로 채운다.)
	mov bx,0A69Bh
	movsx eax,bx ;EAX=FFFFA69Bh
	movsx edx,bl ;EDX=FFFFF9Bh
	call DumpRegs
	mov edx, 7Bh
	movsx cx,bl  ;CX=FF9Bh
	call DumpRegs

exit
main ENDP
END main