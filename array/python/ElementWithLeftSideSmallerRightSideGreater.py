def findElement(nums, n):
    left, right = [nums[0]], [nums[-1]]
    for i in range(1, n):
        left.append(nums[i] if nums[i] > left[-1] else left[-1])
        right.append(nums[n - i - 1] if nums[n - i - 1] < right[-1] else right[-1])
    right.reverse()
    for i in range(1, n - 1):
        if nums[i] >= left[i] and nums[i] <= right[i]:
            return nums[i]
    return -1

if __name__=='__main__':
    test_cases = [[[4,2,5,7], 4],
                  [[11, 9, 12], 3]]
    for nums, n in test_cases:
        print(findElement(nums, n))