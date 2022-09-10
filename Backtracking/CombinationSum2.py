def combinationSum2(arr, target):
    def combination_(arr, target, res, idx):
        if target < 0: return
        if target == 0:
            ans.append(res)
            return
        for i in range(idx, len(arr)):
            if i > idx and arr[i] == arr[i - 1]: continue
            combination_(arr, target - arr[i], res + [arr[i]], i + 1)
    res = []
    ans = []
    arr.sort()
    combination_(arr, target, res, 0)
    return ans
print(combinationSum2([10,1,2,7,6,1,5], 8))
