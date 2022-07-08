# Time: O(n)
# Space: O(1)

def square_root(num):
    low, high = 0, num
    while low <= high:
        mid = (low + high) // 2
        if mid * mid == num or (mid * mid < num and (mid + 1) * (mid + 1) > num):
            return mid
        if mid * mid > num:
            high = mid - 1
        else:
            low = mid + 1

if __name__=='__main__':
    tc = [64, 16, 9, 1, 63, 72, 57, 19, 11, 8, 4]
    for t in tc:
        print(square_root(t))