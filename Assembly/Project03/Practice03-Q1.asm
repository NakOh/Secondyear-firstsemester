TITLE Practice 03-Q1 (student id.asm)
;���� ����ȫ ������ ���Ѽ�

INCLUDE Irvine32.inc


.data

   bVal BYTE 100
   bVal2 BYTE 50
   wVal WORD 2
   dVal DWORD 5

.code
main PROC
	;mov ds,45  ;��ð��� ���׸�Ʈ �������Ϳ� �̵� �� �� ����.
     mov bl,bVal ; ���Ŀ� �´�.
	;mov esi,wVal;�ǿ����ڴ� ���� ũ�⿩�� �Ѵ�.
	;mov eip,dVal;eip�� ������ �ǿ������� �� ����.
	;mov 25,bVal; ��ð��� ������ �ǿ������� �� ����.
	;mov bVal2,bVal;�� �ǿ����ڰ� ��� �޸� �ǿ������� ���� ����.

	call DumpRegs

exit
main ENDP
END main