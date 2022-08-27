# Time: O(1) for each query; overall O(n) for stream of length n
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.prev = self.next = None

def first_non_repeating_char(stream):
    res = ''
    head = tail = None
    ascii_word = [0] * 256
    for c in stream:
        if ascii_word[ord(c)] == -1:    pass
        elif ascii_word[ord(c)]:
            ptr = ascii_word[ord(c)]
            if ptr == head:
                head = head.next
            elif ptr == tail:
                tail = tail.prev
                tail.next = None
            else:
                ptr.prev.next = ptr.next
                ptr.next.prev = ptr.prev
            ptr = None
            ascii_word[ord(c)] = -1
        else:
            if not head:
                head = tail = Node(c)
            else:
                tail.next = Node(c)
                tail.next.prev = tail
                tail = tail.next
            ascii_word[ord(c)] = tail
        res += head.val if head else '#'
    return res

if __name__=='__main__':
    print(first_non_repeating_char("wcjohjkzfdwjjozlfwgngbhtvmmopmodsoruilzuujqzjajkevdnatogakqtbridzhlxlzckaijyghieuehygpogeetyvbudjminkrsgmxxsyypeldurzznzzxtpchwgrigvebfmxoaqbkxukvqgdtvulniqmdyrdgvkmsanktmmcddhpktcwhfzvxfvpshjyriltmrevgwzmoaudrvldtgmwpadajgciaykxipeuzdgidtosakczbyxudwyowevqetdirexwrtlophzgysvxfuncgcwxnjiairchvucgejnltgitbwamrplyeaqvnelhkboidpgewvmursxxdryvlmcmhqmaaatsgsoimvdasuamtxasaqlkeungveyyfxuzujyhbavynxfiunkozawzcnticvxlrzewxzbazdwuwygigjwaglyxisjcutseyfmkubueamjpwvhowfamewevgiivmolfxrfrmakrtfwqauysvwckarm"))