# Time: O(n)
# Space: O(1)

def find_unique_element(arr):
    unique = arr[0]
    for i in range(1, len(arr)):
        unique ^= arr[i]
    return unique

if __name__=='__main__':
    tc = [[6,2,4,3,4,2,3],
          [-1,2,-1,3,2],
          [9,4,9,6,4]]
    for t in tc:
        print(find_unique_element(t))