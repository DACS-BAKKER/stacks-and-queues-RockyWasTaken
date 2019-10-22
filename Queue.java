import java.util.Iterator;

//Author: Rocky Xia
public class Queue<Item> implements Iterable<Item>{

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public Queue(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        return false;
    }

    public void enqueue(Item item){
        if(first == null){
            last = new Node<Item>(item);
            first = last;
        }
        else {
            Node temp = new Node<Item>(item);
            last.next = temp;
            last = temp;
        }
        size++;
    }

    public Item dequeue(){
        Item temp = first.stuff;
        first = first.next;
        size--;
        return temp;
    }

    public Item peek(){
        return first.stuff;
    }

    public int size(){
        return size;
    }

    private class Node<Item> {

        private Item stuff;
        private Node<Item> next;

        public Node(Item stuff){
            this.stuff = stuff;
            this.next = null;
        }
    }

    @Override
    public Iterator<Item> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{
        @Override
        public boolean hasNext() {
            return first.next != null;
        }

        @Override
        public Item next() {
            dequeue();
            return peek();
        }
    }
}
