def histogram_problem(heights):
    heights.append(0)
    h = len(heights)
    pstack, hstack = [], []
    max_area = 0
    for i in range(h):
        last_width = h + 1
        while pstack and hstack[-1] > heights[i]:
            last_width = pstack[-1]
            max_area = max(max_area, (i - pstack.pop()) * hstack.pop())
        if not pstack or hstack[-1] <= heights[i]:
            pstack.append(min(i, last_width))
            hstack.append(heights[i])
    return max_area

if __name__=='__main__':
    heights = [6, 2, 5, 4, 5, 1, 6]
    print(histogram_problem(heights))