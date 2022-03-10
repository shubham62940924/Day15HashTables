package com.blz.hashtable;

//
public interface INode<K> {
	K getKey();

	void setKey();

	INode getNext();

	void setNext(INode<K> tempNode);
}
