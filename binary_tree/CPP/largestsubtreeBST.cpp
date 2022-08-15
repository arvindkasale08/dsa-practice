#include <bits/stdc++.h>
using namespace std;

struct Node
{
	int data;
	struct Node* left;
	struct Node* right;
	Node(int val)
	{
		this->data = val;
		left = NULL;
		right = NULL;
	}
};

vector<int> largestBSTBT(Node* root)
{
	
	if (root == NULL)
		return {INT_MAX, INT_MIN, 0};
	if (root->left == NULL && root->right == NULL)
		return {root->data, root->data, 1};

	vector<int> left = largestBSTBT(root->left);
	vector<int> right = largestBSTBT(root->right);

	vector<int> ans(3, 0);

	if ((left[1] < root->data) && (right[0] > root->data))
	{
		ans[0] = min(left[0], min(right[0], root->data));
		ans[1] = max(right[1], max(left[1], root->data));
		ans[2] = 1 + left[2] + right[2];
		return ans;
	}

	ans[0] = INT_MIN;
	ans[1] = INT_MAX;
	ans[2] = max(left[2], right[2]);

	return ans;
}

int largestBSTBTutil(Node *root)
{
	return largestBSTBT(root)[2];
}

int main() {


	struct Node *root = new Node(50);
	root->left = new Node(75);
	root->right = new Node(45);
	root->left->left = new Node(40);
	printf(" Size of the largest BST is %d\n", largestBSTBTutil(root));
	return 0;
}

