import functools 
def fun(x, y):
    if x+y > y+x:
        return -1
    elif x+y < y+x:
        return 1
    else:
        return 0

def greatest(arr):
    arr = [str(i) for i in arr]
    arr = sorted(arr, key = functools.cmp_to_key(fun))
    return ''.join(arr).lstrip('0')


if __name__ == "__main__":
    arr = list(map(int,input().split()))
    print(greatest(arr))

