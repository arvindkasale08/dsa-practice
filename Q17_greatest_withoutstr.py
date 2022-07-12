import functools 
def fun(x, y):
    xy, yx = x, y
    nx, ny = 0, 0
    while(xy>=1):
        nx += 1
        xy /= 10
    while(yx>=1):
        ny += 1
        yx /= 10
    xy = x*(10**ny) + y
    yx = y*(10**nx) + x
    if xy > yx:
        return -1
    elif xy < yx:
        return 1
    else:
        return 0

def greatest(arr):
    arr = sorted(arr, key = functools.cmp_to_key(fun))
    arr = [str(i) for i in arr]
    return ''.join(arr).lstrip('0')


if __name__ == "__main__":
    arr = list(map(int,input().split()))
    print(greatest(arr))

