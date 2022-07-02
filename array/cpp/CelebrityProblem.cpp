#include <iostream>
#include <vector>
using namespace std;

int celebrityProblem(vector<vector<int>>& matrix){
    int n = matrix.size();
    int i = 0;
    int j = n-1;
    while(i<j){
        if (matrix[i][j] != 0){
            i++;
        }else{
            j--;
        }
    }
    for (int k = 0; k<n;k++){
        if (i != k && ((matrix[i][k] != 0) || matrix[k][i] == 0 ))
            return -1;
    }
    return i;
}

int main(){
    vector<vector<int>> matrix {{ 0, 0, 1, 0 },{ 0, 0, 1, 0 },{ 0, 0, 0, 0 },{ 0, 0, 1, 0 }};
    cout << celebrityProblem(matrix) << endl;
    return 0;
}