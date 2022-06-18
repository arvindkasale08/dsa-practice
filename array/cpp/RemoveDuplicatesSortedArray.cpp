#include<iostream>
using namespace std;

int removeDuplicatesSortedArray(int arr[], int size){
    if (size == 0 || size == 1){
        return size;
    }

    int j = 0;
    for (int i = 0; i<size-1; i++){
        if (arr[i] != arr[i+1]){
            arr[j] = arr[i];
            j++;
        }
    }

    arr[j] = arr[size-1];
    j++;

    return j; 
}

int main(){
    int arr[] = {1,2,3,4,5,5,6};
    int size = sizeof(arr)/sizeof(arr[0]);
    int n = removeDuplicatesSortedArray(arr,size);
    for (int i = 0; i<n; i++){
        cout<< arr[i]<< "\n";
    }
    return 0;
}