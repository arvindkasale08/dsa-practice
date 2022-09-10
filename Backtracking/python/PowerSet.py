def power_set(nums):
    def combinations(nums, arr = []):
        res.append(arr[:])
        for i in range(len(nums)):
            combinations(nums[i + 1:], arr + [nums[i]])
    res = []
    combinations(nums)
    return res

if __name__=='__main__':
    nums = [1,2,3]
    print(power_set(nums))