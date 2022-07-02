#include <iostream>
#include <vector>
using namespace std;

void spiralOrder(vector<vector<int>>& matrix){
    int m = matrix.size();
    int n = matrix[0].size();
    int k = 0;
    int l = 0;
    while (k<m && l<n){
        for (int i = l; i<n; i++){
            cout << matrix[k][i] << endl;
        }
        k+=1;
        for (int i = k; i<m; i++){
            cout<< matrix[i][n-1] << endl;
        }
        n -=1;
        if (k<m){
            for (int i = n-1; i>l-1;i--){
                cout << matrix[m-1][i] << endl;
            }
            m-=1;
        }
        if (l<n){
            for (int i = m-1; i >k-1; i--){
                cout << matrix[i][l] << endl;
            }
            l +=1;
        }
    }
}

int main(){
    vector<vector<int>> matrix {{1,2,3},{4,5,6,},{7,8,9,}};
    spiralOrder(matrix);
    return 0;
}
    