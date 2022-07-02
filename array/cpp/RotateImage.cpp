#include <iostream>
#include <vector>
using namespace std;

void rotateImage(vector<vector<int>>& matrix){
    int n = matrix.size();
    for (int i = 0; i<n; i++){
        for (int j = 0; j<i; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    
    for(int j = 0; j < matrix.size(); j++){
        for(int i = 0; i < matrix[j].size() / 2; i++) {
            int temp = matrix[j][i];
            matrix[j][i] = matrix[j][matrix[j].size() - i - 1];
            matrix[j][matrix[j].size() - i - 1] = temp;
        }
    }
}

// Need to refactor
void rotateMatrix(vector<vector<int>>& matrix){
    int n = matrix.size();
    for (int i = 0; i<n/2; i++){
        for (int j = i; j<n-i-1; j++){
            int temp = matrix[j][n-i-1];
            matrix[j][n-i-1] = matrix[i][j];
            matrix[i][j] = matrix[n-j-1][i];
            matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
            matrix[n-j-1][n-j-1] = temp;
        }
    }      
}

int main(){
    vector<vector<int>> matrix {{1,2,3},{4,5,6},{7,8,9}};
    rotateImage(matrix);
    for(int i = 0; i<matrix.size(); i++){
        for(int ele : matrix[i]){
            cout<< ele << " ";
        }
        cout<<endl;
    }

    vector<vector<int>> matrix_2 {{1,2,3},{4,5,6},{7,8,9}};
    rotateMatrix(matrix_2);
    for(int i = 0; i<matrix_2.size(); i++){
        for(int j = 0;j<matrix_2[i].size();j++){
            cout<< matrix_2[i][j] +" ";
        }
        cout<< endl;
    }

    return 0;
}
    