#include<iostream>
using namespace std;

/*
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
*/

/*
Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
*/
int maximumSumSubarrayOfSizeK(int numbers[], int k, int size) {
	int maxSum = 0;
	int currentSum = 0;
	for (int i = 0; i < k; i++)
	{
		currentSum += numbers[i];
	}
	int secondPointer = k;
	int firstPointer = 0;
	maxSum = currentSum;
	while (secondPointer < size) {
		currentSum = (currentSum + numbers[secondPointer]) - numbers[firstPointer];
		if (currentSum > maxSum)
			maxSum = currentSum;
		firstPointer++;
		secondPointer++;
	}

	return maxSum;
}

int main() {
	int arr[] = { 2, 1, 5, 1, 3, 2 };
	int k = 3;
	int size = sizeof(arr) / sizeof(arr[0]);
	cout << maximumSumSubarrayOfSizeK(arr, k, size) << endl;

	int arr2[] = { 2, 3, 4, 1, 5 };
	int k2 = 2;
	int size2 = sizeof(arr2) / sizeof(arr2[0]);
	cout << maximumSumSubarrayOfSizeK(arr2, k2, size2) << endl;
	cout << "MaximumSumSubarrayOfSizeK \n";
	return 0;
}