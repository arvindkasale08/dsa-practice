def maxArea(height):
    max_area = 0
    i = 0
    j = len(height) - 1
    while i != j:
        max_area = max(max_area, (j - i) * min(height[i], height[j]))
        if height[i] > height[j]:
            j -= 1
        else:
            i += 1
    return max_area

if __name__=='__main__':
    test_cases = [[1,8,6,2,5,4,8,3,7],
                  [1,1]]
    for tc in test_cases:
        print(maxArea(tc))