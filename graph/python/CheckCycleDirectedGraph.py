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