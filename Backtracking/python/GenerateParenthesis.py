def parenthesis_comb(n):
    def combinations(open_p = 0, close_p = 0, s = ''):
        if close_p > open_p or open_p > n or close_p > n:    return
        if open_p == close_p == n:
            res.append(s)
            return
        combinations(open_p + 1, close_p, s + '(')
        combinations(open_p, close_p + 1, s + ')')
    
    res = []
    combinations()
    return res

if __name__=='__main__':
    n = 3
    print(parenthesis_comb(n))