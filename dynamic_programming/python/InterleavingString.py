# Time: O(m * n)
# Space: O(m * n)

def interleaving_string(text1, text2, word):
    m, n = len(text1), len(text2)
    if m + n != len(word):    return False
    dp = []
    for i in range(n + 1):
        if i == 0:  dp.append(True)
        elif text2[i - 1] == word[i - 1]: dp.append(dp[-1])
        else:   dp.append(False)
    for i in range(1, m + 1):
        dp2 = [dp[0] if text1[i - 1] == word[i - 1] else False]
        for j in range(1, n + 1):
            if text1[i - 1] == word[i + j - 1] and text2[j - 1] == word[i + j - 1]:
                dp2.append(dp2[-1] or dp[j])
            elif text1[i - 1] == word[i + j - 1]:    dp2.append(dp[j])
            elif text2[j - 1] == word[i + j - 1]:    dp2.append(dp2[-1])
            else:    dp2.append(False)
        dp = dp2
    return dp[-1]

if __name__=='__main__':
    print(interleaving_string('ABE', 'BDC', 'ABBDCE'))