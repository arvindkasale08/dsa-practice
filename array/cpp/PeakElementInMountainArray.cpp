#include <bits/stdc++.h>
using namespace std;

int findPeakUtil(int arr[], int start, int end, int size){
    int mid = start + (end - start) / 2;

    if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == size - 1 || arr[mid + 1] <= arr[mid]))
        return mid;
 
    else if (mid > 0 && arr[mid - 1] > arr[mid])
        return findPeakUtil(arr, start, (mid - 1), size);
 
    return findPeakUtil(arr, (mid + 1), end, size);
}

int main(){
    int arr[] = { 1, 2, 3, 4, 3, 2, 1 };
    int size = sizeof(arr) / sizeof(arr[0]);
    cout << "Peak: " << findPeakUtil(arr, 0, size - 1, size);
    return 0;
}