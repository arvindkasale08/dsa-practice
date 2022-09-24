# Time: O(v + e)
# Space: O(v + v) ~ O(v)

def isBipartite(n, graph):
    def bfs(u):
        queue = deque([[u, 0]])
        seen[u] = 0
        while queue:
            u, color = queue.popleft()
            for v in graph[u]:
                if seen[v] == color:    return False
                if seen[v] != -1:   continue
                queue.append([v, 1 if not color else 0])
                seen[v] = 1 if not color else 0
        return True
    seen = [-1] * n
    for u in range(n):
        if seen[u] != -1:   continue
        if not bfs(u):  return False
    return True