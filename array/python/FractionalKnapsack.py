# Time: O(nlog(n))
# Space: O(1)

class Item:
	def __init__(self, value, weight):
		self.value = value
		self.weight = weight

def fractionalknapsack(W, Items, n):
    def compare(x):
        return x.value / x.weight
    Items.sort(key = compare, reverse = True)
    profit = 0
    for i in range(n):
        if (W >= Items[i].weight):
            W -= Items[i].weight
            profit += Items[i].value
        else:
            profit += (W / Items[i].weight) * Items[i].value
            break
    return profit

if __name__=='__main__':
	test_cases = [[3, 50, [60, 100, 120], [10, 20, 30]],
				  [2, 50, [60, 100], [10, 20]]]
	for n, allowed_weight, values, weight in test_cases:
		Items = []
		for i in range(n):
			Items.append(Item(values[i], weight[i]))
		print(fractionalknapsack(allowed_weight, Items, n))