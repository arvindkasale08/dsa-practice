# Time: O(n * s) where n -> length of words, s -> length of word with max length (One time operation)
# AUX Time: O(p) where p -> length of the word with min length
# Space: O(n) for Trie

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
    

def lcp(words):
    trie = Trie()
    for word in words:    trie.insert(word)
    ptr = trie.root
    prefix = ''
    while ptr and not ptr.end_of_word:
        if len(ptr.children) != 1:    return prefix
        for ch in ptr.children:
            prefix += ch
            ptr = ptr.children[ch]
    return prefix

if __name__=='__main__':
    print(lcp(["flower","flow","flight"]))
    print(lcp(["dog","racecar","car"]))
    print(lcp(["ab","a"]))