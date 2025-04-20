#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
void erase_not_prime(int nums[])
{
	int i, j;
	nums[1] = 1;
	for (i = 2; i < 1000000; i++)
		for (j = 2; i * j <= 1000000; j++)
			nums[i * j] = 1;
}
void sum_prime(int n, int prime[])
{
	int i;
	for (i = 2; i <= n / 2; i++) 
		if (prime[i] == 0 && prime[n - i] == 0) {
			printf("%d = %d + %d \n", n, i, n - i);
			return;
		}

	printf("Goldbach's conjecture is wrong.\n");
}
int main(void)
{
	int n;
	int is_prime[1000001] = { 0 };

	erase_not_prime(is_prime);

	scanf("%d", &n);
	while (n != 0) {
		sum_prime(n, is_prime);
		scanf("%d", &n);
	}

	return 0;
}