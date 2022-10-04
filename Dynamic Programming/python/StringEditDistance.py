# Time: O(m * n)
# Space: O(m * n)

def string_edit(word, pattern):
    m, n = len(word), len(pattern)
    matrix = [[i if not j else j if not i else 0 for j in range(n + 1)] for i in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if word[i - 1] == pattern[j - 1]:    matrix[i][j] = matrix[i - 1][j - 1]
            else:    matrix[i][j] = 1 + min(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1])
    return matrix[-1][-1]

if __name__=='__main__':
    print(string_edit('SATURDAY', 'SUNDAY'))