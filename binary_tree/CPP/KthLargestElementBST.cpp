#include <iostream>
#include <climits>
using namespace std;
 
struct Node
{
    int data;
    Node* left = nullptr, *right = nullptr;
 
    Node() {}
    Node(int data): data(data) {}
};
 
void inorder(Node* root)
{
    if (root == nullptr) {
        return;
    }
 
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}
 
Node* insert(Node* root, int key)
{
    if (root == nullptr) {
        return new Node(key);
    }
 
    if (key < root->data) {
        root->left = insert(root->left, key);
    }
    else {
        root->right = insert(root->right, key);
    }
 
    return root;
}

Node* kthLargest(Node* root, int *i, int k)
{
    if (root == nullptr) {
        return nullptr;
    }
 
    Node* left = kthLargest(root->right, i, k);
 
    if (left) {
        return left;
    }
 
    if (++*i == k) {
        return root;
    }
 
    return kthLargest(root->left, i, k);
}
 
Node* findKthLargest(Node* root, int k)
{
    int i = 0;
    return kthLargest(root, &i, k);
}
 
int main()
{
    int keys[] = { 15, 10, 20, 8, 12, 16, 25 };
 
    Node* root = nullptr;
    for (int key: keys) {
        root = insert(root, key);
    }
 
    int k = 2;
    Node* node = findKthLargest(root, k);
 
    if (node != nullptr) {
        cout << node->data;
    }
    else {
        cout << "Invalid Input";
    }
 
    return 0;
}