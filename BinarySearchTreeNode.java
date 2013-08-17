package alda.tree;


/**
 * Denna klass representerar noderna i ett bin�rt s�ktr�d utan dubletter.
 * 
 * Detta �r den enda av de tre klasserna ni ska g�ra n�gra �ndringar i. (Om ni
 * inte vill l�gga till fler testfall.) De �ndringar som �r till�tna �r dock
 * begr�nsade av f�ljande regler:
 * <ul>
 * <li>Ni f�r INTE l�gga till n�gra fler instansvariabler.
 * <li>Ni f�r INTE l�gga till n�gra statiska variabler.
 * <li>Ni f�r INTE anv�nda n�gra loopar n�gonstans.
 * <li>Ni F�R l�gga till fler metoder, dessa ska d� vara privata.
 * </ul>
 * 
 * @author henrikbe
 * 
 * @param <T>
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
	}

	/**
	 * L�gger till en nod i det bin�ra s�ktr�det. Om noden redan existerar s�
	 * l�mnas tr�det of�r�ndrat.
	 * 
	 * @param data
	 *            datat f�r noden som ska l�ggas till.
	 * @return true om en ny nod lades till tr�det.
	 */
	public boolean add(T data) {
		return add(data, this);
	}
	private boolean add(T data, BinarySearchTreeNode<T> node) {
		if(node==null)
			return false;
		
		if(data==node.data){
			return false;		
		}else{

			if(data.compareTo(node.data) < 0){
				if(node.left==null){
					node.left = new BinarySearchTreeNode<T>(data);
					return true;
				}
				return add(data, node.left);
			}
			else if(data.compareTo(node.data) > 0){
				if(node.right==null){
					node.right = new BinarySearchTreeNode<T>(data);
					return true;
				}
				return add(data, node.right);
			}else{}//lika gör inget


			return false;
		}
	}


	/**
	 * Privat hj�lpmetod som �r till nytta vid borttag. Ni beh�ver inte
	 * skriva/utnyttja denna metod om ni inte vill.
	 * 
	 * @return det minsta elementet i det (sub)tr�d som noden utg�r root i.
	 */
	private BinarySearchTreeNode<T> findMin(BinarySearchTreeNode<T> node) {
		if(node==null)
			return null;
		else if(node.left == null)
			return node;
		return findMin(node.left);
	}


	/**
	 * Tar bort ett element ur tr�det. Om elementet inte existerar s l�mnas
	 * tr�det of�r�ndrat.
	 * 
	 * @param data
	 *            elementet som ska tas bort ur tr�det.
	 * @return en referens till nodens subtr�d efter borttaget.
	 */
	public BinarySearchTreeNode<T> remove(T data) {
		return remove(data, this);
	}

	private BinarySearchTreeNode<T> remove(T data, BinarySearchTreeNode<T> node) {
		if(node==null)
			return null;
		

		if(data.compareTo(node.data) < 0){
			node.left = remove(data, node.left);
		}else if(data.compareTo(node.data) > 0){
			node.right = remove(data, node.right);
		}else if(node.left != null && node.right !=null){
			node.data = findMin(node.right).data;
			node.right = remove(node.data, node.right);
		}
		else
			if(node.left != null){
				node = node.left;
			}
			else
				node = node.right;

		return node;

	}

	/**
	 * Kontrollerar om ett givet element finns i det (sub)tr�d som noden utg�r
	 * root i.
	 * 
	 * @param data
	 *            det s�kta elementet.
	 * @return true om det s�kta elementet finns i det (sub)tr�d som noden utg�r
	 *         root i.
	 */
	public boolean contains(T data){
		return contains(data, this);
	}
	public boolean contains(T data, BinarySearchTreeNode<T> node) {
		if(node==null)
			return false;
		
		if(data==node.data)
			return true;
		
		if(data.compareTo(node.data)<0)
			return contains(data, node.left);
		else if(data.compareTo(node.data)>0)
			return contains(data, node.right);
		else
			return true;
	}

	/**
	 * Storleken p� det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return det totala antalet noder i det (sub)tr�d som noden utg�r root i.
	 */
	public int size() {
		return size(this);
	}

	private int size(BinarySearchTreeNode<T> node) {
		if(node==null){
			return 0;
		}else{
			return 1 + size(node.left) + size(node.right);
		}
	}

	/**
	 * Det h�gsta djupet i det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return djupet.
	 */
	public int depth() {
		return depth(this);
	}
	private int depth(BinarySearchTreeNode<T> node) {
		if(node==null)
			return -1;
		
		else
			return 1 + Math.max(depth(node.left), depth(node.right)); 
		/*int left = depth(node.left);
		int right = depth(node.right);

		if(left>right){
			return left+1;
		}else{
			return right +1;
		}*/
	}

	/**
	 * Returnerar en str�ngrepresentation f�r det (sub)tr�d som noden utg�r root
	 * i. Denna representation best�r av elementens dataobjekt i sorterad
	 * ordning med ", " mellan elementen.
	 * 
	 * @return str�ngrepresentationen f�r det (sub)tr�d som noden utg�r root i.
	 */
	private String toString(BinarySearchTreeNode<T> node){
		if(node==null)
			return "";

		return toString(node.left) + node.data+ ", " + toString(node.right);
	}
	public String toString(){
		String str = toString(this);
		str = str.substring(0, str.length() -2);
		return str;
	}
}
