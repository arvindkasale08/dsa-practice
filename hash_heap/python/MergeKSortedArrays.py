# Time: O(nklog(k))
# Space: O(n * k)

from heapq import heappush, heappop

def merge_k_sorted_arr(matrix):
    m = len(matrix)
    result_size = 0
    min_heap = []
    for i in range(m):
        result_size += len(matrix[i])
        heappush(min_heap, [matrix[i][0], i, 0, len(matrix[i])])
    res = []
    while result_size:
        val, i, j, n = heappop(min_heap)
        res.append(matrix[i][j])
        j += 1
        if j == n:    heappush(min_heap, [float('inf'), i, j, n])
        else:    heappush(min_heap, [matrix[i][j], i, j, n])
        result_size -= 1
    return res

if __name__=='__main__':
    matrix = [[1, 3, 5, 7], [2, 4, 6, 8],[0, 9, 10, 11]] 
    print(merge_k_sorted_arr(matrix))