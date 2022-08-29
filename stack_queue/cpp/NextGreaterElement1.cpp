#include <iostream>
using namespace std;
#include <stack>
#include <vector>
#include <unordered_map>
vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2)
{
    vector<int> res(nums1.size(), -1);
    stack<int> st;
    unordered_map<int, int> umap;
        
    for(int i=0; i<nums2.size(); i++)
    {
        int element = nums2[i];
        
        while(!st.empty() && element > st.top())
        {
            umap[st.top()] = element;
            st.pop();
        }
        
        st.push(element);
    }
    
    for(int i=0; i<nums1.size(); i++)
    {
        int ele = nums1[i];
        
        if(umap.find(ele) != umap.end())
        {
            int nge = umap[ele];
            res[i] = nge;
        }
            
    }
    
    return res;
    
}

int main()
{
    vector<int> arr = { 2,4 };
    vector<int> arr1 = { 1,2,3,4 };
    vector<int> result = nextGreaterElement(arr, arr1);
    for (int i: result) {
        cout << i << ' ';
    }
 
    
    return 0;
}