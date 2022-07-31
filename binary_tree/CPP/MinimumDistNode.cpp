#include <iostream>
using namespace std;
struct Node {
	struct Node *left, *right;
	int key;
};
Node* newNode(int key)
{
	Node* temp = new Node;
	temp->key = key;
	temp->left = temp->right = NULL;
	return temp;
}
int ans;
int _findDistance(Node* root, int n1, int n2)
{
	if (!root) return 0;
	int left = _findDistance(root->left, n1, n2);
	int right = _findDistance(root->right, n1, n2);
	if (root->key == n1 || root->key == n2)
	{
		if (left || right)
		{
			ans = max(left, right);
			return 0;
		}
		else
			return 1;
	}
	else if (left && right)
	{
		ans = left + right;
		return 0;
	}
	else if (left || right)
		return max(left, right) + 1;
	return 0;
}

int findDistance(Node* root, int n1, int n2)
{
	ans = 0;
	_findDistance(root, n1, n2);
	return ans;
}

int main()
{
	Node* root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(6);
	root->right->right = newNode(7);
	root->right->left->right = newNode(8);
	cout << "Dist(4, 5) = " << findDistance(root, 4, 5);
	cout << "\nDist(4, 6) = " << findDistance(root, 4, 6);
	cout << "\nDist(3, 4) = " << findDistance(root, 3, 4);
	cout << "\nDist(2, 4) = " << findDistance(root, 2, 4);
	cout << "\nDist(8, 5) = " << findDistance(root, 8, 5);
	return 0;
}
