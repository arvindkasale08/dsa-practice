from collections import deque, defaultdict

class Node:
    def __init__(self, val, neighbors = []):
        self.val = val
        self.neighbors = []

def bfs(node):
    queue = deque([node])
    seen = set()
    seen.add(node)
    graph = defaultdict(list)
    while queue:
        node = queue.popleft()
        for neighbor in node.neighbors:
            if neighbor not in seen:
                queue.append(neighbor)
                seen.add(neighbor)
            graph[node.val].append(neighbor.val)
    return graph

def cloneGraph(root: 'Node') -> 'Node':
    if not root:    return root
    seen = defaultdict(int)
    seen[root] = Node(root.val)
    queue = deque([root])
    while queue:
        node = queue.popleft()
        for neighbor in node.neighbors:
            if neighbor not in seen:
                seen[neighbor] = Node(neighbor.val)
                queue.append(neighbor)
            seen[node].neighbors.append(seen[neighbor])
    return seen[root]

if __name__=='__main__':
    adjList = [[2,4],[1,3],[2,4],[1,3]]
    n = len(adjList)
    nodes = [Node(i) for i in range(1, n + 1)]
    for i in range(n):
        for j in range(len(adjList[i])):
            nodes[i].neighbors.append(nodes[adjList[i][j] - 1])
    node = cloneGraph(nodes[0])
    print(bfs(nodes[0]))
