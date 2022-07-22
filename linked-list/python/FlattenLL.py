# Time: O(n) -> n: number of nodes in the entire list
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = self.down = None

def display(node):
    while node:
        print(node.val, end = ' -> ')
        node = node.down
    print('X')

def merge_two_sorted_ll(head1, head2):
    head1.next = None
    if head1.val < head2.val:
        head = ptr = head1
        first, second = head1.down, head2
    else:
        head = ptr = head2
        first, second = head1, head2.down
    while first or second:
        if not first:
            ptr.down = second
            return head
        if not second:
            ptr.down = first
            return head
        if first.val < second.val:
            ptr.down = first
            ptr = first
            first = first.down
        else:
            ptr.down = second
            ptr = second
            second = second.down
    return head

def flatten_ll(head):
    if not head or not head.next:
        return head
    head.next = flatten_ll(head.next)
    head = merge_two_sorted_ll(head, head.next)
    return head

if __name__=='__main__':
    node = Node(4)
    node.down = Node(6)
    node.down.down = Node(7)
    node.down.down.down = Node(30)
    node.next = Node(11)
    node.next.down = Node(20)
    node.next.next = Node(18)
    node.next.next.down = Node(22)
    node.next.next.down.down = Node(50)
    node.next.next.next = Node(28)
    node.next.next.next.down = Node(35)
    node.next.next.next.down.down = Node(40)
    node.next.next.next.down.down.down = Node(45)
    node = flatten_ll(node)
    display(node)