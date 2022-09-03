from heapq import heapify, heappush, heappop

# Max-Heap Implementation

def heapify(arr, i, n):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2
    if left < n and arr[largest] < arr[left]:    largest = left
    if right < n and arr[largest] < arr[right]:    largest = right
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, largest, n)

def insert(arr, val):
    n = len(arr)
    if not arr:    arr.append(val)
    else:
        arr.append(val)
        for i in range(n // 2 - 1, -1, -1):
            heapify(arr, i, n)

def delete(arr, val):
    n = len(arr)
    for i in range(n):
        if arr[i] == val:    break
    arr[i], arr[n-1] = arr[n-1], arr[i]
    arr.pop()
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, i, n - 1)

if __name__=='__main__':
    arr = []
    
    insert(arr, 3)
    insert(arr, 4)
    insert(arr, 9)
    insert(arr, 5)
    insert(arr, 2)
    
    print ("Max-Heap array: " + str(arr))
    
    delete(arr, 4)
    print("After deleting an element: " + str(arr))

    # Min-Heap Implementation

    arr = []
    
    heappush(arr, 3)
    heappush(arr, 4)
    heappush(arr, 9)
    heappush(arr, 5)
    heappush(arr, 2)
    
    print ("Min-Heap array: " + str(arr))
    
    arr.remove(4)
    heapify(arr)
    print("After deleting an element: " + str(arr))