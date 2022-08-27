# Time: O(n)
# Space: O(n)

from collections import deque

def max_k_subarray(nums, k):
    res, queue = [], deque()
    for i in range(k):
        while queue and nums[queue[-1]] <= nums[i]:    queue.pop()
        queue.append(i)
    for i in range(k, len(nums)):
        res.append(nums[queue[0]])
        while queue and (queue[0] + k <= i):    queue.popleft()
        while queue and nums[queue[-1]] <= nums[i]:    queue.pop()
        queue.append(i)
    res.append(nums[queue[0]])
    return res

if __name__=='__main__':
    tc = [[[1, 2, 3, 1, 4, 5, 2, 3, 6], 3],
          [[8, 5, 10, 7, 9, 4, 15, 12, 90, 13], 4],
          [[8, 6, 10, 7, 5, 17, 14, 87, 15], 3]]
    for nums, k in tc:
        print(max_k_subarray(nums, k))