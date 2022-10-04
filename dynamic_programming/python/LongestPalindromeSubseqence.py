# Time: O(n^2)
# Space: O(n^2)

def lps(word):
    n = len(word)
    matrix = [[1 if i == j else 0 for j in range(n)] for i in range(n)]
    i, j, J = 0, 1, 2
    while i != 0 or j != n:
        if word[i] == word[j]:    matrix[i][j] = matrix[i + 1][j - 1] + 2
        else:    matrix[i][j] = max(matrix[i][j - 1], matrix[i + 1][j])
        i += 1
        j += 1
        if j == n:    i, j, J = 0, J, J + 1
    return matrix[0][n - 1]

if __name__=='__main__':
    print(lps('ADCECA'))