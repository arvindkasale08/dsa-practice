# Time: O(m + n + plogp) where m -> len(nums), n -> len(order), p -> Elements not present in order but are there in nums
# Space: O(n + p)

def relative_sorting(nums, order):
    nums_dict = {}
    r = []
    i = 0
    for num in nums:
        nums_dict.setdefault(num, 0)
        nums_dict[num] += 1
    for num in order:
        while nums_dict.get(num, 0):
            nums[i] = num
            i += 1
            nums_dict[num] -= 1
    for num in nums_dict:
        while nums_dict[num]:
            r.append(num)
            nums_dict[num] -= 1
    r.sort()
    for num in r:
        nums[i] = num
        i += 1

if __name__ == '__main__':
 
    first = [5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4]
    second = [3, 5, 7, 2]
 
    relative_sorting(first, second)
    print("After sorting the list is:", first)