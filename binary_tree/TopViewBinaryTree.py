from queue import deque

class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

def topView(root):
    dic = {}
 
    mi = float('inf')
 
    if not root:
        return
 
    q = deque([(root, 0)])
 
    while q:
        cur = q.popleft()
        if cur[1] not in dic:
            dic[cur[1]] = cur[0].data
            mi = min(mi, cur[1])
        if cur[0].left:
            q.append((cur[0].left, cur[1] - 1))
        if cur[0].right:
            q.append((cur[0].right, cur[1] + 1))
 
    while mi in dic:
        print(dic[mi], end=' ')
        mi += 1 

if __name__ == '__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.left.right.right = Node(5)
    root.left.right.right.right = Node(6)
    topView(root)