from collections import defaultdict

class Graph:
    def __init__(self, n):
        self.graph = defaultdict(list)
        self.n = n
    
    def add_edge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)
    
    def dfs(self, u, parent, seen):
        seen.add(u)
        for v in self.graph[u]:
            if v == parent:    continue
            if v in seen:    return True
            if self.dfs(v, u, seen):    return True
        return False
    
    def is_cycle(self):
        seen = set()
        for u in self.graph:
            if u in seen:    continue
            if self.dfs(u, None, seen):    return True
        return False

if __name__=='__main__':
    g = Graph(5)
    g.add_edge(1, 0)
    g.add_edge(1, 2)
    g.add_edge(2, 0)
    g.add_edge(0, 3)
    g.add_edge(3, 4)

    if g.is_cycle():
        print("Graph contains cycle")
    else:
        print("Graph does not contain cycle ")