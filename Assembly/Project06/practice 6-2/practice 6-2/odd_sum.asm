.386
.model flat

.data
	divisor DWORD 2

.code
    _odd_sum PROC
		
	mov ebx, 0
	mov edx, 0
	
	L1: inc ecx	
		mov eax, ecx
		div divisor		
		cmp edx, 0	
		je L1		
		jne L2		

	L2:	add ebx, ecx	
		cmp ecx, 99
		je exit	
		jb L1			

exit:		mov eax, ebx
			ret			
			_odd_sum endp
			end