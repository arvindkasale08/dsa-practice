#include <bits/stdc++.h>
using namespace std;

void reverse(int arr[], int size){
    int start = 0;
    int end = size-1;
    while (start < end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

int findElement(int nums[],int size, int n){
	int left[size];
    int right[size];

    left[0] = nums[0];
    right[0] = nums[size-1];

    for (int i = 1; i<n; i++){
        if (nums[i]>left[i-1]){
            left[i] = nums[i];
        }else{
            left[i] = left[i-1];
        }
        if (nums[n-i-1]<right[i-1]){
            right[i] = nums[n-i-1];
        }else{
            right[i] = right[i-1];
        }
    }

    reverse(right,size);
    for (int i = 1; i<n-1; i++){
        if (nums[i] >= left[i] && nums[i] <= right[i]){
            return nums[i];
        }
    }

    return -1;
}

int main(){
	int nums[] = {4,2,5,7};
	int size = sizeof(nums) / sizeof(nums[0]);
	int target = 4;
	int num = findElement(nums, size, target);

	cout << "num: " << num << "\n";
}
