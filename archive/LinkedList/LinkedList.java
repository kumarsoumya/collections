public class LinkedList<T> {

    public Node<T> head;
    public int size;
    private Node<T> tail;

    public class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addToTail(T data) {
        head = addToTail(head, data);
    }

    private Node<T> addToTail(Node<T> head, T data) {
        if (head == null) {
            size++;
            tail = new Node<T>(data);
            return tail;
        } else {
            head.next = addToTail(head.next, data);
        }
        return head;
    }

    public void addToHead(T data) {
        if (head == null) {
            tail = new Node<T>(data);
            head = tail;
        } else {
            Node<T> curr = new Node<T>(data);
            curr.next = head;
            head = curr;
        }
        size++;
    }

    public T popFromHead() {
        if (head == null) {
            return null;
        } else {
            Node<T> curr = head;
            head = curr.next;
            curr.next = null;
            size--;
            return curr.data;
        }
    }

    public T popFromTail() {
        if (head == null) {
            return null;
        } else {
            T data = tail.data;
            tail.next = null;
            tail.data = null;
            tail = null;
            size--;
            return data;
        }
    }

    public void remove(T data) {
        remove(data, false);
    }

    public boolean contains(T data) {
        if (head == null) {
            return false;
        } else {
            Node<T> curr = head;
            while (curr != null) {
                if (curr.data.equals(data)) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    }

    public void remove(T data, boolean all) {
        if (head == null) {
            return;
        } else {
           Node<T> curr = head;
           Node<T> prev = null;
           while (curr != null) {
                if (curr.data.equals(data)) {
                    if (prev == null) {
                        head = curr.next;
                        curr.data = null;
                        curr.next = null;
                    } else {
                        prev.next = curr.next;
                        curr.data = null;
                        curr.next = null;
                    }
                    size--;
                    if (!all) {
                        return;
                    }
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void print() {
        print(head);
    }

    private void print(Node<T> head) {
        if(head.next == null) {
            System.out.println(head.data);
            return;
        } else {
            System.out.print(head.data + ",");
            print(head.next);
        }
    }
}

