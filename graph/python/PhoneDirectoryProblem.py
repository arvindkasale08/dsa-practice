class TrieNode:
	def __init__(self):
		self.isEnd = False
		self.children = {}

def insertContact(string, root):
	n = len(string)
	itr = root

	for i in range(n):
		if string[i] not in itr.children:
			itr.children[string[i]] = TrieNode()

		next = itr.children[string[i]]
		itr = next
		if (i == n - 1):
			itr.isEnd = True
	
def viewSuggestionsHelper(curr, prefix, temp):

	if (curr.isEnd == True):
		temp.append(prefix)
	c = ord('a')
	while c <= ord('z'):
		if chr(c) in curr.children:
			next = curr.children[chr(c)]
			viewSuggestionsHelper(next, prefix + chr(c), temp)
		c += 1


def viewSuggestions(string, root):
	
	prev = root

	prefix = ""

	n = len(string)

	result = []

	i = 0
	while i < n:
		
		prefix += string[i]

		lastCharacter = prefix[i]
		if lastCharacter not in prev.children:
			i += 1
			break
		curr = prev.children[lastCharacter]
		
		temp = []

		viewSuggestionsHelper(curr, prefix, temp)
		
		result.append(temp)
		prev = curr
		
		i += 1
	
	return result


def insertContactList(contactList, root):

	n = len(contactList)
	for i in range(n):
		insertContact(contactList[i], root)

def phoneDirectory(contactList, queryStr):

	root = TrieNode()

	insertContactList(contactList, root)
	return viewSuggestions(queryStr, root)
	
res = (phoneDirectory(["gforgeeks", "geeksquiz"], "gekk"))
print(res)