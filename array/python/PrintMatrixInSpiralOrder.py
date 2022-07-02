# Time: O(m * n)
# Space: O(1)

def spiral_order(matrix):
    m, n = len(matrix), len(matrix[0])
    k = l = 0
    while k < m and l < n:
        for i in range(l, n):
            print(matrix[k][i], end = ' ')
        k += 1
        for i in range(k, m):
            print(matrix[i][n - 1], end = ' ')
        n -= 1
        if k < m:
            for i in range(n - 1, l - 1, -1):
                print(matrix[m - 1][i], end = ' ')
            m -= 1
        if l < n:
            for i in range(m - 1, k - 1, -1):
                print(matrix[i][l], end = ' ')
            l += 1
    print()

if __name__=='__main__':
    tc = [[[1,2,3],[4,5,6],[7,8,9]],
          [[1,2,3,4],[5,6,7,8],[9,10,11,12]],
          [[1, 2, 3, 4, 5],[16, 17, 18, 19, 6],[15, 24, 25, 20, 7],[14, 23, 22, 21, 8],[13, 12, 11, 10, 9]]]
    for t in tc:
        spiral_order(t)