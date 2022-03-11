package com.hackerrank.DataStructures;

public class CustomLinkedList {

    public static void main(String[] args) {
        /*LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        System.out.println("Size: " + list.size());
        list.removeFirst();
        System.out.println("First: " + list.getFirst());
        list.addLast(1);
        list.addLast(3);
        System.out.println("Size: " + list.size());
        list.display();
        System.out.println("Last: " + list.getLast());
        System.out.println("Get 1: " + list.get(1));
        System.out.println("Get 2: " + list.get(2));
        list.addFirst(0);
        list.addFirst(5);
        list.display();
        System.out.println("Size: " + list.size());
        list.add(2, 4);
        list.add(6, 8);
        list.display();
        list.add(8, 9);
        list.removeLast();
        list.display();
        System.out.println("Reverse list");
        list.reverse();
        list.display();
        System.out.println("Reverse head");
        list.reverseByPointer();
        list.display();
        System.out.println("Remove at: 3");
        list.remove(3);
        list.display();
        System.out.println("2 from last: " + list.kthFromLast(2));
        System.out.println("Middle: " + list.middle());
        list.removeLast();
        System.out.println("Middle: " + list.middle());*/

        LinkedList list1 = new LinkedList();
        list1.addLast(3);
        list1.addLast(3);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(5);

        System.out.println("Unsorted list: ");
        list1.display();
        list1.removeDuplicates();
        System.out.println("Sorted list: ");
        list1.display();

    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        static boolean hasCycle(Node head) {
            Node s = head;
            Node f = head.next;
            while (f != null) {
                if (s == f) return true;
                s = s.next;
                if (f.next != null) f = f.next.next;
                else return false;
            }
            return false;
        }


        public void removeDuplicates() {
            if (head == null) return;
            Node temp = head;
            while (temp.next != null) {
                if (temp.data == temp.next.data) {
                    if (temp.next.next != null) temp.next = temp.next.next;
                    else temp.next = null;
                } else {
                    temp = temp.next;
                }
            }
        }

        private boolean compare(int current, int next) {
            return current == next;
        }

        static Node mergeLists(Node head1, Node head2) {
            LinkedList list = new LinkedList();
            Node iHead = head1;
            Node jHead = head2;
            while (iHead != null && jHead != null) {
                if (iHead.data <= jHead.data) {
                    list.addLast(iHead.data);
                    iHead = iHead.next;
                } else {
                    list.addLast(jHead.data);
                    jHead = jHead.next;
                }
            }
            while (iHead != null) {
                list.addLast(iHead.data);
                iHead = iHead.next;
            }
            while (jHead != null) {
                list.addLast(jHead.data);
                jHead = jHead.next;
            }
            return list.head;
        }

        public int middle() {
            Node s = head;
            Node f = head;
            while (f.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            }
            return s.data;
        }

        public int kthFromLast(int k) {
            Node s = head;
            Node f = head;
            for (int i = 0; i < k; i++) f = f.next;
            while (f.next != null) {
                s = s.next;
                f = f.next;
            }
            return s.data;
        }

        public Node getKthFromLast(int k) {
            if (k < 0 || k > size) {
                System.out.println("Invalid Argument");
            } else if (k == 0) {
                return tail;
            } else if (k == size - 1) {
                return head;
            } else {
                Node temp = head;
                for (int i = 1; i < size - k; i++) {
                    temp = temp.next;
                }
                return temp;
            }
            return null;
        }

        public void remove(int index) {
            if (index == 0) {
                removeFirst();
            } else if (index == size - 1) {
                removeLast();
            } else if (index < 0 || index >= size) {
                System.out.println("Invalid argument");
            } else {
                Node temp = head;
                for (int i = 1; i < index; i++) temp = temp.next;
                temp.next = temp.next.next;
                size--;
            }
        }

        public void reverseHead() {
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node temp = curr.next;
                curr.next = prev; //update current with prev
                prev = curr; // new prev
                curr = temp; // new curr
            }
            head = prev;
        }

        public void reverseByPointer() {
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node temp = curr.next;
                curr.next = prev; //update current with prev
                prev = curr; // new prev
                curr = temp; // new curr
            }
            Node temp = head;
            head = tail;
            tail = temp;

        }

        public void reverse() {
            int li = 0;
            int ri = size - 1;
            while (li < ri) {
                Node ln = getNode(li);
                Node rn = getNode(ri);
                int temp = ln.data;
                ln.data = rn.data;
                rn.data = temp;
                li++;
                ri--;
            }
        }

        public Node getNode(int index) {
            Node temp = head;
            for (int i = 0; i < index; i++) temp = temp.next;
            return temp;
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                removeFirst();
            } else {
                Node temp = head;
                for (int i = 1; i < size - 1; i++) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
            }
        }

        public void add(int index, int val) {
            if (index > size || index < 0) {
                System.out.println("Invalid argument");
            } else if (index == 0) {
                addFirst(val);
            } else if (index == size) {
                addLast(val);
            } else {
                Node temp = head;
                for (int i = 1; i < index; i++) {
                    temp = temp.next;
                }
                Node node = new Node(val, temp.next);
                temp.next = node;
                size++;
            }
        }

        public void addFirst(int val) {
            Node node = new Node(val, head);
            if (head == null) tail = node;
            head = node;
            size++;
        }

        public int get(int index) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (index > size || index < 0) {
                System.out.println("Invalid argument");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < index; i++) temp = temp.next;
                return temp.data;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }

        public void removeFirst() {
            if (head == null) {
                System.out.println("List is empty");
            } else {
                Node next = head.next;
                if (next != null) {
                    head = next;
                } else {
                    head = tail = null;
                }
                size--;
            }
        }

        public void display() {
            System.out.println(head.data);
            Node temp = head.next;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        public void addLast(int val) {
            Node node = new Node(val, null);
            if (size == 0) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public int size() {
            return size;
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int val, Node node) {
            this.data = val;
            this.next = node;
        }
    }
}
