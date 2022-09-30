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
    
    def dfs(self, ptr, word):
        if ptr.end_of_word:
            self.suggestions.append(word)
        for ch in ptr.children:    self.dfs(ptr.children[ch], word + ch)
    
    def autocomplete_feature(self, word):
        ptr = self.root
        for ch in word:
            if not ptr.children.get(ch):    return []
            ptr = ptr.children[ch]
        self.suggestions = []
        self.dfs(ptr, word)
        return self.suggestions

if __name__=='__main__':
    trie = Trie()
    dictionary = ["hello", "dog", "hell", "cat", "a", "hel", "help", "helps", "helping"]
    for word in dictionary:    trie.insert(word)
    print(trie.autocomplete_feature('hel'))
