# Time: O(log(2^32) * m * log(n)) ~ O(32mlog(n)) ~ O(mlog(n))
# Space: O(1)

def matrix_median(matrix):
    def find_less_than_x(x):
        lesser = 0
        for i in range(m):
            l, h = 0, n - 1
            while l <= h:
                mid = (l + h) // 2
                if matrix[i][mid] <= x:    l = mid + 1
                else:    h = mid - 1
            lesser += l
        return lesser
    
    m, n = len(matrix), len(matrix[0])
    low, high = 1, 10 ** 9
    median_idx = (m * n) // 2
    while low <= high:
        x = (low + high) // 2
        val = find_less_than_x(x)
        if val <= median_idx:    low = x + 1
        else:    high = x - 1
    return low

if __name__=='__main__':
    matrix = [[1, 3, 5],
              [2, 6, 9],
              [3, 6, 9]]
    print(matrix_median(matrix))