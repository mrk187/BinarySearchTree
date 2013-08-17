package alda.tree;

/**
 * Denna klass representerar ett binŠrt sšktrŠd. Ni fŒr inte Šndra *NGOT* i
 * denna klass. Alla Šndringar som krŠvs fšr att klassen ska fungera ska gšras i
 * BinarySearchTreeNode.
 * 
 * @author henrikbe
 * 
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BinarySearchTreeNode<T> root;

	public boolean add(T data) {
		if (root == null) {
			root = new BinarySearchTreeNode<T>(data);
			return true;
		} else {
			return root.add(data);
		}
	}

	public boolean remove(T data) {
		int originalSize=size();
		if (root != null)
			root = root.remove(data);
		return size()<originalSize;
	}

	public boolean contains(T data) {
		return root == null ? false : root.contains(data);
	}

	public void clear() {
		root = null;
	}

	public int size() {
		if (root == null)
			return 0;
		else
			return root.size();
	}

	public int depth() {
		if (root == null)
			return -1;
		else
			return root.depth();
	}

	public String toString() {
		return "[" + (root == null ? "" : root.toString()) + "]";
	}

}
