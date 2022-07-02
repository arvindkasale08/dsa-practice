# Time: O(m * n)
# Space: O(1)

def diagonal_order(matrix):
    m, n = len(matrix), len(matrix[0])
    if n == 1 and m > 1:
        for i in range(m):
            print(matrix[i][0])
        return
    i = j = 0
    J = 1
    while i != m - 1 or j != n:
        print(matrix[i][j], end = ' ')
        i -= 1
        j += 1
        if (i < 0 and j >= m) or j >= n:
            print()
            i, j, J = m - 1, J, J + 1
        elif i < 0:
            print()
            i, j = j, 0

if __name__=='__main__':
    test_cases = [[[1, 2, 3, 4, 5],[6, 7, 8, 9, 10],[11, 12, 13, 14, 15],[16, 17, 18, 19, 20]],
                  [[1,2,3],[4,5,6],[7,8,9]],
                  [[1,2],[3,4]],
                  [[1,2,3,4]],
                  [[1],[2],[3]],
                  [[1]]]
    for tc in test_cases:
        diagonal_order(tc)
        print()