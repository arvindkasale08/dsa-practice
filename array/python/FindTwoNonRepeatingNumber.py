# Time: O(n)
# Space: O(1)

def find_two_unique_elements(arr):
    unique = arr[0]
    for i in range(1, len(arr)):
        unique ^= arr[i]
    most_right_bit = unique & (~(unique - 1))
    a = b = 0
    for i in range(len(arr)):
        if arr[i] & most_right_bit:
            a ^= arr[i]
        else:
            b ^= arr[i]
    return a, b

if __name__=='__main__':
    tc = [[2,4,7,9,2,4],
          [4,5,4,5,3,2,9,3,9,8]]
    for t in tc:
        print(find_two_unique_elements(t))