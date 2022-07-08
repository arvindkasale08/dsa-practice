# Time: O(n)
# Space: O(1)

def majority_number(arr):
    n = len(arr)
    majority = arr[0]
    count = 1
    for i in range(1, n):
        if arr[i] == majority:
            count += 1
        else:
            count -= 1
        if count == 0:
            majority = arr[i]
            count = 1
    return majority

if __name__=='__main__':
    tc = [[1, 3, 3, 4, 3, 2, 2, 2, 2, 2, 2],
          [1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2],
          [3, 2, 3],
          [2, 2, 1, 1, 1, 2, 2],
          [2, 2, 3, 2, 3, 2, 4, 2, 3, 2, 1, 2, 3]]
    for t in tc:
        print(majority_number(t))