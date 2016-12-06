import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    private Node first;
    private  Node last;
    private int size;
    
    private class Node<Item>
    {
        Item item;
        Node next;
    }
       
    public Deque() // create empty deque
    {
        first = null;
        last = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return (first == null && last == null);
    }
    
    public int size()
    {
        return size;
    }
    
    public void addFirst(Item item)
    {
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        size++;
    }
    
    public void addLast(Item item)
    {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = old;
        size++;
    }
    
    public Item removeFirst()
    {
        Item value = first.item;
        first = first.next;
        return value;
        size--;
    }
    
    public Item removeLast()
    {
        Item item = last.item;
        last = last.next;
        return item;
        size--;
    }
    
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        public void remove()
        {
            /* not supported */
        }
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    public static void main(String[] args)
    {
        Deque test = new Deque();
    }
}