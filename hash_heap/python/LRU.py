class Node:
    def __init__(self, key, val, prev = None, n_next = None):
        self.key = key
        self.val = val
        self.prev, self.next = prev, n_next

class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.hashMap = {}
        self.head = self.tail = None
    
    def update(self, node):
        if node == self.tail:    return
        node.next.prev = node.prev
        if node == self.head:    self.head = node.next
        else:    node.prev.next = node.next
        self.tail.next = node
        node.prev = self.tail
        node.next = None
        self.tail = node
    
    def put(self, key, value):
        if not self.hashMap.get(key, None):
            if not self.head:
                self.head = self.tail = Node(key, value)
            else:
                if self.capacity <= 1:
                    self.hashMap[self.head.key] = None
                    self.head = self.head.next
                    if self.head:   self.head.prev = None
                    else:   self.tail = None
                if not self.tail:   self.head = self.tail = Node(key, value)
                else:
                    self.tail.next = Node(key, value, self.tail, None)
                    self.tail = self.tail.next
                    self.capacity -= 1
            self.hashMap[key] = self.tail
        else:
            node = self.hashMap[key]
            node.val = value
            self.update(node)
    
    def get(self, key):
        if not self.hashMap.get(key, None):    return -1
        node = self.hashMap[key]
        self.update(node)
        return node.val


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)