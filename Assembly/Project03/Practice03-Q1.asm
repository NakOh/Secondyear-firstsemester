TITLE Practice 03-Q1 (student id.asm)
;왼쪽 이제홍 오른쪽 김한성

INCLUDE Irvine32.inc


.data

   bVal BYTE 100
   bVal2 BYTE 50
   wVal WORD 2
   dVal DWORD 5

.code
main PROC
	;mov ds,45  ;즉시값이 세그먼트 레지스터에 이동 될 수 없다.
     mov bl,bVal ; 형식에 맞다.
	;mov esi,wVal;피연산자는 같은 크기여야 한다.
	;mov eip,dVal;eip는 목적지 피연산자일 수 없다.
	;mov 25,bVal; 즉시값은 목적지 피연산자일 수 없다.
	;mov bVal2,bVal;두 피연산자가 모두 메모리 피연산자일 수는 없다.

	call DumpRegs

exit
main ENDP
END main