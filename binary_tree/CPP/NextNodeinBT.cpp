#include <iostream>
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
 
Node* findRightNode(Node* root, Node* node, int level, int &node_level)
{
    // return null if a tree is empty
    if (root == nullptr) {
        return nullptr;
    }
 
    if (root == node)
    {
        node_level = level;
        return nullptr;
    }
 
    
    else if (node_level && level == node_level) {
        return root;
    }
 
    
    Node* left = findRightNode(root->left, node, level + 1, node_level);
 

    if (left) {
        return left;
    }
 
    return findRightNode(root->right, node, level + 1, node_level);
}
 
Node* findRightNode(Node* root, Node* node)
{
    int node_level = 0;
    return findRightNode(root, node, 1, node_level);
}
 
int main()
{
 
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->left = new Node(6);
    root->right->left->left = new Node(7);
    root->right->left->right = new Node(8);
 
    Node* right = findRightNode(root, root->left->right);
 
    if (right) {
        cout << "Right node is " << right->data;
    }
    else {
        cout << "Right node doesn't exist";
    }
 
    return 0;
}
