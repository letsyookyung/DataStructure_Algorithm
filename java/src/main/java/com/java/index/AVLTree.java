package com.java.index;

public class AVLTree implements IndexInterface<AVLNode> {
	private AVLNode root;
	static final AVLNode NIL = new AVLNode(null, null, null, 0);

	public AVLTree() {
		root = NIL;
	}


	public static void main(String[] args) {
		AVLTree avltree = new AVLTree();

		avltree.insert(12);
		avltree.insert(10);
		avltree.insert(13);
		avltree.insert(8);
		avltree.insert(4);
		avltree.insert(9);
		avltree.insert(5);
		avltree.insert(6);
		avltree.insert(7);

		avltree.delete(10);

	}


	@Override
	public AVLNode search(Comparable searchItem) {
		return searchItem(root, searchItem); //private root로 접근하기 위해서는 내부에서 부르게
	}


	private AVLNode searchItem(AVLNode tNode, Comparable searchItem) {
		if (tNode == NIL) {
			return NIL;
		} else if (searchItem.compareTo(tNode.item) == 0) {
			return tNode;
		} else if (searchItem.compareTo(tNode.item) < 0) {
			return searchItem(tNode.left, searchItem);
		} else {
			return searchItem(tNode.right, searchItem);
		}
	}


	public void insert(Comparable newItem) {
		root = insertItem(root, newItem); //재귀적으로 그 전의 tNode 리턴해서 root는 초기 루트로 있음
	}


	private AVLNode insertItem(AVLNode tNode, Comparable newItem) {
		if (tNode == NIL) {
			tNode = new AVLNode(newItem);
		} else if (newItem.compareTo(tNode.item) < 0) { // 처음 왼쪽 브랜치로 이동 -> 재귀 돌면서 여기로 왔다가
			tNode.left = insertItem(tNode.left, newItem); // 마지막이 여기에서 끝날 수도 있고,
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height); // 삽입 완료 후 LL/LR/RR/RL 타입하기 위해
			int type = needBalance(tNode);
			if (type != NO_NEED) { // 균형 수선이 필요하면
				tNode = balanceAVL(tNode, type);
			}
		} else { // 처음 오른쪽 브랜치로 이동 -> 재귀 돌면서 저기로 갔다가
			tNode.right = insertItem(tNode.right, newItem); // 마지막이 여기에서 끝날 수도 있고,
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height); // 삽입 완료 후 LL/LR/RR/RL 타입하기 위해
			int type = needBalance(tNode);
			if (type != NO_NEED) { // 균형 수선이 필요하면
				tNode = balanceAVL(tNode, type);
			}
		}
		return tNode;
	}


	@Override
	public void delete(Comparable deleteItem) {
		root = deleteItem(root, deleteItem);
	}


	private AVLNode deleteItem(AVLNode tNode, Comparable deleteItem) {
		if (tNode == NIL) {
			return NIL;
		} else if (deleteItem.compareTo(tNode.item) == 0) {
			tNode = deleteNode(tNode); // return이 null이 된 상태로 오고, 현재의 tNode == null 이 되서 삭제됨
		} else if (deleteItem.compareTo(tNode.item) < 0) {
			tNode.left = deleteItem(tNode.left, deleteItem);
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
			int type = needBalance(tNode);
			if (type != NO_NEED) {
				tNode = balanceAVL(tNode, type);
			}
		} else {
			tNode.right = deleteItem(tNode.right, deleteItem);
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
			int type = needBalance(tNode);
			if (type != NO_NEED) {
				tNode = balanceAVL(tNode, type);
			}
		}
		return tNode;
	}


	private AVLNode deleteNode(AVLNode tNode) {
		/*
		3가지 case
		1. tNode이 리프 노드 (자식 0개)
		2. tNode의 자식 1개
		3. tNode의 자식 2개
		 */
		if ((tNode.right == NIL) && (tNode.left == NIL)) { // case 1
			return NIL;
		} else if ((tNode.left == NIL)) { // case 2
			return tNode.right;
		} else if (tNode.right == NIL) {
			return tNode.left;
		} else {
			returnPair rPair = deleteMinItem(tNode.right); // case 3: 오른쪽에서 가장 작은 값 찾아서 메꾸면 되니깐
			tNode.item = rPair.item;
			tNode.right = rPair.node;
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
			int type = needBalance(tNode);
			if (type != NO_NEED) {
				tNode = balanceAVL(tNode, type);
			}
			return tNode;
		}
	}


	private returnPair deleteMinItem(AVLNode tNode) {
		int type;
		if (tNode.left == NIL) {
			return new returnPair(tNode.item, tNode.right); // 리프 노드인 경우 return ->
		} else {
			returnPair rPair = deleteMinItem(tNode.left); // <- 여기로 return 값 나옴ㄷㄷ
			tNode.left = rPair.node; // 재귀 들어간 만큼 반복 덮어씌우기
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
			type = needBalance(tNode);
			if (type != NO_NEED) {
				tNode = balanceAVL(tNode, type);
			}
			rPair.node = tNode; // 재귀 들어간 만큼 반복 덮어씌우기
			return rPair;
		}
	}


	private class returnPair {
		private Comparable item;
		private AVLNode node;
		private returnPair(Comparable it, AVLNode nd) {
			item = it;
			node = nd;
		}
	}

	private final int LL = 1, LR = 2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;
	private int needBalance(AVLNode t) {
		int type = ILLEGAL;
		if (t.left.height + 2 <= t.right.height) { // 갭이 1까지는 괜찮으니깐
			if ((t.right.left.height) <= (t.right.right.height)) {
				type = RR;
			} else {
				type = RL;
			}
		} else if ((t.left.height) >= t.right.height + 2) {
			if ((t.left.left.height) >= t.left.right.height) {
				type = LL;
			} else {
				type = LR;
			}
		} else {
			type = NO_NEED;
		}
		return type;
	}


	private AVLNode balanceAVL(AVLNode tNode, int type) {
		AVLNode returnNode = NIL;
		switch (type) {
			case LL:
				returnNode = rightRotate(tNode);
				break;
			case LR:
				tNode.left = leftRotate(tNode.left);
				returnNode = rightRotate(tNode);
				break;
			case RR:
				returnNode = leftRotate(tNode);
				break;
			case RL:
				tNode.left = rightRotate(tNode.right);
				returnNode = leftRotate(tNode);
				break;
			default:
				System.out.println("Impossible type! Should be one of LL, LR, RR, RL");
				break;
		}
		return returnNode;
	}


	private AVLNode leftRotate(AVLNode t) {
		AVLNode RChild = t.right;
		if (RChild == NIL) {
			System.out.println(t.item + "'s RChild shouldn't be NIL!");
		}
		AVLNode RLChild = RChild.left;
		RChild.left = t;
		t.right = RLChild;
		t.height = 1 + Math.max(t.left.height, t.right.height);
		RChild.height = 1 + Math.max(RChild.left.height, RChild.right.height);
		return RChild;
	}

	private AVLNode rightRotate(AVLNode t) {
		AVLNode LChild = t.left;
		if (LChild == NIL) {
			System.out.println(t.item + "'s LChild shouldn't be NIL!");
		}
		AVLNode LRChild = LChild.right;
		LChild.right = t;
		t.left = LRChild;
		t.height = 1 + Math.max(t.left.height, t.right.height);
		LChild.height = 1 + Math.max(LChild.left.height, LChild.right.height);
		return LChild;
	}


	@Override
	public boolean isEmpty() {
		return root == NIL;
	}


	@Override
	public void clear() {
		root = NIL;
	}
}
