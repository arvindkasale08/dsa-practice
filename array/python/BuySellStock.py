def maxProfit(nums):
    buy, profit = nums[0], 0
    for i in range(1, len(nums)):
        if nums[i] < nums[i - 1]:
            profit += nums[i - 1] - buy
            buy = nums[i]
    return profit + nums[-1] - buy

if __name__=='__main__':
    test_cases = [[7,1,5,3,6,4],
                  [1,2,3,4,5],
                  [7,6,4,3,1]]
    for tc in test_cases:
        print(maxProfit(tc))