class Node:
    def __init__(self, key, val, prev = None, n_next = None):
        self.key = key
        self.val = val
        self.prev = prev
        self.next = n_next

class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.last = {}
        self.cache = {}
        self.head = self.tail = None
        self.corner = True if not capacity else False
    
    def update(self, key, value):
        node, count = self.cache[key]
        node.val = value
        if self.last[count] == node:
            if node.prev:
                if self.cache.get(node.prev.key, None) and self.cache[node.prev.key][1] == count:
                    self.last[count] = node.prev
                else:   self.last[count] = None
            else:   self.last[count] = None
        if node.prev:   node.prev.next = node.next
        else:
            self.head = self.head.next
            if self.head:   self.head.prev = None
        if node.next:   node.next.prev = node.prev
        else:
            self.tail = self.tail.prev
            if self.tail:   self.tail.next = None
        count += 1
        self.cache[key][1] = count
        if self.last.get(count, None):
            ptr = self.last[count]
            node.next = ptr.next
            node.prev = ptr
            ptr.next = node
            if node.next:   node.next.prev = node
            else:
                node.next = None
                self.tail = node
        else:
            prev_count = count - 1
            while prev_count > 0 and not self.last.get(prev_count, None): prev_count -= 1
            if prev_count == 0:
                if not self.head:   self.head = self.tail = node
                else:
                    self.head.prev = node
                    node.next = self.head
                    self.head = node
            else:
                ptr = self.last[prev_count]
                node.next = ptr.next
                node.prev = ptr
                ptr.next = node
                if node.next:   node.next.prev = node
                else:
                    self.tail = node
        self.last[count] = node

    def get(self, key: int) -> int:
        if self.corner or not self.cache.get(key, None): return -1
        node, _ = self.cache[key]
        val = node.val
        self.update(key, val)
        return val

    def put(self, key: int, value: int) -> None:
        if self.corner: return
        if not self.cache.get(key, None):
            if not self.head:
                self.head = self.tail = Node(key, value)
                self.cache[key] = [self.head, 1]
                self.last[1] = self.head
            else:
                if self.capacity < 1:
                    node = self.head
                    count = self.cache[node.key][1]
                    if self.last[count] == node:
                        self.last[count] = None
                    self.cache[node.key] = []
                    self.head = self.head.next
                    if self.head:   self.head.prev = None
                if self.last[1]:
                    ptr = self.last[1]
                    node = Node(key, value, ptr, ptr.next)
                    ptr.next = node
                    if node.next:   node.next.prev = node
                    else:   self.tail = node
                else:
                    node = Node(key, value, None, self.head)
                    if self.head:   self.head.prev = node
                    self.head = node
                self.cache[key] = [node, 1]
                self.last[1] = node
            self.capacity -= 1
        else:
            self.update(key, value)


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)