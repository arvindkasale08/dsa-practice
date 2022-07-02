#include <iostream>
#include <vector>
using namespace std;

void setZero(vector<vector<int>>& matrix){
    int m = matrix.size();
    int n = matrix[0].size();
    bool col = false;
    for (int i = 0; i<m; i++){
        if (matrix[i][0] == 0)
            col = true;
        for (int j = 0; j<n; j++){
            if (matrix[i][j] == 0){
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    
    for (int i = m-1; i>-1; i--){
        for (int j = n-1; j>0; j--){
            if (matrix[i][0] != 0 || matrix[0][j] != 0){
                matrix[i][j] = 0;
            }
            if (col)
                matrix[i][0] = 0;
        }
    }
}

int main(){
    vector<vector<int>> matrix {{1},{0}};
    setZero(matrix);
    for (int i =0; i<matrix.size(); i++){
        for (int ele : matrix[i]){
            cout<< ele<<" ";
        }
        cout<<endl;
    }
    return 0;
}