from collections import defaultdict

class Graph:
    def __init__(self, n):
        self.graph = defaultdict(list)
        self.in_degree = [0] * n
        self.n = n
    
    def add_edge(self, u, v):
        self.graph[u].append(v)
        if self.graph[v]:    pass
        self.in_degree[v] += 1
    
    def dfs(self, u, seen, res):
        for v in self.graph[u]:
            if not self.in_degree[v]:    continue
            self.in_degree[v] -= 1
            if not self.in_degree[v] and v not in seen:
                seen.add(v)
                res.append(v)
                self.dfs(v, seen, res)
    
    def topological_sort(self):
        res = []
        seen = set()
        for u in self.graph:
            if u in seen:    continue
            if not self.in_degree[u]:
                seen.add(u)
                res.append(u)
                self.dfs(u, seen, res)
        return res

if __name__=='__main__':
    g = Graph(5)
    g.add_edge(0, 1)
    g.add_edge(0, 3)
    g.add_edge(1, 2)
    g.add_edge(2, 3)
    g.add_edge(2, 4)
    g.add_edge(3, 4)


    print(g.topological_sort())