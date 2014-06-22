TITLE Practice 03-Q3 (student id.asm)
;哭率 捞力全 坷弗率 辫茄己

INCLUDE Irvine32.inc


.data
	val1 WORD 1000h
	val2 WORD 2000h
	arrayB BYTE 10h, 20h, 30h, 40h, 50h
	arrayW WORD 100h, 200h, 300h
	arrayD DWORD 10000h, 20000h

.code
main PROC
mov AX, val1 ;AX=1000h
xchg AX, val2 ;AX=20000h, val2=1000h
mov val1, AX  ;val1=2000h

mov bx,val1 ;BX=2000h
mov cx,val2 ;CX=1000h
call DumpRegs

;Direct-Offset Addressing (Byte array):
	mov al,arrayB ; AL=10h
	mov al,[arrayB+4];AL=50h
	mov al,[arrayB+2];Al=30h

;Direct-Offset Addressing (Word array):
	mov ax,arrayW ;AX=0100h
	mov ax,[arrayW+4];AX=0300h
	mov ax,[arrayW+2];AX=0200h

;Direct-Offset Addressing (Dword array):
	mov eax,arrayD ;EAX=00010000h
	mov eax,[arrayD+4] ;EAX=0020000h

call DumpRegs


exit
main ENDP
END main