#include <iostream>
#include <vector>
using namespace std;

void diagonalOrder(vector<vector<int>>& matrix){
    int m = matrix.size();
    int n = matrix[0].size();
    if (n == 1 && m > 1){
        for (int i = 0; i<m; i++){
            cout << matrix[i][0] << endl;
        }
        return;
    }
    
    int i = 0;
    int j = 0;
    int J = 1;
    while (i != m-1 || j != n){
        cout << matrix[i][j] << " ";
        i -= 1;
        j += 1;
        if ((i<0 && j >= m) || (j >= n)){
            cout << endl;
            i = m-1;
            j = J;
            J = J+1;
        }else if(i<0){
            cout << endl;
            i = j;
            j = 0;
        }
    }
}

int main(){
    vector<vector<int>> matrix {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
    diagonalOrder(matrix);
    return 0;
}
    