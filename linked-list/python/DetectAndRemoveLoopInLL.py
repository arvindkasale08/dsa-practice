class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def detect_remove_loop(head):
    slow_node = head
    fast_node = head
    flag = 0
    while fast_node and fast_node.next:
        slow_node = slow_node.next
        fast_node = fast_node.next.next
        if slow_node == fast_node:
            print('Loop Detected!')
            print('Now removing loop.')
            flag = 1
            break
    if flag == 1:
        slow_node = head
        while slow_node.next != fast_node.next:
            slow_node = slow_node.next
            fast_node = fast_node.next
        # Loop Removed
        fast_node.next = None
    else:
        print('\n\nNo loops detected!')
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
    # Loop Creation
    head.next.next.next.next.next.next.next.next = head.next.next.next
    head = detect_remove_loop(head)
    while head:
        print(head.val, end = ' -> ')
        head = head.next
    print('X')