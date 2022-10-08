# Time: O(m * n)
# Space: O(m * n)

def knapsack(weights, values, capacity):
    n = len(weights)
    dp = [0] * (capacity + 1)
    for i in range(1, n + 1):
        dp2 = [0]
        for j in range(1, capacity + 1):
            if j < weights[i - 1]:    dp2.append(dp[j])
            else:
                dp2.append(max(dp[j], values[i - 1] + dp2[j - weights[i - 1]]))
        dp = dp2
    return dp[-1]

if __name__=='__main__':
    weights = [1, 3, 4, 5]
    values = [10, 40, 50, 70]
    print(knapsack(weights, values, 8))
