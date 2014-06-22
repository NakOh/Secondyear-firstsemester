;20110050 ±è¹Î¼ö
;¿·ÀÚ¸® ¾ÉÀº »ç¶÷ 
 ÀÌÁ¦È«
INCLUDE Irvine32.inc
	.data
	arrayB BYTE 10h,20h,30h,40h
	arrayW WORD 1000h,2000h,3000h,4000h
	arrayD DWORD 10000000h,20000000h,30000000h,40000000h
	; º¯¼ö ¼±¾ð
	.code
	
	main PROC
	mov eax,00000000h
	mov ebx,00000000h
	mov ecx,00000000h
	mov edx,00000000h

; Direct-Offset Addressing (byte array);
      mov al,arrayB    ; AL = ??h
	  mov bl,[arrayB+1]; BL = ??h
	  mov cl,[arrayB+2]; CL = ??h
	  mov dl,[arrayB+3]; DL = ??h

; Direct-Offset Addressing (word array);
	  mov ax, arrayW     ; AX = ????h
	  mov bx, [arrayW+2] ; BX = ????h
	  mov cx, [arrayW+4] ; CX = ????h
	  mov dx, [arrayW+6] ; DX = ????h

; Direct-Offset Addressing(dword array);	
	  mov eax, arrayD  ; EAX = ????????h
      mov ebx, [arrayD+4] ; EBX = ????????h
	  mov ecx, [arrayD+8] ; ECX = ????????h
	  mov edx, [arrayD+12] ; EDX = ????????h


	  call DumpRegs
	  exit
main endp
end main