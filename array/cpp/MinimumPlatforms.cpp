#include <bits/stdc++.h>
using namespace std;

int minimumPlatform(int arr[], int dep[], int n){
    sort(arr,arr+n);
    sort(dep,dep+n);
    int cur_plat = 1;
    int max_plat = 1;
    int i = 1;
    int j = 0;
    while(i<n){
        if (arr[i]>dep[j]){
            i++;
            j++;
        }else{
            cur_plat+=1;
            if (cur_plat>max_plat){
                max_plat = cur_plat;
            }
            i++;
        }
    }
    return max_plat;
}

int main(){
    int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

    int n = sizeof(arr)/sizeof(arr[0]);

    cout<< minimumPlatform(arr,dep,n) << endl;
}