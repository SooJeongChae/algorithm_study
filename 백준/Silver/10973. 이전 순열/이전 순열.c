#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
void next_permutation(int n, int a[])
{
	int i, j;
	int start, tmp, swap_num, swap_index;

	for (i = 0; i < n - 1; i++)
		if (a[n - 2 - i] > a[n - 1 - i])		//앞에 숫자가 앞에꺼보다 크면
			break;
	start = n - 2 - i;

	swap_num = 0;
	swap_index = start;
	for (i = start + 1; i < n; i++)
		if (a[start] > a[i] && a[i] > swap_num)
		{
			swap_num = a[i];
			swap_index = i;
		}
	a[swap_index] = a[start];
	a[start] = swap_num;

	for (i = start + 1; i < n; i++)
		for (j = start + 1; j < n - 1; j++)
			if (a[j] < a[j + 1])
			{
				tmp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = tmp;
			}
}
int main(void)
{
	int n, i;
	int* arr;
	int isminArray = 1;

	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int) * n);

	for (i = 0; i < n; i++)
		scanf("%d", &arr[i]);

	for (i = 0; i < n; i++)
		if (arr[i] != i + 1)
		{
			isminArray = 0;
			break;
		}
	if (isminArray == 1)
	{
		printf("-1\n");
		return 0;
	}

	next_permutation(n, arr);
	for (i = 0; i < n; i++)
		printf("%d ", arr[i]);
	printf("\n");

	free(arr);

	return 0;
}