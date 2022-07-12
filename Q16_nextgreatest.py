def nxtgrt(k):
    arr = list(str(k))
    n = len(arr)
    i = n-1
    while i>0:
        if arr[i] > arr[i-1]:
            break
        i -= 1
    if i == 0:
        return -1
    idx = i
    for j in range(i+1, n):
        if (arr[j] < arr[idx]) and (arr[i-1] < arr[j]):
            idx = j
    arr[i-1], arr[idx] = arr[idx], arr[i-1]
    arr = arr[:i] + sorted(arr[i:])
    res = int("".join(arr))
    return -1 if res >= (2**31) else res

if __name__ == "__main__":
    k = int(input())
    print(nxtgrt(k))

