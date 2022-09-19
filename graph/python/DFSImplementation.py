from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)
    
    def add_edge(self, u, v):
        self.graph[u].append(v)
    
    def DFS(self, v, visited = defaultdict(int)):
        visited[v] = 1
        print(v, end = ' ')
        for i in self.graph[v]:
            if not visited[i]:
                self.DFS(i, visited)
    
if __name__=='__main__':
    graph = Graph()
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 2)
    graph.add_edge(2, 0)
    graph.add_edge(2, 3)
    graph.add_edge(3, 3)

    graph.DFS(2)