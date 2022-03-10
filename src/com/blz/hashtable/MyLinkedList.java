package com.blz.hashtable;

/*
   @purpose: Ability to add node,insert,delete,delete last,delete first
   @param: Takes a newNode as a input
   @function : Adds new node before first node
   @return: No return value
  */

public class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

//Ability to Add nodes
	public void add(INode myNode) {
		if (this.tail == null) {
			this.tail = myNode;
		}
		if (this.head == null) {
			this.head = myNode;

		} else {
			INode tempNode = this.head;
			this.head = myNode;
			this.head.setNext(tempNode);
		}
	}

//Ability to append notes
	public void append(INode myNode) {
		if (this.head == null) {
			this.head = myNode;
		}
		if (this.tail == null) {
			this.tail = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

//insert nodes
	public void insert(INode<K> myNode, INode<K> newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	// Abilty to delete first
	public INode pop() {
		INode<K> tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	// Abilty to delete last
	public INode<K> popLast() {
		INode<K> tempNode = head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();

		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		return tempNode;
	}

	public void size() {
		int counter = 1;
		INode tempNode = this.head;
		while (tempNode != this.tail) {
			if (tempNode.getNext() == null) {

			} else {
				tempNode = tempNode.getNext();
				counter++;
			}

		}
		System.out.println("Size of current Linked List is: " + counter);
	}

//Ability to find node
	public INode<K> search(K key) {
		INode<K> tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;

			}
			tempNode = tempNode.getNext();
		}
		return null;
	}

//Ability to insert node
	public void insertUsingKey(INode myNode, INode value) {
		INode tempNode = this.head;
		while (tempNode != null) {
			if (myNode.getKey() == tempNode.getKey()) {
				INode temp = tempNode.getNext();
				tempNode.setNext(value);
				tempNode = tempNode.getNext();
				tempNode.setNext(temp);
				break;
			}
			tempNode = tempNode.getNext();
		}
	}

//Ability to delete node
	public void delete(INode<K> anyNode) {
		INode tempNode = this.head;
		if (anyNode.equals(this.head))
			pop();
		if (anyNode.equals(this.tail))
			popLast();
		while (!(tempNode.getNext().equals(tail))) {
			if (tempNode.getNext().getKey().equals(anyNode.getKey())) {
				INode tempNode1 = tempNode.getNext().getNext();
				tempNode.setNext(tempNode1);
				break;
			}
			tempNode = tempNode.getNext();
		}
	}

	public void printMyNodes() {
		System.out.println("My Nodes:" + head);

	}

	@Override
	public String toString() {
		return "MyLinklistNodes{" + head + '}';
	}
}
