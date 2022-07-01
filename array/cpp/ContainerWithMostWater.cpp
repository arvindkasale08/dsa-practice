#include <bits/stdc++.h>
using namespace std;

int maxArea(int height[], int n){
    int  maxArea = 0;
    int i = 0;
    int j = n-1;
    while (i != j){
        maxArea = max(maxArea,(j-i)*min(height[i],height[j]));
        if (height[i]>height[j]){
            j-=1;
        }else{
            i+=1;
        }
    }
    return maxArea;
}

int main(){
    int height[] = {1,8,6,2,5,4,8,3,7};
    int n = sizeof(height)/sizeof(height[0]);
    cout << maxArea(height,n)<<endl;
}