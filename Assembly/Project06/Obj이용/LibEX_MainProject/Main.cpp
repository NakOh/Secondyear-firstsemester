#include <iostream>
#include "LibEX.h"

int main(int argc, char* argv[])
{
	printf("Plus:  %d + %d = %d\n", 10, 20, Plus(10,20));
	printf("Minus: %d - %d = %d\n", 20, 5, Minus(20,5));
	
	return 0;
}