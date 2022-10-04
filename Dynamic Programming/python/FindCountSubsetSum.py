# Time: O(m * n)
# Space: O(m * n)

def subset_sum(nums, target):
    n = len(nums)
    dp = [1 if not i else 0 for i in range(target + 1)]
    for i in range(1, n + 1):
        dp2 = [1]
        for j in range(1, target + 1):
            if j < nums[i - 1]:    dp2.append(dp[j])
            else:    dp2.append(dp[j] + dp[j - nums[i - 1]])
        dp = dp2
    return dp[-1]

if __name__=='__main__':
    print(subset_sum([2,3,5,6,8,10], 10))