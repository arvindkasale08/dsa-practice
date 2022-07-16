# Time: O(nlogn)
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

def find_middle(node):
    slow = fast = node
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    return slow

def merge_two_sorted_ll(first, second):
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

def sort_ll(head):
    if not head or not head.next:
        return head
    mid = find_middle(head)
    first = head
    second = mid.next
    mid.next = None
    first = sort_ll(head)
    second = sort_ll(second)
    head = merge_two_sorted_ll(first, second)
    return head

if __name__=='__main__':
    head = Node(4)
    head.next = Node(2)
    head.next.next = Node(7)
    head.next.next.next = Node(3)
    head.next.next.next.next = Node(6)
    head.next.next.next.next.next = Node(5)
    head.next.next.next.next.next.next = Node(1)
    head.next.next.next.next.next.next.next = Node(8)
    
#     node2 = Node(1)
#     node2.next = Node(3)
#     node2.next.next = Node(6)
#     node2.next.next.next = Node(7)
    
    node = sort_ll(head)
    display(node)