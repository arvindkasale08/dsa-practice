# Time: O(v + e) + O(v + e) + O(v + e) ~ O(v + e)
# Space: O(v) + O(v + e) + O(v) ~ O(v + e)

from collections import defaultdict

def kosaraju(n, graph):
    def topo_sort():
        def topo_sort_util(u):
            seen.add(u)
            for v in graph[u]:
                if v in seen:   continue
                topo_sort_util(v)
            stack.append(u)
        seen = set()
        for u in range(n):
            if u in seen:   continue
            topo_sort_util(u)

    def transpose_graph():
        for u in range(n):
            for v in graph[u]:  t_graph[v].append(u)

    def dfs():
        scc = 0
        def dfs_util(u):
            seen.add(u)
            for v in t_graph[u]:
                if v in seen:   continue
                dfs_util(v)

        seen = set()
        while stack:
            u = stack.pop()
            if u in seen:   continue
            dfs_util(u)
            scc += 1
        return scc

    stack = []
    topo_sort()
    t_graph = defaultdict(list)
    transpose_graph()
    scc = dfs()
    return scc