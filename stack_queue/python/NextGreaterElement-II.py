def nextGreaterElements(arr):
    n = len(arr)
    res, stack = [0] * n, []
    for i in range(2 * n - 1, -1, -1):
        while stack and stack[-1] <= arr[i % n]:
            stack.pop()
        res[i % n] = -1 if not stack else stack[-1]
        stack.append(arr[i % n])
    return res

if __name__=='__main__':
    test_cases = [[1,2,1],
                  [1,2,3,4,3]]
    for tc in test_cases:
        print(nextGreaterElements(tc))