# Time: O(n)
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def display(node):
    while node:
        print(node.val, end = ' -> ')
        node = node.next
    print('X')

def merge_sorted_ll(head1, head2):
    first, second = head1, head2
    if first.val < second.val:
        head = ptr = first
        first = first.next
    else:
        head = ptr = second
        second = second.next
    while first or second:
        if not first:
            ptr.next = second
            return head
        if not second:
            ptr.next = first
            return head
        if first.val < second.val:
            ptr.next = first
            ptr = first
            first = first.next
        else:
            ptr.next = second
            ptr = second
            second = second.next
    return head

if __name__=='__main__':
    node1 = Node(2)
    node1.next = Node(4)
    node1.next.next = Node(5)
    node1.next.next.next = Node(8)
    
    node2 = Node(1)
    node2.next = Node(3)
    node2.next.next = Node(6)
    node2.next.next.next = Node(7)
    
    node = merge_sorted_ll(node1, node2)
    display(node)