class SinglyLinkedListTest
{
	private ListNode head;

	
	//display all the elements of the list
	public static void display(ListNode head)
	{
		if(head==null)
			return;
		ListNode current=head;
		
		while(current!=null)
		{
			System.out.print(current.data+"-->");
			current=current.next;
		}
		System.out.print(current);
	}	
	
	//insert node at the begining of the list
	public ListNode insertAtBegining(ListNode head,int data)
	{
		ListNode newnode=new ListNode(data);
		if(head==null)
		{
			head=newnode;
			return newnode;
		}
		newnode.next=head;
		head=newnode;
		return head;
	}
	
	//insert node at the end of list
	public ListNode insertAtEnd(ListNode head,int data)
	{
		ListNode newNode=new ListNode(data);
		if(head==null)
			return newNode;
		ListNode current = head;
		while(current.next != null)
			current=current.next;
		current.next=newNode;
		return newNode;
	}
	//insert node at the random position
	public ListNode insertAtMiddle(ListNode previous,int data)
	{

		if(previous==null)
			return null;
		
		ListNode newnode=new ListNode(data);
		newnode.next=previous.next;
		previous.next=newnode;
		return newnode;
	}
	
	//find length of the linked list
	public static int findLength(ListNode head)
	{
		int count=0;
		ListNode current=head;
		while(current!=null)
		{
			count++;
			current=current.next;
		}
		return count;
	}
	
	//insert node at the perticular position
	public ListNode insertAtPosition(ListNode head,int position,int data)
	{
			int count=0;
			ListNode current=head;
			while(count<position-1)
			{
				
				current=current.next;
				count++;
			}
			ListNode newnode=new ListNode(data);
			newnode.next=current.next;
			current.next=newnode;
			return newnode;
	}

	//delete the first element from the list
	public ListNode deleteFirstElt(ListNode head)
	{
		if(head==null)
			return null;
		ListNode temp=head;
		head=head.next;
		temp.next=null;
		return head;
	}
	
	//delete last node
	public ListNode deleteLastElt(ListNode head)
	{
		ListNode current=head;
		ListNode previousToLast=null;
		if(head==null)
			return null;
		while(current.next!=null)
		{
			previousToLast=current;
			current=current.next;
		}	
		previousToLast.next=null;	
		return current;
	}
	
	// deleting element after the element(previous)
	public ListNode deleteRandom(ListNode previous)
	{
		if(previous==null)
			return null;
		ListNode temp=previous.next;
		previous.next=temp.next;
		temp.next=null;
		return temp;
	
	}
	
	//deleting the perticular element
	public ListNode deleteElement(ListNode head,ListNode delete)
	{
		if(delete==null)
			return null;
		ListNode current=head;
		while(current.next!=delete && current!=null)
			current=current.next;
		current.next=delete.next;
		delete.next=null;
		return delete;
	}
	
	//deleting the element at the perticular position
	public ListNode deleteAt(ListNode head,int position)
	{
		if(head==null)
			return null;
		ListNode current=head;
		int count=0;
		while(count<position-2)
		{
			count++;
			current=current.next;
		}
		ListNode deleteNode=current.next;;
		current.next=deleteNode.next;
		deleteNode.next=null;
		return deleteNode;
	}
	
	//find the position of the particular elt
	public static int findEltPos(ListNode head,int elt)
	{
			ListNode current=head;
			int pos=1;
			while(current.data!=elt || current.next!=null)
			{
				pos++;
				current=current.next;
			}
			return pos;
	}
	
	//check whether the elt is present in the list
	public boolean findElt(ListNode head,int elt)
	{
			ListNode current=head;
			while(current!=null)
			{
				if(current.data==elt)
					return true;
				else					
					current=current.next;
			}
			return false;
	}
	
	//reverse the list
	
	public ListNode reverseList(ListNode head)
	{
		if(head==null)
			return head;
		
		ListNode current=head;
		ListNode previous=null;
		ListNode next=null;
		while(current!=null)
		{
				next=current.next;
				current.next=previous;
				previous=current;
				current=next;
		}
		return previous;
	}
	
	//find the middle element of the linked list
	
	public ListNode middleElt(ListNode head)
	{
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null)
		{
				slow=slow.next;
				fast=fast.next.next;
		}	
	return slow;
	}	
	
	//find nth element from the end of the list
	
	public ListNode findEltRev(ListNode head,int elt)
	{
		ListNode firstptr=head;
		ListNode lastptr=head;
		int countr=1;
		while(countr!=elt)
		{
			countr++;
			lastptr=lastptr.next;
		}
		while(lastptr.next!=null)
		{
			firstptr=firstptr.next;
			lastptr=lastptr.next;
		}
		return firstptr;
	}
	
	// remove duplicates from the linked list
	public ListNode removeDuplicates(ListNode head)
	{
			ListNode current=head;
			while(current!=null && current.next!=null)
			{
				if(current.data ==current.next.data)
					current.next=current.next.next;
				else
					current=current.next;
			}
			return head;
	}
	
	//insert element in the sorted list in such a way that sorting order is maintained
	
	public static void InsertInSortedList(ListNode head, int data)
	{
			ListNode newnode=new ListNode(data);
			ListNode current=head;
			ListNode temp=null;
			while(current.data < newnode.data && current != null)
			{
				temp=current;
				current=current.next;
			}
			newnode.next=current;
			temp.next=newnode;
		
	}	
	//class for creating the individual list element each pointing to null
	private static class ListNode
	{
		private int data;
		private ListNode next;
		
		public ListNode(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	//driver method 
	//PS: you need to make changes to driver method in order to call the particular method.
	public static void main(String ar[])
	{
		ListNode head=new ListNode(10);
		ListNode second=new ListNode(20);
		ListNode third=new ListNode(30);
		ListNode fourth=new ListNode(30);
		ListNode fifth=new ListNode(40);
		
		head.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=fifth;
		
		SinglyLinkedListTest single=new SinglyLinkedListTest();
		single.display(head);
		System.out.println();
		ListNode del=single.deleteElement(head,third);
		single.display(head);
		/*single.InsertInSortedList(head,25);
		single.display(head);
	
	
		ListNode dup=single.removeDuplicates(head);
		single.display(head);
		
		
		ListNode rev = single.findEltRev(head,3);
		System.out.println(rev.data);
		
		ListNode middle=single.middleElt(head);
		System.out.println(middle.data);
		ListNode reversenode=single.reverseList(head);
		single.display(reversenode);
		System.out.println(single.findElt(head,30));
		
		
		System.out.println();
		System.out.println(single.findLength(head));
		ListNode newhnode=single.insertAtPosition(head,3,60);
		ListNode lastelt=single.deleteAt(head,3);
		single.display(head);
		System.out.println();
		System.out.println(single.findLength(head));*/
	}
}