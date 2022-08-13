#include <iostream>
using namespace std;
struct Node
{
    int key;
    Node *left, *right;
 
    Node(int key)
    {
        this->key = key;
        this->left = this->right = nullptr;
    }
};
int heightbalance (Node *root) {
    if (root == NULL) return 0;
    int leftHeight = heightbalance (root -> left);
    int rightHeight = heightbalance (root -> right);
    if (abs(leftHeight - rightHeight) > 1)  
        return -1;
    return max (leftHeight, rightHeight) + 1;

}
 
int main()
{
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->left->left->left = new Node(8);
    if (heightbalance(root) != -1){
        cout << "Balanced" << endl;
    }
    else{
        cout << "Not Balanced" << endl;
    }
 
    return 0;
}
