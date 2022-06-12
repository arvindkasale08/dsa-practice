'''
Time Complexity: O(nLog(n))
Space Complexity: O(n) for Arrays, O(1) for Linked List
'''

def merge(nums, aux, low, mid, high):
	i = k = low
	j = mid + 1
	while (i <= mid and j <= high):
		if (nums[i] <= nums[j]):
			aux[k] = nums[i]
			i += 1
		else:
			aux[k] = nums[j]
			j += 1
		k += 1
	while (i <= mid):
		aux[k] = nums[i]
		i += 1
		k += 1
	while (j <= high):
		aux[k] = nums[j]
		j += 1
		k += 1
	for i in range(low, high + 1):
		nums[i] = aux[i]

def mergeSort(nums, aux, low, high):
	if (high <= low):
		return
	mid = (low + high) // 2
	mergeSort(nums, aux, low, mid)
	mergeSort(nums, aux, mid + 1, high)
	merge(nums, aux, low, mid, high)

if __name__=='__main__':
	test_cases = [[3,-2,0,1,8],
				  [-3, 98, -92, 28, 47],
				  [1],
				  []]
	for nums in test_cases:
		mergeSort(nums, list(nums), 0, len(nums) - 1)
		print(nums)