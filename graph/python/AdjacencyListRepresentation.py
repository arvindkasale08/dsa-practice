class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

class Graph:
    def __init__(self, n):
        self.n = n
        self.arr = [None] * n
    
    def add_edge(self, src, dest):
        if src > self.n - 1 or dest > self.n - 1:
            print('A maximum of', self.n, 'vertices are allowed')
        node = Node(dest)
        if self.arr[src]:
            ptr = self.arr[src]
            while ptr.next:
                ptr = ptr.next
            ptr.next = node
        else:
            self.arr[src] = node
        node = Node(src)
        if self.arr[dest]:
            ptr = self.arr[dest]
            while ptr.next:
                ptr = ptr.next
            ptr.next = node
        else:
            self.arr[dest] = node
    
    def display(self):
        for i in range(n):
            if self.arr[i]:
                ptr = self.arr[i]
                print(i, end = ': ')
                while ptr:
                    print(ptr.val, '->', end = ' ')
                    ptr = ptr.next
                print('X')
    
if __name__=='__main__':
    graph = Graph(5)
    graph.add_edge(0, 1)
    graph.add_edge(0, 4)
    graph.add_edge(1, 2)
    graph.add_edge(1, 3)
    graph.add_edge(1, 4)
    graph.add_edge(2, 3)
    graph.add_edge(3, 4)
    graph.display()