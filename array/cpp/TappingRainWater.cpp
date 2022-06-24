#include <iostream>
#include <vector>

using namespace std;

int trap(vector<int>& height) {
    int sum = 0;
    int leftMax[height.size()], rightMax[height.size()];
    int temp = 0;
    
    for (int i = 0; i<height.size(); i++){
        temp = max(height[i], temp);
        leftMax[i] = temp;
    }

    temp = 0;
    for (int i = height.size()-1; i>=0; i--){
        temp = max(height[i], temp);
        rightMax[i] = temp;
    }

    for (int i = 0; i<height.size(); i++){
        sum+= min(leftMax[i],rightMax[i])- height[i];
    }
    return sum;
}
 
int main(){
    vector<int> arr = {1,2,3,4,5,6,5,4,3,2,1};
    int water = trap(arr);
    cout<< "Water: " << water << endl;
    return 0;
}