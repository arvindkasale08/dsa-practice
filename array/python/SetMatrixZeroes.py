# Time: O((m * n) + (m * n)) ~ O(m * n)
# Space: O(1)

def set_zeroes(matrix):
    m, n = len(matrix), len(matrix[0])
    col = False
    for i in range(m):
        if matrix[i][0] == 0:    col = True
        for j in range(n):
            if matrix[i][j] == 0:    matrix[i][0] = matrix[0][j] = 0
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, 0, -1):
            if not matrix[i][0] or not matrix[0][j]:
                matrix[i][j] = 0
        if col:    matrix[i][0] = 0

if __name__=='__main__':
    matrix = [[1],[0]]
    set_zeroes(matrix)
    for m in matrix:    print(m)