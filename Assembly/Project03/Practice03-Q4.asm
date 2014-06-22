TITLE Practice 03-Q4 (student id.asm)
;왼쪽 이제홍 오른쪽 김한성

INCLUDE Irvine32.inc

.data

.code
main PROC
;Zero flag ex
	mov ecx,1
	call Dumpregs
	sub ecx,1		;ZF=1, 0일때는 1로 1일때는 0이되는 flag
	call DumpRegs

;Sign flag example
	mov cx,0
	call DumpRegs
	sub cx,1		;SF=1, 연산결과의 MSB값을 기억
	call DumpRegs

;Carry flag example
	mov al,0FFh
	call DumpRegs
	add al,1		;CF=1,자리 올림이 발생할 때 증가함
	call DumpRegs

;Overflow flag example
	mov al,+127
	call Dumpregs
	add al,1		;OF=1
	call DumpRegs
	mov al,-128
	call DumpRegs
	neg al			;OF=1, OverFlow가 발생했을 때 증가함
	call Dumpregs


exit
main ENDP
END main