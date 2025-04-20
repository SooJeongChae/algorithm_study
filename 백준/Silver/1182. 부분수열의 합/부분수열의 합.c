#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int count_sum_s(int items[], int picked[], int s, int n, int toPick)
{
	int i, smallest, lastIndex;
	int sum = 0;
	int count = 0;

	lastIndex = n - toPick - 1;

	for (i = 0; i < lastIndex + 1; i++)
		sum += items[picked[i]];

	if (lastIndex != -1 && sum == s)
		count++;

	if (toPick == 0)
		return count;

	if (n == toPick)
		smallest = 0;
	else
		smallest = picked[lastIndex] + 1;

	for (i = smallest; i < n; i++)
	{
		picked[lastIndex + 1] = i;
		count += count_sum_s(items, picked, s, n, toPick - 1);
	}

	return count;
}
int main(void)
{
	int n, s, i;
	int count;
	int* num;
	int* bucket;

	scanf("%d %d", &n, &s);
	num = (int*)malloc(sizeof(int) * n);
	bucket = (int*)malloc(sizeof(int) * n);

	for (i = 0; i < n; i++)
		scanf("%d", &num[i]);

	count = count_sum_s(num, bucket, s, n, n);
	printf("%d\n", count);

	free(num);
	free(bucket);

	return 0;
}