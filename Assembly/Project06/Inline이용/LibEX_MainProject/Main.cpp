#include <iostream>

int Plus(int a,int b)
{
	int retValue = 0;
	_asm
	{
		mov eax, a
		add eax, b
		mov retValue, eax
	}
	return retValue;
}

int Minus(int a, int b)
{
	_asm
	{
		mov eax, [ebp+8]
		sub eax, [ebp+12]
	}
}

int main(int argc, char* argv[])
{
	printf("Plus:  %d + %d = %d\n", 10, 20, Plus(10,20));
	printf("Minus: %d - %d = %d\n", 20, 5, Minus(20,5));
	
	return 0;
}