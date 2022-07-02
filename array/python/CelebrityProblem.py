# Time: O(n + n)
# Space: O(1)

def celebrity_problem(matrix):
    n = len(matrix)
    i, j = 0, n - 1
    while i < j:
        if matrix[i][j]:
            i += 1
        else:
            j -= 1
    for k in range(n):
        if i != k and (matrix[i][k] or not matrix[k][i]):
            return -1
    return i

if __name__=='__main__':
    tc = [[[ 0, 0, 1, 0 ],[ 0, 0, 1, 0 ],[ 0, 0, 0, 0 ],[ 0, 0, 1, 0 ]],
          [[0, 1, 0],[0, 0, 0],[0, 1, 0]],
          [[0, 1], [1, 0]],
          [[0, 0, 1, 0],[0, 0, 1, 0],[0, 1, 0, 0],[0, 0, 1, 0]]]
    for t in tc:
        print(celebrity_problem(t))