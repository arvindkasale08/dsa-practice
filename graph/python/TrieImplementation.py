# Time: O(n) for each query where n -> length of input word
# Space: O(n) for each query

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
    
    def search(self, word):
        ptr = self.root
        for ch in word:
            if not ptr.children.get(ch):    return False
            ptr = ptr.children[ch]
        return ptr.end_of_word
    
    def delete(self, word):
        if not self.search(word):    return 'Word Not Found!'
        ptr = self.root
        for ch in word:    ptr = ptr.children[ch]
        ptr.end_of_word = False
        return word + ' deleted!'
    
    def update(self, word, new_word):
        self.delete(word)
        self.insert(new_word)

if __name__=='__main__':
    trie = Trie()
    words = ['pqrs', 'prst', 'psst', 'qqrt', 'pqr']
    for word in words:
        trie.insert(word)
    print(trie.search('pqrs'))
    print(trie.delete('pqrs'))
    print(trie.search('pqr'))
    trie.update('pqr', 'prq')
    print(trie.search('pqr'), trie.search('prq'))