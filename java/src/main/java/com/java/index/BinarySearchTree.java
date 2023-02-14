package com.java.index;

import com.sun.source.tree.Tree;

public class BinarySearchTree implements IndexInterface<TreeNode> {
	private TreeNode root; //private설정
	public BinarySearchTree() { //생성자
		root = null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst1 = new BinarySearchTree();

		bst1.insert(10);
		bst1.insert(5);
		bst1.insert(2);
		bst1.insert(6);
		bst1.insert(15);
		bst1.insert(13);
		bst1.insert(20);
		bst1.insert(17);
		bst1.insert(16);
		bst1.insert(18);
//		bst1.search(16);
		bst1.delete(15);



	}


	// 검색
	@Override
	public TreeNode search(Comparable searchKey) {
		return searchItem(root, searchKey); //private root로 접근하기 위해서는 내부에서 부르게
	}


	private TreeNode searchItem(TreeNode tNode, Comparable searchKey) {
		if (tNode == null) {
			return null;
		} else if (searchKey.compareTo(tNode.key) == 0) {
			return tNode;
		} else if (searchKey.compareTo(tNode.key) < 0) {
			return searchItem(tNode.left, searchKey);
		} else {
			return searchItem(tNode.right, searchKey);
		}
	}


	public void insert(Comparable newKey) {
		root = insertItem(root, newKey); //재귀적으로 그 전의 tNode 리턴해서 root는 초기 루트로 있음
	}


	private TreeNode insertItem(TreeNode tNode, Comparable newItem) {
		if (tNode == null) {
			tNode = new TreeNode(newItem, null, null);
		} else if (newItem.compareTo(tNode.key) < 0) {
			tNode.left = insertItem(tNode.left, newItem);
		} else {
			tNode.right = insertItem(tNode.right, newItem);
		}
		return tNode; // return안하면 tnode인 root는 계속 null인 상태
	}


	@Override
	public void delete(Comparable searchKey) {
		root = deleteItem(root, searchKey);
	}


	private TreeNode deleteItem(TreeNode tNode, Comparable searchKey) {
		if (tNode == null) {
			return null;
		} else if (searchKey == tNode.key) {
			tNode = deleteNode(tNode); // return이 null이 된 상태로 오고, 현재의 tNode == null 이 되서 삭제됨
		} else if (searchKey.compareTo(tNode.key) < 0) {
			tNode.left = deleteItem(tNode.left, searchKey);
		} else {
			tNode.right = deleteItem(tNode.right, searchKey);
		}
		return tNode;
	}


	private TreeNode deleteNode(TreeNode tNode) {
		/*
		3가지 case
		1. tNode이 리프 노드 (자식 0개)
		2. tNode의 자식 1개
		3. tNode의 자식 2개
		 */
		if ((tNode.right == null) && (tNode.left == null)) { // case 1
			return null;
		} else if ((tNode.left == null)) { // case 2
			return tNode.right;
		} else if (tNode.right == null) {
			return tNode.left;
		} else {
			ReturnPair rPair = deleteMinItem(tNode.right); // case 3: 오른쪽에서 가장 작은 값 찾아서 메꾸면 되니깐
			tNode.key = rPair.key;
			tNode.right = rPair.node;
			return tNode;
		}
	}


	private ReturnPair deleteMinItem(TreeNode tNode) {
		if (tNode.left == null) {
			return new ReturnPair(tNode.key, tNode.right); // 리프 노드인 경우 return ->
		} else {
			ReturnPair rPair = deleteMinItem(tNode.left); // <- 여기로 return 값 나옴ㄷㄷ
			tNode.left = rPair.node; // 재귀 들어간 만큼 반복 덮어씌우기
			rPair.node = tNode; // 재귀 들어간 만큼 반복 덮어씌우기
			return rPair;
		}
	}


	private static class ReturnPair {
		private Comparable key;
		private TreeNode node;
		private ReturnPair(Comparable it, TreeNode nd) {
			key = it;
			node = nd;
		}
	}



	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}
}
