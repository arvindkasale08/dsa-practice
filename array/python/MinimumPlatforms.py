def minimumPlatform(arr, dep):
    arr.sort()
    dep.sort()
    cur_plat = max_plat = 1
    i = 1
    j = 0
    while  i < len(arr):
        if arr[i] > dep[j]:
            j += 1
            i += 1
        else:
            cur_plat += 1
            if cur_plat > max_plat:
                max_plat = cur_plat
            i += 1
    return max_plat

if __name__=='__main__':
    test_cases = [[[900, 940, 950, 1100, 1500, 1800], [910, 1200, 1120, 1130, 1900, 2000]],
                  [[900, 1100, 1235], [1000, 1200, 1240]]]
    for arrival, departure in test_cases:
        print(minimumPlatform(arrival, departure))