# Time: O(n * n)
# Space: O(1)

# Two-pass approach
def rotate_image(matrix):
    """
    Do not return anything, modify matrix in-place instead.
    """
    n = len(matrix)
    for i in range(n):
        for j in range(i):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    for i in range(n):
        matrix[i].reverse()

# Single-pass approach
def rotate_matrix(matrix):
    n = len(matrix)
    for i in range(n // 2):
        for j in range(i, n - i - 1):
            temp = matrix[j][n - i - 1]
            matrix[j][n - i - 1] = matrix[i][j]
            matrix[i][j] = matrix[n - j - 1][i]
            matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]
            matrix[n - i - 1][n - j - 1] = temp
    return matrix

if __name__=='__main__':
    tc = [[[1, 2, 3],[4, 5, 6],[7, 8, 9]],
          [[1, 2, 3, 4],[5, 6, 7, 8],[9, 10, 11, 12],[13, 14, 15, 16]]]
    for t in tc:
        matrix = rotate_matrix(t)
        for m in matrix:
            print(m)
        print()