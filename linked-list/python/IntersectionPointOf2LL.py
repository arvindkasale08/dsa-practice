# Time: O(m + n)
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

def intersect_point(head1, head2):
    ptr1, ptr2 = head1, head2
    while ptr1 != ptr2:
        if not ptr1:
            ptr1 = head2
        else:
            ptr1 = ptr1.next
        if not ptr2:
            ptr2 = head1
        else:
            ptr2 = ptr2.next
    return ptr1

if __name__=='__main__':
    headA = Node(4)
    headB = Node(5)
    headA.next = Node(7)
    headA.next.next = Node(9)
    headB.next = headA.next

#     headA = Node(4)
#     headB = Node(5)
#     headA.next = Node(7)
#     headA.next.next = Node(9)
#     headB.next = Node(17)
#     headB.next.next = Node(18)
    
    node = intersect_point(headA, headB)
    if node:    print(node.val)
    else:    print(-1)