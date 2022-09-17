def combinationSum3(k, n):
    def comb_sum_III(nums, arr, k, n):
        if not k and not n:
            res.append(arr[:])
            return
        for i in range(len(nums)):
            # if i and nums[i] == nums[i - 1]:
            #     continue
            if nums[i] > n or k < 0:
                break
            comb_sum_III(nums[i + 1:], arr + [nums[i]], k - 1, n - nums[i])
    
    res = []
    nums = [i for i in range(1, 10)]
    comb_sum_III(nums, [], k, n)
    return res

if __name__=='__main__':
    test_cases = [
                    [3, 7],
                    [3, 9],
                    [4, 1]
                 ]
    for k, n in test_cases:
        print(combinationSum3(k, n))