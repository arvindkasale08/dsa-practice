# Time: O((v + e) * log(v))
# Space: O(v + v) ~ O(v)

from heapq import heappush, heappop

def dijkstra(n, graph, source):
    dist = [float('inf')] * n
    queue = [[0, source]]
    dist[source] = 0
    while queue:
        time, u = heappop(queue)
        for v, w in graph[u]:
            if time + w >= dist[v]: continue
            dist[v] = time + w
            heappush(queue, [time + w, v])
    return dist