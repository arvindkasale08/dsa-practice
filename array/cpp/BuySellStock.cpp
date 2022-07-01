#include <bits/stdc++.h>
using namespace std;

int maxProfit(int nums[], int n){
    int buy = nums[0];
    int profit = 0;
    for (int i = 1; i<n; i++){
        if (nums[i] < nums[i-1]){
            profit += nums[i-1] - buy;
            buy = nums[i];
        }
    }
    return profit+nums[n-1]-buy;
}

int main(){
    int nums[] = {7,1,5,3,6,4};
    int n = sizeof(nums)/sizeof(nums[0]);
    cout << maxProfit(nums,n) << endl;
    return 0;
}