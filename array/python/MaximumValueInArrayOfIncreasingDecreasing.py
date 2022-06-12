# Time: O(logn)
# Space: O(1)

def find_max_value(arr):
    n = len(arr)
    low, high = 0, n - 1
    while low <= high:
        mid = (low + high) // 2
        if (not mid or mid == n - 1) or arr[mid - 1] < arr[mid] > arr[mid + 1]:
            return arr[mid]
        if arr[mid - 1] < arr[mid] < arr[mid + 1]:
            low = mid + 1
        else:
            high = mid - 1

if __name__=='__main__':
    test_cases = [[3, 5,15, 50, 11, 10, 8, 6],
                  [10, 20, 30, 40, 50],
                  [8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1],
                  [120, 100, 80, 20, 0]]
    for tc in test_cases:
        print(find_max_value(tc))