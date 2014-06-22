TITLE Practice 03-Q4 (student id.asm)
;���� ����ȫ ������ ���Ѽ�

INCLUDE Irvine32.inc

.data

.code
main PROC
;Zero flag ex
	mov ecx,1
	call Dumpregs
	sub ecx,1		;ZF=1, 0�϶��� 1�� 1�϶��� 0�̵Ǵ� flag
	call DumpRegs

;Sign flag example
	mov cx,0
	call DumpRegs
	sub cx,1		;SF=1, �������� MSB���� ���
	call DumpRegs

;Carry flag example
	mov al,0FFh
	call DumpRegs
	add al,1		;CF=1,�ڸ� �ø��� �߻��� �� ������
	call DumpRegs

;Overflow flag example
	mov al,+127
	call Dumpregs
	add al,1		;OF=1
	call DumpRegs
	mov al,-128
	call DumpRegs
	neg al			;OF=1, OverFlow�� �߻����� �� ������
	call Dumpregs


exit
main ENDP
END main