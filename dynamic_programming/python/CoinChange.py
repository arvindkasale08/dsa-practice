# Time: O(m * n)
# Space: O(m * n)

def coin_change(coins, target):
    n = len(coins)
    dp = [1 if not i else 0 for i in range(target + 1)]
    for i in range(n):
        dp2 = [1]
        for j in range(1, target + 1):
            if j < coins[i]:    dp2.append(dp[j])
            else:    dp2.append(dp[j] + dp2[j - coins[i]])
        dp = dp2
    return dp[-1]

if __name__=='__main__':
    print(coin_change([2, 3, 4], 7))