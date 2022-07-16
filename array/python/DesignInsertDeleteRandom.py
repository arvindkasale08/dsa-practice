# Time: O(1)
# Space: O(n)

from random import randint

class randomized_set:
    def __init__(self):
        self.nums = []
        self.hashMap = {}
        self.n = 0
    
    def insert(self, val):
        if self.hashMap.get(val, None):
            return False
        self.nums.append(val)
        self.n += 1
        self.hashMap[val] = self.n
        return True
    
    def delete(self, val):
        if not self.hashMap.get(val, None):
            return False
        i = self.hashMap[val] - 1
        self.nums[i], self.nums[-1] = self.nums[-1], self.nums[i]
        self.hashMap[self.nums[i]] = i + 1
        self.nums.pop()
        del self.hashMap[val]
        self.n -= 1
        return True
    
    def search(self, val):
        if self.hashMap.get(val, None):
            return False
        return self.hashMap[val] - 1
    
    def get_random(self):
        return self.nums[randint(0, self.n - 1)]


if __name__=='__main__':
    ob = randomized_set()
    #insert value into the Data structure
    print(ob.insert(1))
    print(ob.delete(2))
    print(ob.insert(2))
    print(ob.get_random())
    print(ob.delete(1))
    print(ob.insert(2))
    print(ob.get_random())