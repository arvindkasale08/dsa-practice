#include <iostream>
#include <vector>

using namespace std;

int candy(int ratings[], int size){
    int left[size+1];
    int right[size+1];
    left[0] = 1;
    right[0] = 1;
    for (int i =1; i<size; i++){
        if (ratings[i] > ratings[i-1]){
            left[i] = left[i-1]+1;
        }else{
            left[i] = 1;
        }
        if (ratings[size-i-1] > ratings[size-i]){
            right[i] = right[i-1]+1;
        }else{
            right[i] = 1;
        }
    }
    int res = 0;
    for (int i = 0; i<size; i++){
        res+=max(left[i],right[size-i-1]);
    }
    return res;
}

int main(){
    int rating[] = {1,0,2};
    int size = sizeof(rating)/sizeof(rating[0]);
    int res = candy(rating,size);
    cout<< "Res: "<< res <<endl;
    return 0;
}