def nextGreaterElement(n):
    s = list(str(n))
    i = len(s) - 1
    while i > 0:
        if s[i] > s[i - 1]:
            break
        i -= 1
    if i == 0:
        return -1
    mini = i
    for j in range(i + 1, len(s)):
        if s[j] > s[i - 1] and s[mini] > s[j]:
            mini = j
    s[i - 1], s[mini] = s[mini], s[i - 1]
    s = s[:i] + sorted(s[i:])
    res = int(''.join(s))
    return -1 if res >= 2147483648 else res

if __name__=='__main__':
    test_cases = [[12, 21, 2147483486]]
    for tc in test_cases:
        print(nextGreaterElement(tc))