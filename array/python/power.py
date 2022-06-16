def power(x, n):
    if x == 0:
        return 0
    if n == 0:
        return 1
    return x * power(x, n - 1)



print(power(2,2))