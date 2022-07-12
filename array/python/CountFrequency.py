# Time: O(n)
# Space: O(1)

def count_freq(arr):
    arr = [i - 1 for i in arr]
    n = len(arr)
    for i in range(n):
        arr[arr[i] % n] += n
    for i in range(n):
        print('Frequency of', i + 1, '=', arr[i] // n)

if __name__=='__main__':
    tc = [[2, 3, 3, 2, 5],
         [5, 2, 7, 7, 5, 5, 2],
         [1, 2, 2, 1, 1, 2, 3, 2],
         [1, 2, 2],
         [4, 4, 4, 4]]
    for t in tc:
        count_freq(t)
        print()