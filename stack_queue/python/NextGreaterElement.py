def nextGreaterElement(nums1, nums2):
    hashMap = {}
    res, stack = [], []
    n = len(nums2)
    for i in range(n - 1, -1, -1):
        while stack and stack[-1] <= nums2[i]:
            stack.pop()
        hashMap[nums2[i]] = -1 if not stack else stack[-1]
        stack.append(nums2[i])
    for i in nums1:
        res.append(hashMap[i])
    return res


if __name__=='__main__':
    test_cases = [[[4,1,2],[1,3,4,2]],
                  [[2,4],[1,2,3,4]]]
    for nums1, nums2 in test_cases:
        print(nextGreaterElement(nums1, nums2))