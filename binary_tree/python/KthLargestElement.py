class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None

def kthLargest(root, i, k):
    if root == None:
        return -1, i
    val, i = kthLargest(root.right, i, k)
    if val != -1:   return val, i    #<-- We have found the data, so we look no further
    i += 1
    if(i == k):
        return root.data, i     #<-- Finding the result
    return kthLargest(root.left, i, k)

if __name__=='__main__':
    root = Node(50)
    root.left = Node(30)
    root.left.left = Node(20)
    root.left.right = Node(40)
    root.right = Node(70)
    root.right.left = Node(60)
    root.right.right = Node(80)
    print(kthLargest(root, 0, 2)[0])