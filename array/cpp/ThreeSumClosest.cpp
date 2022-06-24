#include <bits/stdc++.h>
using namespace std;

int threeSumClosest(int nums[],int size, int target){
    int res = 9999;
    sort(nums,nums+size);
    for (int i = 0; i<size;i++){
        int l = i+1;
        int r  =size-1;
        
        while (l<r){
            int threeSum = nums[i]+nums[l]+nums[r];
            if (abs(target-threeSum) < abs(res)){
                res = target-threeSum;
            }
            if (threeSum<target){
                l+=1;
            }else{
                r-=1;
            }
            if (res == 0){
                break;
            }
        }
    }
    return target-res;
}

int main(){
    int nums[] = {-1,2,1,4};
    int target = 1;
    int size = sizeof(nums)/sizeof(nums[0]);

    int ans = threeSumClosest(nums,size,target);

    cout<< "Three sum closest " << ans;
    return 0;
}