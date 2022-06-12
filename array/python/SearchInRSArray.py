# Time: O(log(n))
# Space: O(1)

def search_in_rs_array(nums, target):
    low, high = 0, len(nums) - 1
    while low <= high:
        mid = (low + high) // 2
        if nums[mid] == target:    return mid
        # left side is sorted
        if nums[low] <= nums[mid]:
            if target >= nums[low] and target < nums[mid]:    high = mid - 1
            else:    low = mid + 1
        else:
            if target > nums[mid] and target <= nums[high]:    low = mid + 1
            else:    high = mid - 1
    return -1

if __name__=='__main__':
    print(search_in_rs_array([4,5,6,7,0,1,2], 0))