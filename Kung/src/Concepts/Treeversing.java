package Concepts;

public class Treeversing {

	Treeversing left,right;
	static Treeversing ten = new Treeversing(10);
	int data;
	
	public Treeversing(int data) {
		this.data=data;
	}
	
	public void add(int value) {
		if(value <= data) {
			if(left==null) {
				left = new Treeversing(value);
			}else {
				//if the root's left is there
				// do add() with root's left
				//to add left's left
				left.add(value);
			}
		}else {
			if(right==null) {
				right = new Treeversing(value);
			} else {
				right.add(value);
			}
		}
	}
	
//	public boolean contains(int value) {
//		if(value == data) {
//			return true;
//		} else if (value < data) {
//			if(left==null) {
//				return false;
//			} else {
//				return left.contains(value);
//			}
//		} else {
//			if(right==null) {
//				return false;
//			} else {
//				return right.contains(value);
//			}
//		}
//	}
	
	public void print() {
	
		if(left != null) {//if the left of the root is not empty, print()
			//if the root's left's left root is null, skip it
			//and do the sys out
			left.print();
		}
		//this prints 2 values because the root's left is on top of the 
		//stack and the root is at the bottom then it triggeres the 
		//right side of the root
		System.out.println(data);
		
		if(right != null) {
			right.print();
		}
	}
	
	public static void main(String[] args) {
		ten.add(21);
		ten.add(22);
		ten.add(1);
		ten.add(9);
		ten.add(13);
		ten.print();
	}
	
	
}
