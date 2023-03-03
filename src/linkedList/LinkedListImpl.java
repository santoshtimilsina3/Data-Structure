package linkedList;


public class LinkedListImpl {
    static Link head = null;
    static int size = 0;

    public class Link {
        int data;
        Link next;

        Link(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Link node = new Link(data);
        size++;
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addLast(int data) {
        Link node = new Link(data);
        size++;
        if (head == null) {
            head = node;
            return;
        }
        Link current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Already Empty");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Link current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void getAllData() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Link current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public void getSize() {
        System.out.println(size);
    }


    public static void main(String[] args) {
        LinkedListImpl l = new LinkedListImpl();
        l.addFirst(5);
        l.addFirst(4);
        l.addLast(6);

        l.getAllData();
        l.getSize();
        l.deleteFirst();
        l.getAllData();
        l.getSize();
        l.deleteLast();
        l.getAllData();
        l.getSize();

    }

}

