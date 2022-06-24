def jumpGame(nums):
    if len(nums) == 1:	return 0
    a = b = nums[0]
    jumps = 0
    for i in range(1, len(nums)):
        a -= 1
        b -= 1
        b = max(b, nums[i])
        if not a:
            jumps += 1
            if not b:   return -1
            a = b
            if i == len(nums) - 1:	return jumps
    return jumps + 1

if __name__=='__main__':
    test_cases = [[2,3,1,1,4],
                  [2,3,0,1,4],
                  [1,3,2],
                  [2,3,1],
                  [0],
                  [1],
                  [1,2],
                  [5,9,3,2,1,0,2,3,3,1,0,0]]
    for tc in test_cases:
        print(jumpGame(tc))