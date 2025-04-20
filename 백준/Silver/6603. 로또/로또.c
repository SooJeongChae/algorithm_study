#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
void all_permutation(int items[], int picked[], int m, int n, int toPick)
{
	int i, smallest, lastIndex;

	if (toPick == 0)
	{
		for (i = 0; i < n; i++)
			printf("%d ", items[picked[i]]);
		printf("\n");
		return;
	}

	lastIndex = n - toPick - 1;

	if (n == toPick)
		smallest = 0;
	else
		smallest = picked[lastIndex] + 1;

	for (i = smallest; i < m; i++)
	{
		picked[lastIndex + 1] = i;
		all_permutation(items, picked, m, n, toPick - 1);
	}
}
int main(void)
{
	int n, i;
	int* num;
	int bucket[6];

	scanf("%d", &n);
	num = (int*)malloc(sizeof(int) * n);

	while (n != 0)
	{
		for (i = 0; i < n; i++)
			scanf("%d", &num[i]);

		all_permutation(num, bucket, n, 6, 6);
		printf("\n");

		scanf("%d", &n);
		num = (int*)malloc(sizeof(int) * n);
	}

	free(num);

	return 0;
}