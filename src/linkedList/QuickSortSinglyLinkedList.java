package linkedList;

/*  Code developed in class (but for one critical line) 2010 Feb 23
 *  QuickSort for a linked list.
 *
 * @author  Timothy Rolfe
 */
import java.util.*;

@SuppressWarnings("unchecked")
public class QuickSortSinglyLinkedList
{//In case we want a pause through console.nextLine()
   static Scanner console = new Scanner(System.in);
   static final boolean DEBUG = false;

   
   public static void main ( String[] args )
   {
      int size = args.length > 0 ? Integer.parseInt(args[0]) : 17;
      LinkedList list = new LinkedList();
      int k;
      Random gen = new Random();
      
      

      for (k = 0; k < size; k++)
         list.addFirst(gen.nextInt(100));
      System.out.println(list);
      LinkedList.quickie(list);
      System.out.println(list);
   }
   
   // Tiny prototype of a linked list:  singly-linked, limited methods

   // This class requires NO access to outer-class data.
   private static class LinkedList
   {
      private static class Node implements Comparable
      {
         private Comparable item;
         private Node       next;

         private Node(Comparable item)
         {  this(item, null); }

         private Node(Comparable item, Node next)
         {  this.item = item;  this.next = next;  }

         public int compareTo(Object obj)
         {  return this.item.compareTo(((Node)obj).item);  }
      } // end inner class Node

      // No constructor needed; just initialize pointers to null
      private Node head = null, tail = null;
      private int  size = 0;      // Initial size is empty

      // Quickie accessor method
      public int size()  {  return size;  }

      // Check for empty list
      public boolean isEmpty()  { return head == null;  }

      public void addFirst ( Comparable item )
      {  // This will be a NEW head for the list
         head = new Node ( item, head ); // Existing list follows
         // If it WAS an empty list, update the tail pointer
         if ( tail == null )
            tail = head;
         size++;
      } // end addFirst

      public void addLast ( Comparable item )
      {  // Handle the special case of an empty list
         if ( head == null )
            head = tail = new Node ( item );
         else
            tail = tail.next = new Node ( item );
         size++;
      } // end addLast

      // Immediately empty out the entire list
      public void clear()
      {
         head = tail = null;
         size = 0;
      }

      public static void quickie (LinkedList data)
      {
         LinkedList lesser = new LinkedList(),
                    greater= new LinkedList();
         Node current, pivot;

         if (data.size() < 2) return;
         pivot = data.head;
         if (DEBUG)
            System.out.println("incoming:  " + data);
         data.head = data.head.next;
         if (DEBUG)
            System.out.println("Pivot is " + pivot.item);
         while (!data.isEmpty())
         {
            current = data.head;
            data.head = data.head.next;
            if (current.compareTo(pivot) < 0)
               lesser.addLast(current.item);
            else
               greater.addLast(current.item);
         }
         if (DEBUG)
         {  System.out.println("lesser: " + lesser);
            System.out.println("greater: " + greater);
         }
         quickie(lesser);
         quickie(greater);
         if (lesser.isEmpty())
         {  data.head = pivot;
            data.head.next = greater.head;
            data.tail = greater.tail;
         }
         else
         {  data.head = lesser.head;
            lesser.tail.next = pivot;       // CRITICAL LINE
            lesser.tail = pivot;
            if (greater.isEmpty())
            {  data.tail = pivot; pivot.next = null;  }
            else
            {  pivot.next = greater.head;
               data.tail = greater.tail;
            }
         }
         if (DEBUG)
            System.out.println("Result"  + data);
      }

      // Behavior is modeled on that of java.util.LinkedList.toString()
      // without using an Iterator.
      public String toString()
      {  StringBuilder rtn = new StringBuilder("[");
         Node current = head;   // Note the dummy header

         if (current != null)        // First entry, no comma
         {  rtn.append(current.item);
            current = current.next;
         }
         while (current != null)     // Subsequent entry, leading comma
         {  rtn.append(", "+current.item);
            current = current.next;
         }
         rtn.append("]");            // Close square bracket
         return rtn.toString();
      }
   } // end inner class LinkedList
}