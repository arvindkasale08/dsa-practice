# Time: O(n * s) + O(n * s) ~ O(n * s) where n -> Length of Alien dictionary & s -> Length of the largest word in dictionary
# Space: O(n) + O(n) + O(n) + O(n + s) ~ O(n)

from collections import defaultdict

def verify_alien_dictionary(words):
    def dfs(u):
        seen.add(u)
        for v in graph[u]:
            if not in_degree[v] or v in seen:    continue
            in_degree[v] -= 1
            if not in_degree[v]:
                res.append(v)
                dfs(v)
    
    graph = defaultdict(list)
    in_degree = defaultdict(int)
    n = len(words)
    for i in range(n - 1):
        for j in range(len(min(words[i], words[i + 1]))):
            if words[i][j] != words[i + 1][j]:
                graph[words[i][j]].append(words[i + 1][j])
                in_degree[words[i + 1][j]] += 1
                if not in_degree[words[i][j]]:    in_degree[words[i][j]] = 0
                break
    seen = set()
    res = []
    for c in in_degree:
        if not in_degree[c] and c not in seen:
            res.append(c)
            dfs(c)
    for word in words:
        for c in word:
            if c not in res:
                res.append(c)
    return res

if __name__=='__main__':
    dictionary = ['yxx', 'yxxta', 'xyzt', 'xyzx', 'zxy', 'zxt']
    res = verify_alien_dictionary(dictionary)
    for r in res:
        print(r, end = ' -> ')
    print('END')