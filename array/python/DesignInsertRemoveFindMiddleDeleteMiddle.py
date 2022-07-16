# Assignment - Design a data Structure which support Insert delete, Random in O(1) time

class DLL:
    def __init__(self, val):
        self.val = val
        self.prev = self.next = None

class ModifiedStack:
    def __init__(self):
        self.head = self.tail = self.middle = None
        self.count = 0
    
    def push(self, val):
        if not self.tail:
            self.head = self.tail = self.middle = DLL(val)
            self.count = 1
        else:
            node = DLL(val)
            self.tail.next = node
            node.prev = self.tail
            self.tail = node
            self.count += 1
            if self.count % 2:
                self.middle = self.middle.next
    
    def pop(self):
        if not self.head:
            return False
        node = self.tail.prev
        node.next = None
        self.tail = node
        self.count -= 1
        if self.count % 2 == 0:
            self.middle = self.middle.prev
        return True
    
    def find_middle(self):
        return self.middle.val if self.middle else -1
    
    def delete_middle(self):
#         1 -> 2 -> 3 -> 4 -> 5 -> 6 -> X
        node = self.middle
        self.middle = self.middle.prev
        self.middle.next = node.next
        node.next.prev = node.prev
        node = None
        self.count -= 1
        if self.count % 2:
            self.middle = self.middle.next
        return True

if __name__=='__main__':
    ms = ModifiedStack()
    ms.push(11)
    ms.push(22)
    ms.push(33)
    ms.push(44)
    ms.push(55)
    ms.push(66)
    ms.push(77)
    print(ms.find_middle())
    print(ms.pop())
    print(ms.find_middle())
    print(ms.pop())
    print(ms.find_middle())
    ms.delete_middle()
    print(ms.find_middle())