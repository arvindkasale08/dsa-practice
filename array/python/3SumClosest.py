def threeSumClosest(nums, target):
    res = 9999
    nums.sort()

    for i in range(len(nums) - 2):
        l, r = i + 1, len(nums) - 1
        while l < r:
            threeSum = nums[i] + nums[l] + nums[r]
            if abs(target - threeSum) < abs(res):
                res = target - threeSum
            if res == 0:
                break
            if threeSum < target:
                l += 1
            else:
                r -= 1
    return target - res

if __name__=='__main__':
    test_cases = [[[-1,2,1,-4], 1],
                  [[0,0,0], 1],
                  [[1,1,-1,-1,3], -1]]
    for nums, target in test_cases:
        print(threeSumClosest(nums, target))