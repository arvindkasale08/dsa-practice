# Time: O(m * n)
# Space: O(m * n)

def lcs(word1, word2):
    m, n = len(word1), len(word2)
    matrix = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if word1[i - 1] == word2[j - 1]:    matrix[i][j] = 1 + matrix[i - 1][j - 1]
            else:    matrix[i][j] = max(matrix[i - 1][j], matrix[i][j - 1])
    return matrix[-1][-1]

if __name__=='__main__':
    print(lcs('ABCDEF', 'AEDNEK'))