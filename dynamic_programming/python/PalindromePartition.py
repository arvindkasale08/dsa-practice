# Time: O(n^3)
# Space: O(n^2)

def min_cut(word):
    n = len(word)
    matrix = [[-1 for _ in range(n)] for _ in range(n)]
    def palindrome_partition(word, i, j):
        if i >= j:    return 0
        if word[i:j + 1] == word[i:j + 1][::-1]:    return 0
        if matrix[i][j] != -1:    return matrix[i][j]
        cut = float('inf')
        for k in range(i, j):
            if matrix[i][k] != -1:    left = matrix[i][k]
            else:
                left = palindrome_partition(word, i, k)
                matrix[i][k] = left
            if matrix[k + 1][j] != -1:    right = matrix[k + 1][j]
            else:
                right = palindrome_partition(word, k + 1, j)
                matrix[k + 1][j] = right
            cut = min(cut, 1 + left + right)
        matrix[i][j] = cut
        return cut
    return palindrome_partition(word, 0, n - 1)

if __name__=='__main__':
    print(min_cut("ababbbabbababa"))