import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Deduplicate {
	
	public static class Contact {
		
		String		name;
		
		Set<String>	emails;
		
		public Contact(String name) {
		
			this.name = name;
			emails = new HashSet<String>();
		}
		
		public void addEmail(String email) {
		
			emails.add(email);
		}
		
		public String getName() {
		
			return name;
		}
		
		public Set<String> getEmails() {
		
			return emails;
		}
		
		@Override
		public String toString() {
		
			return name;
		}
		
		@Override
		public int hashCode() {
		
			return name.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
		
			if (obj instanceof Contact)
			{
				Contact other = (Contact) obj;
				return other.name.equals(name);
			}
			return false;
		}
		
	}
	
	public static class UnionNode<T> {
		
		T			value;
		
		UnionNode<T>	parent;
		
		int			rank;
		
		public UnionNode(T value) {
		
			this.value = value;
			this.parent = null;
			this.rank = 0;
		}
		
		public UnionNode<T> find() {
		
			UnionNode<T> node = this;
			while (node.parent != null)
			{
				if (node.parent.parent != null)
				{
					node.parent = node.parent.parent;
				}
				node = node.parent;
			}
			
			return node;
		}
		
		public void union(UnionNode<T> node) {
		
			UnionNode<T> root = this.find();
			UnionNode<T> otherRoot = node.find();
			
			if (root.rank < otherRoot.rank)
			{
				root.parent = otherRoot;
			}
			else
			{
				otherRoot.parent = root;
				if (root.rank == otherRoot.rank)
				{
					++root.rank;
				}
			}
		}
	}
	
	public List<List<String>> deduplicate(List<Contact> contacts) {
	
		Map<String, UnionNode<Contact>> emailIdx = new HashMap<String, UnionNode<Contact>>();
		List<UnionNode<Contact>> nodes = new ArrayList<UnionNode<Contact>>();
		
		for (Contact contact : contacts)
		{
			UnionNode<Contact> node = new UnionNode<Contact>(contact);
			nodes.add(node);
			
			for (String email : contact.getEmails())
			{
				UnionNode<Contact> contactNode = emailIdx.get(email);
				if (contactNode != null)
				{
					contactNode.union(node);
				}
				else
				{
					emailIdx.put(email, node);
				}
			}
		}
		
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		for (UnionNode<Contact> node : nodes)
		{
			UnionNode<Contact> root = node.find();
			List<String> list = res.get(root.value.getName());
			if (list == null)
			{
				list = new ArrayList<String>();
			}
			list.add(node.value.getName());
			res.put(root.value.getName(), list);
		}
		
		return new ArrayList<List<String>>(res.values());
	}
	
}
