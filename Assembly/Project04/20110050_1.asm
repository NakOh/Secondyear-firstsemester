TITLE Practice 04 - Q01 

	INCLUDE Irvine32.inc

	.data

	arrayD DWORD 10000h, 20000h, 30000h, 40000h

	sum DWORD ?

	.code

	main PROC
	mov esi, OFFSET arrayD			;2)ESP = 00257138h
	mov ecx, LENGTHOF arrayD        ;3)ECX = 00000004h
	call ArraySum                   ;1)ESP = 0025F7BCh, EIP = 002C103Bh
	mov sum, eax					;4)EAX = 000A 0000h

	exit
	main ENDP

	ArraySum PROC

	push esi						;2)ESP = 0025F7B8
	push ecx						;2)ESP = 0025F7B4

	mov eax, 0

L1: add eax,[esi]					;3) EIP = 002C1044h,002C1044h,002C1044h,002C1044h 4)EAX=00010000h,00030000h,00060000h,000A0000h
    add esi, TYPE DWORD				;3) EIP = 002C1047h,002C1047h,002C1047h,002C1047h 4)ESI=002C4004h,002C4008h,002C400Ch,002C4010h
	 loop L1						;3) EIP = 002C1042h,002C1042h,002C1042h,002C1049h 4)ECX=00000003h,00000002h,00000001h,0000000h

	pop ecx							;1) EIP=002C104B, ESP = 0025FE54h
	pop esi							;1) ESP=0025FE58h , EIP = 002C102Fh 
	ret

	ArraySum ENDP

	END main