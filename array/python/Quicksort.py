'''
Time Complexity: O(nLog(n))
Space Complexity: O(n) for Arrays, O(1) for Linked List
'''

def partition(nums, low, high):
	pivot = nums[high]
	i = low - 1
	for j in range(low, high):
		if nums[j] <= pivot:
			i += 1
			nums[i], nums[j] = nums[j], nums[i]
	nums[i + 1], nums[high] = nums[high], nums[i + 1]
	return i + 1


def quicksort(nums, low, high):
	if (low >= high):	return
	pivot = partition(nums, low, high)
	quicksort(nums, low, pivot - 1)
	quicksort(nums, pivot + 1, high)

if __name__=='__main__':
	test_cases = [[3,-2,0,1,8],
				  [-3, 98, -92, 28, 47],
				  [1],
				  []]
	for nums in test_cases:
		quicksort(nums, 0, len(nums) - 1)
		print(nums)