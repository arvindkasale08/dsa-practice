#include <bits/stdc++.h>
using namespace std;
void printKMax(int arr[], int N, int K)
{
	std::deque<int> Qi(K);
	int i;
	for (i = 0; i < K; ++i) {
		while ((!Qi.empty()) && arr[i] >= arr[Qi.back()])
			Qi.pop_back();
		Qi.push_back(i);
	}
	for (; i < N; ++i) {
		cout << arr[Qi.front()] << " ";
		while ((!Qi.empty()) && Qi.front() <= i - K)
			Qi.pop_front();
		while ((!Qi.empty()) && arr[i] >= arr[Qi.back()])
			Qi.pop_back();
		Qi.push_back(i);
	}
	cout << arr[Qi.front()];
}

int main()
{
	int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
	int N = sizeof(arr) / sizeof(arr[0]);
	int K = 3;
	printKMax(arr, N, K);
	return 0;
}
