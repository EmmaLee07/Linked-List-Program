
public class MyLinkedList<E> implements GenericList<E> {

    private class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E data) {
            value = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            next = node;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = new Node(null); // Initialize with a dummy node
        size = 0;
    }

    private int indexOf(E obj) {
        int index = 0;
        Node currentNode = head.getNext();

        while (currentNode != null) {
            if (currentNode.getValue().equals(obj)) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }

        return -1; // Object not found
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            return null;//throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node currentNode = head.getNext();
        int currentIndex = 0;

        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return null; // This should not happen due to the index check
    }

    public boolean add(E obj) {
        Node newNode = new Node(obj);
        Node currentNode = head;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(newNode);
        size++;
        return true;
    }

    public void add(int index, E obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node newNode = new Node(obj);
        Node previousNode = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            previousNode = previousNode.getNext();
            currentIndex++;
        }

        newNode.setNext(previousNode.getNext());
        previousNode.setNext(newNode);
        size++;
    }

    public boolean contains(E obj) {
        return indexOf(obj) != -1;
    }

    public E get(int index) {
        Node node = getNode(index);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node previousNode = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            previousNode = previousNode.getNext();
            currentIndex++;
        }

        Node nodeToRemove = previousNode.getNext();
        previousNode.setNext(nodeToRemove.getNext());
        size--;

        return nodeToRemove.getValue();
    }

    public boolean remove(E obj) {
        Node previousNode = head;
        Node currentNode = head.getNext();

        while (currentNode != null) {
            if (currentNode.getValue().equals(obj)) {
                previousNode.setNext(currentNode.getNext());
                size--;
                return true;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        return false;
    }

    public E set(int index, E obj) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node node = getNode(index);
        E oldValue = node.getValue();
        node.setValue(obj);

        return oldValue;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
}



