.386
.model flat

.code
_Plus proc
	push ebp
	mov ebp, esp
	mov eax, [ebp+8]
	add eax, [ebp+12]
	pop ebp
		ret
_Plus endp

_Minus proc
	push ebp
	mov ebp, esp
	mov eax, [ebp+8]
	sub eax, [ebp+12]
	pop ebp
		ret
_Minus endp

end