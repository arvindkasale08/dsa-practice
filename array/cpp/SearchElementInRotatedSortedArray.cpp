#include <bits/stdc++.h>
using namespace std;

int searchElementInRotatedSortedArray(int arr[], int start, int end, int target){
	if (start > end){
		return -1;
    }

	int mid = (start + end) / 2;
	if (arr[mid] == target){
		return mid;
    }

	if (arr[start] <= arr[mid]) {
		if (target >= arr[start] && target <= arr[mid]){
			return searchElementInRotatedSortedArray(arr, start, mid - 1, target);
        }
		return searchElementInRotatedSortedArray(arr, mid + 1, end, target);
	}

	if (target >= arr[mid] && target <= arr[end]){
		return searchElementInRotatedSortedArray(arr, mid + 1, end, target);
    }

	return searchElementInRotatedSortedArray(arr, start, mid - 1, target);
}

int main(){
	int arr[] = { 5, 6, 7, 1, 2, 3, 4,};
	int size = sizeof(arr) / sizeof(arr[0]);
	int target = 3;
	int position = searchElementInRotatedSortedArray(arr, 0, size - 1, target);

	cout << "Position: " << position << "\n";
}
