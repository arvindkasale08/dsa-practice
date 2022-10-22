# Time: O(n^2)
# Space: O(n)

def keystroke(n):
    if n < 7:    return n
    dp = [i for i in range(7)]
    for i in range(7, n + 1):
        keywords = 0
        for j in range(i - 3, 0, -1):
            keywords = max(keywords, (i - j - 1) * dp[j])
        dp.append(keywords)
    return dp[-1]

if __name__=='__main__':
    print(keystroke(11))