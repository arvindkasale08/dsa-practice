from heapq import heappush, heappop
from collections import defaultdict
# For printing mst
# def printMST(parent):
#         print("Edge \tWeight")
#         for i in range(n):
#             print(parent[i], "-", i, "\t", graph[i][parent[i]])

def primAlgo(graph):
    min_heap = []
    n = len(graph)
    weights = [float('inf') for _ in range(n)]
    parent = [-1  for _ in range(n)]
    mstSet = [False for _ in range(n)]

    heappush(min_heap, (0, 0))

    weights[0] = 0

    while len(min_heap) > 0: 
        weight, node = heappop(min_heap)

        mstSet[node] = True

        for node_itr, weight_itr in graph[node]:
            if mstSet[node_itr] == False and weight_itr < weights[node_itr]:
                parent[node_itr] = node
                weights[node_itr] = weight_itr
                heappush(min_heap, (weights[node_itr], node_itr))
    return sum(weights[1:])
# Main function

edges = [[0,1,2],[0,3,6],[1,0,2],[1,2,3],[1,3,8],[1,4,5],[2,1,3],[2,4,7],
        [3,0,6],[3,1,8],[3,4,9],[4,1,5],[4,2,7],[4,3,9]]
graph = defaultdict(list)
for u, v, w in edges:
    graph[u].append((v, w))
    graph[v].append((u, w))
    
print(primAlgo(graph))