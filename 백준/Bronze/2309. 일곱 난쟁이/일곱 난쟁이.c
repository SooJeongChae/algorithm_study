#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
void print_dwarf(int a, int b, int h[])
{
	int tmp;
	int i, j;

	for (i = 0; i < 9; i++)
		for (j = 0; j < 9; j++)
			if (h[i] < h[j]) {
				tmp = h[i];
				h[i] = h[j];
				h[j] = tmp;
			}

	for (i = 0; i < 9; i++) {
		if (h[i] == a || h[i] == b)
			continue;
		printf("%d\n", h[i]);
	}
}
void find_dwarf(int h[]) 
{
	int i, j;
	int sum = 0;

	for (i = 0; i < 9; i++)
		sum += h[i];

	for (i = 0; i < 9; i++)
		for (j = 1; j < 9; j++)
			if (h[i] + h[j] == sum - 100) {
				print_dwarf(h[i], h[j], h);
				return;
			}
}
int main(void)
{
	int height[9];
	int i;

	for (i = 0; i < 9; i++)
		scanf("%d", &height[i]);

	find_dwarf(height);

	return 0;
}