# Time: O(n + p)
# Space: O(n + p)

from collections import defaultdict

def min_window(text, ptr):
    ascii_text, ascii_ptr = defaultdict(int), defaultdict(int)
    for p in ptr:   ascii_ptr[p] += 1
    n, p = len(text), len(ascii_ptr)
    count = start = 0
    window = ''
    for i in range(n):
        ascii_text[text[i]] += 1
        if count < p:
            if ascii_text[text[i]] == ascii_ptr[text[i]]:
                count += 1
        if count == p:
            while ascii_text[text[start]] > ascii_ptr[text[start]]:
                ascii_text[text[start]] -= 1
                start += 1
            window = min(window, text[start:i + 1], key = len) if window else text[start:i + 1]
    return window

if __name__=='__main__':
    tc = [["ADOBECODEBANC","ABC"],
          ["zaaskzaa", "zsk"],
          ["tutorial","oti"]]
    for t, p in tc:
        print(min_window(t, p))