
    
import java.util.Stack;


public class  order {
	int data;
	order left, right;

	public order(int item)
	{
		data = item;
		left = right = null;
	}
}


class BinaryTree {
	order root;
	void inorder()
	{
		if (root == null)
			return;

		Stack<order> s = new Stack<order>();
		order curr = root;

		
		while (curr != null || s.size() > 0) {

		
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}

			curr = s.pop();

			System.out.print(curr.data + " ");

		
			curr = curr.right;
		}
	}

	public static void main(String args[])
	{

		BinaryTree tree = new BinaryTree();
		tree.root = new order(1);
		tree.root.left = new order(2);
		tree.root.right = new order(3);
		tree.root.left.left = new order(4);
		tree.root.left.right = new order(5);
		tree.inorder();
	}
}
