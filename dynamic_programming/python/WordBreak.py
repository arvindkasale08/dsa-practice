# Time: O(n^2)
# Space: O(n)

def word_break(word, dictionary):
    n = len(word)
    dp = [True if not i else False for i in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(i):
            if dp[j] and word[j:i] in dictionary:
                dp[i] = True
                break
    return dp[-1]

if __name__=='__main__':
    print(word_break("applepenapple", ["apple", "pen"]))