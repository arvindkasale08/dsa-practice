// Binary Search in C++

#include <iostream>
using namespace std;

int binarySearch(int start, int end,int arr[], int target) {
    if (end<start){
        return -1;
    }

    int mid = (start+end)/2;
        
    if (arr[mid] == target){
        return mid;
    }

    if (arr[mid]<target){
        return binarySearch(mid+1, end, arr, target);
    }
        
    return binarySearch(start, mid-1, arr, target);
}

int main(void) {
    int arr[] = {1,2,3,4,5,6};
    int target = 4;
    int size = sizeof(arr) / sizeof(arr[0]);
    int position = binarySearch(0, size - 1,arr, target);
    cout << "Position of " << target << " is " << position;
}