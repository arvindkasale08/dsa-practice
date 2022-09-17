from collections import defaultdict, deque

class Graph:
    def __init__(self):
        self.dict = defaultdict(list)
    
    def add_edge(self, u, v):
        self.dict[u].append(v)
    
    def BFS(self, s):
        visited = [False] * (max(self.dict) + 1)
        queue = deque()
        queue.append(s)
        visited[s] = True
        while queue:
            v = queue.popleft()
            print(v, end = ' ')
            for i in self.dict[v]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True

if __name__=='__main__':
    graph = Graph()
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 2)
    graph.add_edge(2, 0)
    graph.add_edge(2, 3)
    graph.add_edge(3, 3)

    graph.BFS(2)