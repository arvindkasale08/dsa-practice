#include <iostream>
using namespace std;

int jumpGame(int nums[], int size){
 if (size <= 1){
        return 0;
    }
    int a = nums[0];
    int b = nums[0];
    int jumps = 0;
    for (int i = 1; i<size; i++){
        a-=1;
        b-=1;
        b = max(b,nums[i]);
        if (a == 0){
            jumps+=1;
            if (b == 0){
                return -1;
            }
            a = b;
            if (i == size-1){
                return jumps;
            }
        }
    }
    return jumps + 1;
}

int main(){
    int nums[] = {2,3,0,1,4};
    int size = sizeof(nums)/sizeof(nums[0]);
    int jump = jumpGame(nums,size);
    cout<< "Jump: " << jump << endl;
    return 0;
}