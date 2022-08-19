def histogram(heights):
    max_area = 0
    pstack, hstack = [], []
    heights.append(0)
    h = len(heights)
    for i in range(h):
        last_width = h + 1
        while pstack and hstack[-1] > int(heights[i]):
            last_width = pstack[-1]
            max_area = max(max_area, (i - pstack.pop()) * hstack.pop())
        if not pstack or hstack[-1] <= int(heights[i]):
            pstack.append(min(last_width, i))
            hstack.append(int(heights[i]))
    heights.pop()
    return max_area

def max_rectangle(matrix):
    if not matrix:  return 0
    m, n = len(matrix), len(matrix[0])
    max_area = histogram(matrix[0])
    for i in range(1, m):
        for j in range(n):
            if int(matrix[i][j]):    matrix[i][j] = int(matrix[i][j]) + int(matrix[i - 1][j])
        max_area = max(max_area, histogram(matrix[i]))
    return max_area

if __name__=='__main__':
    matrix = [["1","0","1","0","0"],
              ["1","0","1","1","1"],
              ["1","1","1","1","1"],
              ["1","0","0","1","0"]]
    print(max_rectangle(matrix))