'''
Time Complexity: O(log(n))
Space Complexity: O(1)
Works only if:
	- Array is sorted
	- Array is in zig-zag fashion
	- Array is sorted and then rotated
'''

def binary_search_iterative(nums, target):
	low, high = 0, len(nums) - 1
	while low <= high:
		mid = (low + high) // 2
		if (nums[mid] == target):
			return mid
		elif (nums[mid] < target):
			low = mid + 1
		else:
			high = mid - 1
	return -1

def binary_search_recursive(nums, low, high, target):
	if low > high:	return -1
	mid = (low + high) // 2
	if (nums[mid] == target):
		return mid
	if (nums[mid] < target):
		return binary_search_recursive(nums, mid + 1, high, target)
	return binary_search_recursive(nums, low, mid - 1, target)

if __name__=='__main__':
	test_cases = [[[0,1,2,3,7,9], 9],
				  [[-4,-1,2,90,203,270], -4],
				  [[22,38,46,94,121],122]]
	for nums, target in test_cases:
		print(binary_search_iterative(nums, target))

	for nums, target in test_cases:
		print(binary_search_recursive(nums, 0, len(nums) - 1, target))