import java.util.Iterator;

//Author: Rocky Xia
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> top;
    private int size;

    public Stack(){
        top = null;
        size = 0;
    }

    public void push(Item item){
        if(top == null){
            top = new Node<Item>(item);
        }
        else {
            Node<Item> temp = top;
            top = new Node<Item>(item);
            top.next = temp;
        }
        size++;
    }

    public Item pop(){
        Item temp = top.stuff;
        top = top.next;
        size--;
        return temp;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public Item peek(){
        return top.stuff;
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
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        @Override
        public boolean hasNext() {
            return top.next != null;
        }

        @Override
        public Item next() {
            pop();
            return peek();
        }
    }
}
