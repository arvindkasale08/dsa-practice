from collections import defaultdict

class Graph:
    def __init__(self, n):
        self.graph = defaultdict(list)
        self.n = n
    
    def add_edge(self, u, v):
        self.graph[u].append(v)
    
    def dfs(self, u, seen):
        seen.add(u)
        for v in self.graph[u]:
            if v not in seen:    self.dfs(v, seen)
    
    def transpose(self):
        t_graph = defaultdict(list)
        for u in self.graph:
            for v in self.graph[u]:
                t_graph[v].append(u)
        self.graph = t_graph
    
    def is_strongly_connected(self):
        seen = set()
        self.dfs(0, seen)
        if len(seen) < self.n:    return False
        self.transpose()
        seen = set()
        self.dfs(0, seen)
        if len(seen) < self.n:    return False
        return True
    
if __name__=='__main__':
#     Inputs:
#     TC: 1
    g = Graph(5)
    g.add_edge(0, 1)
    g.add_edge(1, 2)
    g.add_edge(2, 3)
    g.add_edge(3, 0)
    g.add_edge(2, 4)
    g.add_edge(4, 2)
    
#     TC: 2
#     g = Graph(4)
#     g.add_edge(0, 1)
#     g.add_edge(1, 2)
#     g.add_edge(2, 3)
    
    print(g.is_strongly_connected())