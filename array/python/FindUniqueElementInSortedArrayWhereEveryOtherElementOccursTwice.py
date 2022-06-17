def single_non_duplicate(arr):
    first, last = 0,len(arr)-1
    if last == 0:
        arr[0]
    while first <= last:
        if arr[first] != arr[first+1]:
            return arr[first]
        else:
            first = first+2
        
        if arr[last] != arr[last-1]:
            arr[last]
        else:
            last = last-2
    return 0

arr = [1,1,2,3,3]
ele = single_non_duplicate(arr)
print("ele: ",ele)