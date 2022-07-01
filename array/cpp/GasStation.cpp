#include <bits/stdc++.h>
using namespace std;

int canCompleteCircuit(int gas[], int cost[], int n){
    int gasSum = 0;
    int totalCOst = 0;
    for(int i =0; i<n; i++){
        gasSum += gas[i];
        totalCOst += cost[i];
    }

    if (gasSum<totalCOst){
        return -1;
    }
    
    int start = 0;
    int currGas = 0;

    for (int i =0; i<n; i++){
        currGas += gas[i];
        if (currGas<cost[i]){
            start = i + 1;
            currGas = 0;
        }else{
            currGas -= cost[i];
        }
    }
    return start;
}

int main(){
    int gas[] = {1,2,3,4,5};
    int cost[] = {3,4,5,1,2};

    int n = sizeof(gas)/sizeof(gas[0]);

    cout << canCompleteCircuit(gas,cost,n) << endl;
    return 0;
}