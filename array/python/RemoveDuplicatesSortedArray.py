def removeDuplicatesSortedArray(arr):
    if len(arr) == 0 or len(arr) == 1:
        return len(arr)
    
    j = 0
    for i in range(len(arr)-1):
        if arr[i] != arr[i+1]:
            arr[j] = arr[i]
            j+=1
    
    arr[j] = arr[i]
    j+=1

    return j

arr = [1,2,3,4,5,5,5]

n = removeDuplicatesSortedArray(arr)
for i in range(n):
    print(arr[i])