# Time: O(n)
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def find_nth_from_last(head, n):
    ptr = head
    i = 0
    pre = head
    while ptr:
        if i >= n:
            pre = pre.next
        ptr = ptr.next
        i += 1
    return pre.val

if __name__=='__main__':
    node1 = Node(2)
    node1.next = Node(4)
    node1.next.next = Node(5)
    node1.next.next.next = Node(8)
    
    node2 = Node(1)
    node2.next = Node(3)
    node2.next.next = Node(6)
    node2.next.next.next = Node(7)
    
    print(find_nth_from_last(node1, 4))
    print(find_nth_from_last(node2, 1))