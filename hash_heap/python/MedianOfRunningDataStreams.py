# Time: O(logn) for each addNum query; O(1) for findMedian
# Space: O(n)

from heapq import heappush, heappop

class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.max_heap, self.min_heap = [], []
        self.max = self.min = 0

    def addNum(self, num: int) -> None:
        if not self.max and not self.min:
            self.min_heap.append(num)
            self.min += 1
            return
        if not self.max and self.min:
            if num < self.min_heap[0]:
                self.max_heap.append(-num)
            else:
                val = self.min_heap.pop()
                self.max_heap.append(-val)
                self.min_heap.append(num)
            self.max += 1
            return
        if num < -self.max_heap[0]:
            heappush(self.max_heap, -num)
            self.max += 1
            if self.max - self.min > 1:
                heappush(self.min_heap, -heappop(self.max_heap))
                self.max -= 1
                self.min += 1
        else:
            heappush(self.min_heap, num)
            self.min += 1
            if self.min - self.max > 1:
                heappush(self.max_heap, -heappop(self.min_heap))
                self.max += 1
                self.min -= 1

    def findMedian(self) -> float:
#         print(self.max_heap, self.min_heap, self.max, self.min)
        if self.max == self.min:    return (self.min_heap[0] - self.max_heap[0]) / 2
        if self.max > self.min:    return -self.max_heap[0]
        return self.min_heap[0]


if __name__=='__main__':
    mf = MedianFinder()
    mf.addNum(12)
    mf.addNum(4)
    result = mf.findMedian()
    print(result)
    mf.addNum(5)
    result = mf.findMedian()
    print(result)
    mf.addNum(5)
    mf.addNum(8)
    result = mf.findMedian()
    print(result)