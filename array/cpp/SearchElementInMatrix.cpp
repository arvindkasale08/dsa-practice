#include <iostream>
#include <vector>
using namespace std;

bool searchELement(vector<vector<int>>& matrix, int val){
    int m = matrix.size();
    int n = matrix[0].size();
    int i = 0;
    int j = n-1;
    while(i<m){
        if (matrix[i][j] == val){
            return true;
        }
        if (matrix[i][j]<val){
            i++;
        }else{
            j--;
        }
        if (i == m || j < 0){
            return false;
        }
    }
    return false;
}

int main(){
        vector<vector<int>> matrix {{10,20,30,40},{15,25,36,46},{27, 29, 37, 48},{32, 33, 39, 50}};
        int val = 32;
        cout << searchELement(matrix, val) << endl;
        return 0;
    }