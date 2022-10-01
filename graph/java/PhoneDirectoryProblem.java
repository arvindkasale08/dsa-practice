import java.util.*;

class PhNode {
    HashMap<Character,PhNode> child;
    boolean isLast;

    public PhNode()
    {
        child = new HashMap<Character,PhNode>();

        for (char i = 'a'; i <= 'z'; i++)
            child.put(i,null);

        isLast = false;
    }
}

class PhTrie
{
    PhNode root;


    public void insertIntoPhTrie(String contacts[])
    {
        root = new PhNode();
        int n = contacts.length;
        for (int i = 0; i < n; i++)
        {
            insert(contacts[i]);
        }
    }

    public void insert(String s)
    {
        int len = s.length();
        PhNode itr = root;
        for (int i = 0; i < len; i++) {

            PhNode nextNode = itr.child.get(s.charAt(i));
            if (nextNode == null) {

                nextNode = new PhNode();

                itr.child.put(s.charAt(i),nextNode);
            }

            itr = nextNode;
            if (i == len - 1)
                itr.isLast = true;
        }
    }
    public void displayContactsUtil(PhNode curNode, String prefix) {

        if (curNode.isLast)
            System.out.println(prefix);
        for (char i = 'a'; i <= 'z'; i++)
        {
            PhNode nextNode = curNode.child.get(i);
            if (nextNode != null)
            {
                displayContactsUtil(nextNode, prefix + i);
            }
        }
    }

    void displayContacts(String str)
    {
        PhNode prevNode = root;

        String prefix = "";
        int len = str.length();
        int i;
        for (i = 0; i < len; i++) {
            prefix += str.charAt(i);
            char lastChar = prefix.charAt(i);
            PhNode curNode = prevNode.child.get(lastChar);
            if (curNode == null)
            {
                System.out.println("No Results Found for" + " " + prefix);
				i++;
				break;
			}

			System.out.println("Suggestions based on" + " " + prefix);
			displayContactsUtil(curNode, prefix);
			prevNode = curNode;
		}

		for ( ; i < len; i++)
		{
			prefix += str.charAt(i);
			System.out.println("No Results Found");
            }
        }
    }

    class PMain
    {
        public static void main(String args[])
        {
            PhTrie PhTrie = new PhTrie();

            String contacts [] = {"gforgeeks", "geeksquiz"};

            PhTrie.insertIntoPhTrie(contacts);

            String query = "gekk";
            PhTrie.displayContacts(query);
        }
    }
