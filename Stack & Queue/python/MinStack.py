class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = float('-inf')

    def push(self, val: int) -> None:
        if not self.stack or val >= self.min:
            if not self.stack:    self.min = val
            self.stack.append(val)
        if val < self.min:
            self.stack.append(2 * val - self.min)
            self.min = val

    def pop(self) -> None:
        if self.stack[-1] < self.min:
            val = self.min
            self.min = 2 * self.min - self.stack.pop()
            return
        self.stack.pop()

    def top(self) -> int:
        if self.stack[-1] < self.min:
            return self.min
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min

if __name__=='__main__':
    stack = MinStack()
    stack.push(3)
    stack.push(5)
    print(stack.getMin())
    stack.push(2)
    stack.push(1)
    print(stack.getMin())
    stack.pop()
    print(stack.getMin())
    stack.pop()
    print(stack.top())