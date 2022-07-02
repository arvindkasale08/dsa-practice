# Time: O(n + n)
# Space: O(1)

def search_element(matrix, val):
    m, n = len(matrix), len(matrix[0])
    i, j = 0, n - 1
    while i < m:
        if matrix[i][j] == val:
            return True
        if matrix[i][j] < val:
            i += 1
        else:
            j -= 1
        if i == m or j < 0:
            return False

if __name__=='__main__':
    tc = [[[[10, 20, 30, 40],[15, 25, 36, 46],[27, 29, 37, 48],[32, 33, 39, 50]], 32],
          [[[10, 20, 30, 40],[15, 25, 36, 46],[27, 29, 37, 48],[32, 33, 39, 50]], 59]]
    for t in tc:
        print(search_element(t[0], t[1]))