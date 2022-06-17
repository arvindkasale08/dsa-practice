// Online C++ compiler to run C++ program online
#include <iostream>
using namespace std;

int singleNonDuplicate(int arr[], int size){
    int first = 0, last = size-1;
    if (last == 0){
        return arr[0];
    }
    while(first<=last){
        if(arr[first] != arr[first+1]){
        return arr[first];
        }else{
            first = first + 2;
        }
        if(arr[last] != arr[last-1]){
            return arr[last];
        }else{
            last = last - 2;
        }
    }
    return 0;
}

int main(){
    int arr[] = {1,1,2,3,3};
    int size = sizeof(arr)/sizeof(arr[0]);
    int ele = singleNonDuplicate(arr,size);
    cout << "ele: " << ele <<"\n";
    return 0;
}