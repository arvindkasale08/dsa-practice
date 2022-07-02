def minimumPlatform(arr, dept):
    arr.sort()
    dept.sort()
    i = j = plat = 0
    max_plat = 1
    m, n = len(arr), len(dept)
    while i < m and j < n:
        if arr[i] <= dept[j]:
            plat += 1
            i += 1
        else:
            plat -= 1
            j += 1
        max_plat = max(max_plat, plat)
    return max_plat

if __name__=='__main__':
    test_cases = [[[900, 940, 950, 1100, 1500, 1800], [910, 1200, 1120, 1130, 1900, 2000]],
                  [[900, 1100, 1235], [1000, 1200, 1240]]]
    for arrival, departure in test_cases:
        print(minimumPlatform(arrival, departure))