def candy(ratings):
    left, right = [1], [1]
    n = len(ratings)
    for i in range(1, n):
        if ratings[i] > ratings[i - 1]: left.append(left[-1] + 1)
        else:   left.append(1)
        if ratings[n - i - 1] > ratings[n - i]: right.append(right[-1] + 1)
        else:   right.append(1)
    res = 0
    for i in range(n):
        res += max(left[i], right[n - i - 1])
    return res

if __name__=='__main__':
    test_cases = [[1,0,2],
                  [1,2,2]]
    for tc in test_cases:
        print(candy(tc))