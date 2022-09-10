def combinationSum(arr, target):
    def combination_s(arr, target, res):
        if target < 0: return
        if target == 0:
            ans.append(res)
            return
        for i in range(len(arr)):
            combination_s(arr[i:], target - arr[i], res + [arr[i]])
    res = []
    ans = []
    combination_s(arr, target, res)
    return ans
print(combinationSum([2,3,6,7], 7))