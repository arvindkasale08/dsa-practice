# Time: O(n * s) [n -> length of words, s -> length of largest word in words]
# Space: O(n + s)

from collections import defaultdict

def group_anagrams(words):
    anagrams = defaultdict(list)
    for word in words:
        ascii_word = [0] * 26
        for w in word:
            ascii_word[ord(w) - 97] += 1
        sorted_word = ''
        for i in range(26):
            sorted_word += chr(i + 97) * ascii_word[i]
        anagrams[sorted_word].append(word)
    return list(anagrams.values())

if __name__ == '__main__':
    result = []
    words = ["cat", "dog", "tac", "got", "act"]
    print(group_anagrams(words))