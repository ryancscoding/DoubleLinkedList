public class DoublyLinkedList <T extends Comparable<T>>{
    NodeType<T> head;
    NodeType<T> tail;

    DoublyLinkedList(){

    }

    void insertItem(T item){
        if(head == null){
            head = new NodeType<T>();
            head.info = item;
        } else {
            NodeType<T> main = head;
            NodeType<T> trail = new NodeType<T>();
            trail.next = head;
            while(true){
                if(main == null){
                    trail.next = new NodeType<T>();
                    trail.next.info = item;
                    tail = trail.next;
                    trail.next.back = trail;
                    break;
                } else if (main.info.compareTo(item)>0){
                    trail.next = new NodeType<T>();
                    trail.next.info = item;
                    trail.next.next = main;
                    trail.next.back = trail;
                    break;
                }
                main = main.next;
                trail = trail.next;
            }
        }
    }

    int length(){
        if (head == null){
            return -1;
        }
        int length = 0;
        NodeType curr = head;
        while(true){
            if(curr == null){
                break;
            }
            curr = curr.next;
            length++;
        }
        return length;
    }

    void print(){
        NodeType<T> curr = head;
        while(true){
            if (curr == null){
                break;
            }
            System.out.print(curr.info);
            curr = curr.next;
        }
    }

    void deleteItem(T item){
        NodeType<T> curr = head;
        while(true){
            if (curr.info.compareTo(item)>0){
                curr.back = curr.back.back;
                curr.back.next = curr.back.next.next;
                break;
            }
            curr = curr.next;
            if (curr == null){
                System.out.println("Error: No such item in List");
                break;
            }
        }
    }

    void printReverse(){
        NodeType<T> curr = tail;
        while(true){
            if(curr == null){
                break;
            }
            System.out.print(curr.info);
            curr = curr.back;
        }
    }
    void deleteSubsection(T lowerbound, T upperbound){
        NodeType<T> curr = head;
        while(true){
            if((curr.info.compareTo(lowerbound)>0 || curr.info.compareTo(lowerbound) == 0 )&&( curr.info.compareTo(upperbound) == 0 || curr.info.compareTo(upperbound)<0)){
                curr.back.next = curr.next;
                curr.next.back = curr.back;
            }
            curr = curr.next;
            if(curr == null){
                break; //does this work???
            }
        }
    }

    void reverseList(){
        NodeType<T> curr = head;
        NodeType<T> temp;
        while(true){
            if(curr == null){
                break;
            }
            temp = curr.back;
            curr.back = curr.next;
            curr.next = temp;

            curr = curr.back;
        }
    }

    void swapAlternate(){
        NodeType<T> curr = head;
        NodeType<T> temp;
        if(curr == null){
            return;
        }
        while(curr.next != null){

            if(curr.back != null){
                curr.back.next = curr.next;
            } else {
                head = curr.next;
            }
            curr.next.back = curr.back;

            curr.back = curr.next;
            curr.next = curr.next.next;

            if(curr.next != null){
                curr.next.back = curr;
            }
            if(curr.back != null){
                curr.back.next = curr;
            }

            curr = curr.next;
        }
    }
}
