# Time: O(n)
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def check_palindrome(head):
    def find_middle(node):
        slow = fast = node
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def reverse(node):
        pre = None
        ptr = node
        while ptr:
            post = ptr.next
            ptr.next = pre
            pre = ptr
            ptr = post
        return pre
    
    mid = find_middle(head)
    first = head
    second = mid.next
    mid.next = None
    second = reverse(second)
    while second:
        if first.val != second.val:
            return False
        first = first.next
        second = second.next
    return True

if __name__=='__main__':
    node1 = Node(2)
    node1.next = Node(4)
    node1.next.next = Node(3)
    node1.next.next.next = Node(4)
    node1.next.next.next.next = Node(2)
    
    print(check_palindrome(node1))