def trap(height):
    if not height:  return 0
    n, res = len(height), 0
    left, right = [0] * n, [0] * n
    left[0] = height[0]
    right[-1] = height[-1]
    for i in range(1, n):
        left[i] = max(left[i - 1], height[i])
    for i in range(n - 2, -1, -1):
        right[i] = max(right[i + 1], height[i])
    for i in range(n):
        res += min(left[i], right[i]) - height[i]
    return res

if __name__=='__main__':
    test_cases = [[0,1,0,2,1,0,1,3,2,1,2,1],
                  [4,2,0,3,2,5]]
    for tc in test_cases:
        print(trap(tc))