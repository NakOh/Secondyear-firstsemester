TITLE Practice 03-Q2 (student id.asm)
;���� ����ȫ ������ ���Ѽ�

INCLUDE Irvine32.inc


.data
	val1 WORD 1000h
	val2 WORD 2000h

.code
main PROC
;MOVZX ��ɾ� �ҽ� �ǿ����ڸ� ������ �ǿ����ڷ� �����ϰ� 16��Ʈ Ȥ�� 32��Ʈ�� ����Ȯ���Ѵ�.(Ȯ��� ��Ʈ���� 0���� ä���.)
	mov bx,0A69Bh
	movzx eax,bx  ;EAX= 0000A69Bh
	movzx edx,bl  ;EDX= 0000009Bh
	movzx cx,bl   ;CX= 009Bh
	call DumpRegs
;MOVSX ��ɾ� �ҽ� �ǿ������� ������ ������ �ǿ����ڷ� �����ϰ� ���� 16��Ʈ �Ǵ� 32��Ʈ�� ��ȣȮ���Ѵ�.(Ȯ��� ��Ʈ���� ��ȣ��Ʈ�� ä���.)
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