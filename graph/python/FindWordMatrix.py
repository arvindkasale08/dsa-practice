# Time: O((m * n) * 8 ^ (m * n))
# Space: O(m * n) for recursion stack

class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        ptr = self.root
        for ch in word:
            if not ptr.children.get(ch):    ptr.children[ch] = TrieNode()
            ptr = ptr.children[ch]
        ptr.end_of_word = True

def find_word_in_matrix(matrix, dictionary):
    X = [-1, -1, -1, 0, 0, 1, 1, 1]
    Y = [-1, 0, 1, -1, 1, -1, 0, 1]
    def dfs(root, word, i, j):
        if root.end_of_word:    words.append(word)
        for k in range(8):
            x, y = i + X[k], j + Y[k]
            if 0 <= x < m and 0 <= y < n and root.children.get(matrix[x][y]):
                ch = matrix[x][y]
                matrix[x][y] = '.'
                dfs(root.children[ch], word + ch, x, y)
                matrix[x][y] = ch
        
    m, n = len(matrix), len(matrix[0])
    words = []
    trie = Trie()
    for word in dictionary:    trie.insert(word)
    root = trie.root
    for i in range(m):
        for j in range(n):
            if root.children.get(matrix[i][j]):
                ch = matrix[i][j]
                matrix[i][j] = '.'
                dfs(root.children[ch], ch, i, j)
                matrix[i][j] = ch
    return list(set(words))

if __name__=='__main__':
#     matrix = [['C','A','P'],['A','N','D'],['T','I','E']]
#     dictionary = ['CAT']
    
    matrix = [['G','I','Z'],['U','E','K'],['Q','S','E']]
    dictionary = ["GEEKS","FOR","QUIZ","GO"]
    print(find_word_in_matrix(matrix, dictionary))