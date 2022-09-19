# Time: O(V^E)
# Space: O(V^E)

from collections import defaultdict

class Graph:
    def __init__(self, n):
        self.graph = defaultdict(list)
        self.n = n
    
    def add_edge(self, u, v):
        self.graph[u].append(v)
    
    def dfs(self, src, dest, path, seen, paths):
        if src == dest:
            paths.append(path[:])
            return
        for node in self.graph[src]:
            if node in seen:    continue
            seen.add(node)
            self.dfs(node, dest, path + [node], seen, paths)
            seen.remove(node)
    
    def find_all_paths(self, src, dest):
        paths = []
        seen = set()
        seen.add(src)
        self.dfs(src, dest, [src], seen, paths)
        return paths

if __name__=='__main__':
    g = Graph(4)
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(0, 3)
    g.add_edge(2, 0)
    g.add_edge(2, 1)
    g.add_edge(1, 3)
    
    print(g.find_all_paths(2, 3))