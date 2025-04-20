#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
void all_permutation(int items[], int picked[], int n, int toPick)
{
	int i, j, lastIndex, flag;

	if (toPick == 0)
	{
		for (i = 0; i < n; i++)
			printf("%d ", items[picked[i]]);
		printf("\n");
		return;
	}

	lastIndex = n - toPick - 1;

	for (i = 0; i < n; i++)
	{
		flag = 0;
		for (j = 0; j <= lastIndex; j++)
			if (picked[j] == i)
				flag = 1;
		if (flag == 1)
			continue;

		picked[lastIndex + 1] = i;
		all_permutation(items, picked, n, toPick - 1);
	}
}
int main(void)
{
	int n, i;
	int* num;
	int* bucket;

	scanf("%d", &n);
	num = (int*)malloc(sizeof(int) * n);
	bucket = (int*)malloc(sizeof(int) * n);

	for (i = 0; i < n; i++)
		num[i] = i + 1;

	all_permutation(num, bucket, n, n);

	free(num);
	free(bucket);

	return 0;
}