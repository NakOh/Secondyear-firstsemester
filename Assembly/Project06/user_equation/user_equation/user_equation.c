#include <stdio.h>

int user_equation(int,int,int);

int main()
{
	printf("Result : %d + %d * %d = %d \n", 
											15, 10, 5, user_equation(15,10,5));

	return 0;
}

int user_equation(int a, int b,int c){
	_asm{
		mov eax, [ebp+16]
		mov ebx, [ebp+12]
		mul ebx
			add eax, [ebp+8]
}
}
