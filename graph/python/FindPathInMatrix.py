from collections import deque

def find_path(matrix):
    if not matrix or not matrix[0][0]:    return False
    seen = set()
    m, n = len(matrix), len(matrix[0])
    queue = deque([[0, 0]])
    X = [-1, 0, 0, 1]
    Y = [0, -1, 1, 0]
    while queue:
        i, j = queue.popleft()
        if (i, j) == (m - 1, n - 1):    return True
        for k in range(4):
            x, y = i + X[k], j + Y[k]
            if 0 <= x < m and 0 <= y < n:
                if (x, y) in seen:    continue
                queue.append([x, y])
                seen.add((x, y))
    return False

if __name__=='__main__':
#     Inputs
#     TC: 1
#     matrix = [[0, 0, 0, 1, 0],
#               [1, 0, 0, 1, 1],
#               [0, 0, 0, 1, 0],
#               [1, 0, 1, 0, 1],
#               [0, 0, 1, 0, 0]]
    
#     TC: 2
    matrix = [[1, 0, 0, 0, 0],
              [1, 0, 1, 1, 1],
              [1, 1, 1, 0, 1],
              [1, 0, 0, 0, 1],
              [1, 0, 0, 0, 1]]
    print(find_path(matrix))