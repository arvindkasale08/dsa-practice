def lss_rsl(arr):
    n = len(arr)
    max = arr[0]
    min = arr[-1]
    l = [0]*n
    r = [0]*n
    for i in range(1, n-1):
        if max < arr[i]:
            max = arr[i]
            l[i] = 1
        if min > arr[n-i-1]:
            min = arr[n-i-1]
            r[n-i-1] = 1
    for i in range(1, n-1):
        if (l[i] and r[i]):
            return arr[i]
        if i == n-2:
            return -1
if __name__ == "__main__":
    arr = list(map(int, input().split()))
    print(lss_rsl(arr))


