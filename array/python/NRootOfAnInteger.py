def multiply(number, n):
    ans = 1.0
    for i in range(1,n+1):
        ans*=number
    return ans

def get_nth_root(n,m):
    low,high = 1,m
    eps = 1e-6

    while((high-low)>eps):
        mid = (low+high)/2.0
        if (multiply(mid,n)<m):
            low = mid
        else:
            high = mid
    
    return low

n, m = 3, 27

root = get_nth_root(n,m)

print("Root: ",root)