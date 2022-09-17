# Time: O(v + e)
# Space: O(v + v) ~ O(v)

from collections import defaultdict

def isCycle(n, graph):
    def dfs(u):
        seen.add(u)
        visited.add(u)
        for v in graph[u]:
            if v in seen:    return True
            if v in visited:    continue
            if dfs(v):    return True
        seen.remove(u)
    
    seen, visited = set(), set()
    for u in range(n):
        if u in visited:    continue
        if dfs(u):    return True
    return False

if __name__=='__main__':
    graph = defaultdict(list)
    graph[0].append(1)
    graph[0].append(2)
    graph[1].append(2)
    graph[2].append(0)
    graph[2].append(3)
    graph[3].append(3)
    print(isCycle(4, graph))