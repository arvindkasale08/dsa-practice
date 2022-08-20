def valid_parentheses(s):
    def match(o, c):
        if o == '(' and c == ')':    return True
        if o == '{' and c == '}':    return True
        if o == '[' and c == ']':    return True
        return False
    
    stack = []
    for c in s:
        if c in '({[':    stack.append(c)
        else:
            if not stack:    return False
            if not match(stack.pop(), c):    return False
    return len(stack) == 0

if __name__=='__main__':
    s = '()'
    print(valid_parentheses(s))