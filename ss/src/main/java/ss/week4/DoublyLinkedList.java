package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
        Node newNode = new Node(element);

        Node nextNode = this.getNode(index);
        Node prevNode = index != 0 ? this.getNode(index - 1) : this.head;

        newNode.next = nextNode;
        newNode.previous = prevNode;
        nextNode.previous = newNode;
        prevNode.next = newNode;

        size++;
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
        if (this.size == 0) {
            // self destruct?
            return;
        }
        Node oldNode = this.getNode(index);
        Node oldNext = oldNode.next;
        Node oldPrev = oldNode.previous;

        oldNext.previous = oldPrev;
        oldPrev.next = oldNext;

        size--;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    public Node findBefore (Element element) {
        int pos = -1;
        Node curr = this.head;

        while (pos < this.size) {
            if(curr.element.equals(element)) {
                return curr.previous.equals(this.head) ? null : curr.previous;
            }
        }

        return null;
    }

    public void remove (Element element) {
        Node prevNode = findBefore(element);
        if (prevNode == null) {
            return;
        }

        Node targetNode = prevNode.next;
        Node nextNode = targetNode.next;

        prevNode.next = nextNode;
        nextNode.previous = prevNode;

        size--;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
