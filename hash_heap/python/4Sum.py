# Time: O(n ^ 2)
# Space: O(n)

def four_sum(nums, target):
    sum_dict = {}
    n = len(nums)
    for i in range(n - 1):
        for j in range(i + 1, n):
            s = nums[i] + nums[j]
            if sum_dict.get(target - s, None):
                return sum_dict[target - s][0], sum_dict[target - s][1], i, j
            sum_dict[s] = [i, j]

def four_sum_all_combinations(nums, target):
    sum_dict = {}
    n = len(nums)
    res = set()
    for i in range(n - 1):
        for j in range(i + 1, n):
            s = nums[i] + nums[j]
            v = target - s
            for x, y in sum_dict.setdefault(v, []):
                if i == x or i == y or j == x or j == y:    continue
                res.add(tuple(sorted([nums[x], nums[y], nums[i], nums[j]])))
            sum_dict.setdefault(s, []).append([i, j])
    return res

if __name__=='__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 8]
    k = 19
    indexes = four_sum(arr, k)
    if indexes:
        print(arr[indexes[0]], arr[indexes[1]], arr[indexes[2]], arr[indexes[3]])