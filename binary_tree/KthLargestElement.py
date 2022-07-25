class Node: 
    def __init__(self, data): 
        self.key = data 
        self.left = None
        self.right = None
          
def kthLargestUtil(root, k, c, v):
    
    if root == None or c[0]>=k: 
        return

    kthLargestUtil(root.left,k, c, v)
    c[0] += 1
    if (c[0] == k):
        v[0] = root.key
        return
    kthLargestUtil(root.right,k,c, v)
  
def kthLargest(root, k):
    c = [0]
    v = [0]
    kthLargestUtil(root, k, c, v)
    return v[0]  
def insert(node, key): 
      
    if node == None:
        return Node(key) 
  
    if key < node.key: 
        node.left = insert(node.left, key) 
    elif key > node.key:
        node.right = insert(node.right, key) 
  
    return node
  
if __name__ == '__main__':
    root = None
    root = insert(root, 50)
    insert(root, 30)
    insert(root, 20)
    insert(root, 40)
    insert(root, 70)
    insert(root, 60)
    insert(root, 80)
  
    print(kthLargest(root, 3))