package LinkedList1;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedList1 {
	
//	we have made our own class 
//	public class Node<T> {
//		public T data;
//		public Node<T> next;
//
//		public Node(T data) {
//			this.data = data;
////			this.next = null;
//		   }
//		}
		 
	
	
	//@(1)@ basic methode of create linked list by node
	public static Node<Integer> createLL(){
		Node<Integer> n1=new Node<Integer>(10);
		Node<Integer> n2=new Node<Integer>(20);
		Node<Integer> n3=new Node<Integer>(30);
		Node<Integer> n4=new Node<Integer>(40);
		Node<Integer> n5=new Node<Integer>(50);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		return n1;
	}

	
	
	//@(2)@ for print linked list data
	public static void printLL(Node<Integer> head) {
		Node<Integer> temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
	 // length of LL
	/*public static int lengthLL(Node<Integer> head) {
		Node<Integer> temp= head;
		int currpos=0;
		while(temp!=null) {
			currpos++;
			temp=temp.next;
		}
		return currpos;
	}
	*/
	
	
	//@(3)@ for getting length of linkedlist o(n)
	public static int LengthLL(Node<Integer> head) {
		Node<Integer> temp = head;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return -1;
	}

	
	//@(4)@ program to take input of linkedlist int O(n2)
	public static Node<Integer> takeInputOn2(){
		Scanner scn=new Scanner(System.in);
		Node<Integer> head=null;
		int data=scn.nextInt();
		while(data!=-1) {
			Node<Integer> currNode=new Node<Integer>(data);
			if(head==null) {
				//make this node as head node
				head=currNode;
			}else {
				Node<Integer> tail=head;
				while(tail.next!=null) {
					tail=tail.next;
				}
				tail.next=currNode;
				
			}
			data=scn.nextInt();
		}
		return head;
	}
	
	//@(5)@ program to take input of linkedlist int O(n1)
	public static Node<Integer> takeInputOn(){
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		Node<Integer> head=null,tail=null;
		while(data!=-1) {
			Node<Integer> currentNode=new Node<Integer>(data);
			
			if(head==null) {
			head=currentNode;
			tail=currentNode;
			}else {
				tail.next=currentNode;
				tail=currentNode;
			}
			data=sc.nextInt();
		}
		return head;
	}
	
	//@(6)@ program to find node Index
	public static void printIthNode(Node<Integer> head ,int i) {
		Node<Integer> temp=head;
		int currpos=0;
		while(temp!=null&&currpos<i) {
			temp=temp.next;
			currpos++;		
		}
//		if(temp==null) {
//			return;
//		}
		if(temp!=null) {
		System.out.println(temp.data);
		}
	}
	
	
	
	
	//@(7)@ program to insert Node at any position(at first , at last , at inside)
	public static Node<Integer> insertNode(Node<Integer> head, int pos, int elem){
		Node<Integer> insertNode=new Node<Integer>(elem);
		int currpos=0;
		if(pos==0) {
			insertNode.next=head;
			head=insertNode;
			return head;
		}else {
			Node<Integer> temp= head;
			while(currpos<pos-1 && temp!=null) {
				currpos++;
				temp=temp.next;
			}
			if(temp!=null) {
				insertNode.next=temp.next;
				temp.next=insertNode;
			}
			return head;
		}
	}
	
	
	//@(8)@ program to delete Node at any position 
	public static Node<Integer> deleteLLNode(Node<Integer> head, int pos){
		if(head==null){
			return head;
			}
		if(pos==0) {
			return head.next;
		}else {
			Node<Integer> temp=head;
			int currpos=0;
			while(currpos<pos-1&&temp!=null) {
				temp=temp.next;
				currpos++;
			}
			if(temp!=null&&temp.next!=null) {
			temp.next=temp.next.next;
			}
			return head;
		}
		
	}
	
	
	//@(9)@program to find node index in LinkedList
	public static int findNode(Node<Integer> head, int num) {
		if(head==null) {
			return -1;
		}
		int currpos=0;
		Node<Integer> temp=head;
		while(temp!=null) {
			if(temp.data.equals(num)) {
				return currpos;
			}
			currpos++;
			temp=temp.next;
		}
		return -1;
	}
	
	 
	//@(10)@ program to remove duplicate element in LL//consecutive duplicate
	public static Node<Integer> removeDuplicateOfshortedLL(Node<Integer> head){
		if(head==null) {
			return head;
		}
	  Node<Integer> temp=head;
	  while(temp.next!=null) {
		  if(temp.data == temp.next.data) {
			  temp.next=temp.next.next;
		  }else {
			  temp=temp.next;
		   }
	    }
		return head;
	}
	//@(11)@ progtam to find ith node data in LL
	public static void printIthNode1(Node<Integer> head , int i) {
		Node<Integer> temp = head;
		int currPos = 0;
		int count = 0;
		while(temp!=null) {
			if(count == i) {
				System.out.println(temp.data);
			}
			temp=temp.next;
			count++;
		
		}
	}
	
	
	//@(12)@remove consecutive duplicate from array
	public static ArrayList<Integer> removeDuplicate(int arr[]){
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] != arr[i+1]) {
				result.add(arr[i]);
			}
			i++;
		}
		return result;	
	}

	
	public static void main(String[] args) {
		Node<Integer> node=takeInputOn();
		node =removeDuplicateOfshortedLL(node);
//		printIthNode1(node , 3);
		
		
//		int a[] = {1,1,2,3,3,4,4,5};
//		ArrayList<Integer> al =removeDuplicate(a);
//		System.out.println(al);
//		
		
//		System.out.println(li[2]);
//		System.out.println(list.size());
		

//		int index=findNodeData(node, 13);
//		System.out.println(index);
//		node=deleteLLP(node, 7);
		printLL(node);
//		node=removeDuplicate(node);
//	printLL(node);
//		int gcd= findGCD(576,876,1206);
//		System.out.println(gcd);
		
		
//		System.out.println(findNode(node, 11));
//		Node<Integer> finalLL=deleteLL(node, 6);
//		printLL(finalLL);
//		LinkedList<Integer> l1=new LinkedList();
	
//		
//		printLL(node);
//		printIthNode(node, 7);
//		printLL(node);
//		System.out.println(lengthLL(node));
   
	}

}
