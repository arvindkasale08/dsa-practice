# Time: O(V + E)
# Space: O(V)

from collections import deque

def num_islands(matrix):
    X = [-1, -1, -1, 0, 1, 0, 1, 1]
    Y = [-1, 1, 0, -1, -1, 1, 0, 1]
    def bfs(i, j):
        queue = deque([[i, j]])
        seen.add((i, j))
        region = 0
        while queue:
            i, j = queue.popleft()
            region += 1
            for k in range(8):
                x, y = i + X[k], j + Y[k]
                if 0 <= x < m and 0 <= y < n and matrix[x][y]:
                    if (x, y) in seen:    continue
                    queue.append([x, y])
                    seen.add((x, y))
        return region
    
    m, n = len(matrix), len(matrix[0])
    seen = set()
    max_region = 0
    for i in range(m):
        for j in range(n):
            if matrix[i][j] and (i, j) not in seen:
                max_region = max(max_region, bfs(i, j))
    return max_region

if __name__=='__main__':
#     Inputs:
#     TC: 1
    mat = [[0, 0, 1, 1, 0],
           [1, 0, 1, 1, 0],
           [0, 1, 0, 0, 0],
           [0, 0, 0, 0, 1],
           [0, 0, 1, 1, 0]]
    
#     TC: 2
#     mat = [[0, 1, 0],
#            [0, 1, 0],
#            [0, 0, 0],
#            [1, 1, 0],
#            [1, 0, 1],
#            [0, 1, 1],
#            [1, 1, 1],
#            [0, 1, 1],
#            [1, 0, 1]]
    print(num_islands(mat))