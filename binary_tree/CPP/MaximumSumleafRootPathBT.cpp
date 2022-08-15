#include <iostream>
#include <climits>
using namespace std;
struct Node
{
    int data;
    Node *left, *right;
 
    Node(int data)
    {
        this->data = data;
        this->left = this->right = nullptr;
    }
};
int getRootToLeafSum(Node* root)
{
    // base case: tree is empty
    if (root == nullptr) {
        return INT_MIN;
    }
    if (root->left == nullptr && root->right == nullptr) {
        return root->data;
    }
 
    int left = getRootToLeafSum(root->left);

    int right = getRootToLeafSum(root->right);
 
    return (left > right? left : right) + root->data;
}
 

void findMaxSumPath(Node* root)
{
    int sum = getRootToLeafSum(root);
    cout << "The Maximum sum is " << sum << endl;

}
 
int main()
{
 
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(8);
    root->left->right = new Node(4);
    root->right->left = new Node(5);
    root->right->right = new Node(6);
    root->left->right->left = new Node(10);
    root->right->left->left = new Node(7);
    root->right->left->right = new Node(9);
    root->right->right->right = new Node(5);
 
    findMaxSumPath(root);
 
    return 0;
}