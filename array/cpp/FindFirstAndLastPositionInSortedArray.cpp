#include <bits/stdc++.h>
using namespace std;
 
int firstPosition(int arr[], int start, int end, int target, int size){
    if (end >= start) {
        int mid = start + (end - start) / 2;
        if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target){
            return mid;
        }else if (target > arr[mid]){
            return firstPosition(arr, (mid + 1), end, target, size);
        }else{
            return firstPosition(arr, start, (mid - 1), target, size);
        }
    }
    return -1;
}

int lastPosition(int arr[], int start, int end, int target, int size){
    if (end >= start) {
        int mid = start + (end - start) / 2;
        if ((mid == size - 1 || target < arr[mid + 1]) && arr[mid] == target){
            return mid;
        }else if (target < arr[mid]){
            return lastPosition(arr, start, (mid - 1), target, size);
        }else{
            return lastPosition(arr, (mid + 1), end, target, size);
        }
    }
    return -1;
}
 
int main(){
    int arr[] = { 1, 1, 1, 2, 3, 4, 4, 5 };
    int size = sizeof(arr) / sizeof(int);
 
    int target = 4;
    cout<< "First Occurrence: " << firstPosition(arr, 0, size - 1, target, size) << "\n";
    cout << "Last Occurrence: " << lastPosition(arr, 0, size - 1, target, size) << "\n";
 
    return 0;
}