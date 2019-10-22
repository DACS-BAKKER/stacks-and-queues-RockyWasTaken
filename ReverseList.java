//Author: Rocky Xia
public class ReverseList {

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.print();
        list.reverseIterative();
        list.print();
    }


}
