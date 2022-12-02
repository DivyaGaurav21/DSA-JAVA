package LinkedList1;

import java.util.Scanner;

public class LinkedList2 {

	public static Node<Integer> takeInputN() {
		Scanner scn = new Scanner(System.in);
		int data = scn.nextInt();
		Node<Integer> head = null, tail = null;
		while (data != -1) {
			Node<Integer> currNode = new Node<Integer>(data);
			if (head == null) {
				head = currNode;
				tail = currNode;
			} else {
				tail.next = currNode;
				tail = currNode;
			}

			data = scn.nextInt();
		}
		return head;
	}

	public static void printLL(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	// @(13)@ program to reverse LL with address by recursive way
	public static Node<Integer> reverseLL1(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> smallAns = reverseLL1(head.next);
		Node<Integer> tail = smallAns;
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = head;
		head.next = null;
		return smallAns;
	}

	// @(Alternate)@program to reverse LL by iterative way
	public static Node<Integer> reverseLL2(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> curr = head;
		Node<Integer> prev = null;
		Node<Integer> forw = null;
		while (curr != null) {
			forw = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}
		return prev;
	}

	// @(14)@ program to find middle Linked List
	public static Node<Integer> middleNode(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}


	// @(15)@ merge sort recursive function to sort Linked list
	public static Node<Integer> mergeSortLL(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> mid = middleNode(head);
		Node<Integer> half1 = head;
		Node<Integer> half2 = mid.next;
		mid.next = null;

		half1 = mergeSortLL(half1);
		half2 = mergeSortLL(half2);

		Node<Integer> finalHead = mergeTwoLL(half1, half2);
		return finalHead;
	}

	// @(Merge sort)@ Merge two Sorted Linked List in one LL
	public static Node<Integer> mergeTwoLL(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node<Integer> dummy = new Node<Integer>(-1);
		Node<Integer> tail = dummy;

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				tail.next = head1;
				head1 = head1.next;
				tail = tail.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
				tail = tail.next;
			}
		}
		if (head1 != null) {
			tail.next = head1;
		}
		if (head2 != null) {
			tail.next = head2;
		}
		return dummy.next;
	}

	// @(16)@ find a node recursively in LL
	public static int findNode(Node<Integer> head, int n) {
		if (head == null) {
			return -1;
		}
		if (head.data.equals(n)) {
			return 0;
		} else {
			int smallAns = findNode(head.next, n);
			if (smallAns == -1) {
				return -1;
			} else {
				return smallAns + 1;
			}
		}
	}

	// @(17)@ segregate zero and one
	public static Node<Integer> segregateZeroOne(Node<Integer> head) {
		if (head == null && head.next == null) {
			return head;
		}
		Node<Integer> dummyZero = new Node<Integer>(-1);
		Node<Integer> dummyOne = new Node<Integer>(-1);

		Node<Integer> curr = head, zeroTail = dummyZero, oneTail = dummyOne;

		while (curr != null) {
			if (curr.data == 0) {
				zeroTail.next = curr;
				zeroTail = zeroTail.next;
				curr = curr.next;
			} else {
				oneTail.next = curr;
				oneTail = oneTail.next;
				curr = curr.next;
			}
		}
		zeroTail.next = dummyOne.next;
		oneTail.next = null;
		return dummyZero.next;
	}

	// @(18)@ segregate even odd in linked list
	public static Node<Integer> segregateEvenOddBetter(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;

		Node<Integer> currNode = head, evenHead = null, evenTail = null, oddHead = null, oddTail = null;

		while (currNode != null) {
			if (currNode.data % 2 == 0) {
				if (evenHead == null) {
					evenHead = currNode;
					evenTail = currNode;
				} else {
					evenTail.next = currNode;
					evenTail = evenTail.next;
				}

			} else {
				if (oddHead == null) {
					oddHead = currNode;
					oddTail = currNode;
				} else {
					oddTail.next = currNode;
					oddTail = oddTail.next;
				}

			}
			currNode = currNode.next;
		}
		if (oddHead == null) {
			return evenHead;
		}
		if (evenHead == null) {
			return oddHead;
		}
		evenTail.next = oddHead;
		oddTail.next = null;
		head = evenHead;
		return head;

	}

	// Alternate
	public static Node<Integer> segEvenOdd(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		// dummy node
		Node<Integer> evenHead = new Node<Integer>(-1);
		Node<Integer> oddHead = new Node<Integer>(-1);

		Node<Integer> evenTail = evenHead, oddTail = oddHead, curr = head;

		while (curr != null) {
			if (curr.data % 2 != 0) {
				oddTail.next = curr;
				oddTail = oddTail.next;
				curr = curr.next;
			} else {
				evenTail.next = curr;
				evenTail = evenTail.next;
				curr = curr.next;
			}
		}
		evenTail.next = oddHead.next;
		oddTail.next = null;
		head = evenHead.next;
		return head;
	}

//@(19)@	Given a singly linked list of integers and an integer n, 
//	find and return the index for the first occurrence of 'n' in
//	the linked list. -1 otherwise.
//			Follow a recursive approach to solve this.
	public static int findNodeRec(Node<Integer> head, int n) {
		if (head == null) {
			return -1;
		}
		if (head.data == n) {
			return 0;
		} else {
			int smallAns = findNode(head.next, n);
			if (smallAns == -1) {
				return -1;
			} else {
				return smallAns + 1;
			}
		}
	}

//append k element at first 
	public static Node<Integer> appendKElement(Node<Integer> head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		Node<Integer> curr = head, fast = head, slow = head;
		int posCount = 0;
		while (posCount < k && fast != null) {
			fast = fast.next;
			posCount++;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = curr;
		head = slow.next;
		slow.next = null;
		return head;
	}

//	date :-28 dec 

	// @(20)@ Function to find the data of nth node from the end of a linked list.
	// Given a linked list consisting of L nodes and given a number N.

	// Function to find the data of nth node from the end of a linked list.
	public static int getNthFromLast(Node<Integer> head, int n) {
		int size = sizeLL(head);
		int index = size - n;
		int ithNEnd = ithNode(head, index);
		return ithNEnd;

	}

//	The task is to find the Nth node from the end of the linked list.
	public static int sizeLL(Node<Integer> head) {
		int size = 0;
		Node<Integer> temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	// print ith node
	public static int ithNode(Node<Integer> head, int i) {
		Node<Integer> temp = head;
		int countPos = 0;
		while (temp != null) {
			if (countPos == i) {
				return temp.data;
			}
			countPos++;
			temp = temp.next;
		}
		return -1;
	}

	// @(21)@ Given the head of a linked list, remove the nth node from the end of
	// the list and return its head.
//	Input: head = [1,2,3,4,5], n = 2
//			Output: [1,2,3,5]

	public static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
		int startIndex = getNthStartIndex(head, n);
		head = deleteLLNodeIterative(head, startIndex);
		return head;
	}

	public static int getNthStartIndex(Node<Integer> head, int n) {
		int size = sizeLL2(head);
		int indexStart = size - n;
		return indexStart;
	}

	public static int sizeLL2(Node<Integer> head) {
		int size = 0;
		Node<Integer> temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	public static Node<Integer> deleteLLNodeIterative(Node<Integer> head, int pos) {
		if (head == null) {
			return head;
		}
		if (pos == 0) {
			return head.next;
		} else {
			Node<Integer> temp = head;
			int currpos = 0;
			while (currpos < pos - 1 && temp != null) {
				temp = temp.next;
				currpos++;
			}
			if (temp != null && temp.next != null) {
				temp.next = temp.next.next;
			}
			return head;
		}

	}

	
	// @(22)@ program to check wheathe A LL is palidrom or not
	public static boolean palidromLL(Node<Integer> head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node<Integer> mid = middleNode(head);
		Node<Integer> nHead = mid.next;
		mid.next = null;

		nHead = reverseLL2(nHead);

		Node<Integer> c1 = head;
		Node<Integer> c2 = nHead;
		while (c1 != null && c2 != null) {
			if (c1.data != c2.data) {
				return false;
			}
			c1 = c1.next;
			c2 = c2.next;
		}
		return true;
	}
	
	
	
	
	// practice palidrom LL practice
	public static boolean checkPalidrom2(Node<Integer> head) {
		if(head == null || head.next == null) return true;
		
		Node<Integer> midLL = middleNode2(head);
		Node<Integer> nHead = midLL.next;
		midLL.next = null;
		Node<Integer> reveMidLL = reverse2(nHead);
		Node<Integer> c1 = head , c2 = reveMidLL;
		while(c1!=null && c2!=null) {
			if(c1.data != c2.data) {
				return false;
			}
			c1 = c1.next;
			c2=c2.next;
		}
		return true;
	}
	
	private static Node<Integer> reverse2(Node<Integer> head) {
		if(head.next == null || head.next == null) return head;
		Node<Integer>smallAns = reverse2(head.next);
		Node<Integer> tail =smallAns;
		while(tail.next != null) {
			tail = tail.next;
		}
		tail.next = head;
		head.next = null;
		return smallAns;
	}

	private static Node<Integer> middleNode2(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		while(fast != null && fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Node<Integer> ll = takeInputN();
//		boolean checkPali = checkPalidrom2(ll);
//		System.out.println(checkPali);
		ll = middleNode2(ll);
		
		
//		ll = deleteLLNodeIterative(ll, 2);

		printLL(ll);

//		ll = appendKElement(ll, 2);
//		printLL(ll);

//		int index = findNode(ll, 12);
//		System.out.println(index);
//		ll=segEvenOdd(ll);
//		printLL(ll);
//		boolean pali=palidromLL(LL1);
//		System.out.println("divya");
//		System.out.println(findNode(LL1, 5));

//		Node<Integer> mergeLL=mergeSortLL(LL1);
//		printLL(mergeLL);
//		boolean b=palidromLL(LL);
//		System.out.println(b);
//		
//		Node<Integer> node=middleNode(LL);
////		printLL(LL);
//		System.out.println(node.data);
	}
}
