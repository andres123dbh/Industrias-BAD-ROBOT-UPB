import java.util.Iterator;
import java.util.Arrays;
import static java.lang.System.*;

public class List implements ListInterface, Iterable<ListNode> {

    private ListNode inode;
    private int size;

    public ListNode head;
    public ListNode tail;

    public List() {
        clear();
    }

    public List(Object object) {
        add(object);
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object getHead() {
        return head;
    }

    @Override
    public Object getTail() {
        return tail;
    }

    @Override
    public ListNode search(Object object) {
        Iterator<ListNode> i = this.iterator();
        ListNode inode;
        while ((inode = i.next()) != null) {
            if (inode.getObject().toString().equals(object.toString())) {
                return inode;
            }
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public String toString() {
        return "Camino a tomar: Inicio=" + head ;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        try {
            if (node.next == null) {
                add(object);
            } else {
                ListNode newNode = new ListNode(object);
                newNode.next = node.next;
                node.next = newNode;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean insert(Object ob, Object object) {
        try {
            if (ob != null) {
                ListNode node = this.search(ob);
                if (node != null) {
                    return insert(node, object);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            if (isEmpty()) {
                head = new ListNode(object);
                tail = head;
            } else {
                head = new ListNode(object, head);
            }
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        try {
            if (isEmpty()) {
                head = new ListNode(object);
                tail = head;
            } else {
                tail.next = new ListNode(object);
                tail = tail.next;
            }
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(ListNode node) {
        return true;
    }

    @Override
    public boolean remove(Object object) {
        ListNode ob = this.search(object);
        ListNode node = head;
        if (ob != null){
            while (node != ob){
                node = node.next;
            }
            ListNode nodetemp = node;
            node = nodetemp.next;
            if(node.next == null){
                tail = node;
            }
            nodetemp.next = null;
            size --;
        }
        return true;

    }

    public int getPosicion(Object object){
        if (head != null) {
            ListNode node = head;
            ListNode ob = this.search(object);
            int cont = 0;
            while(ob != node){
                cont ++;
                node = node.next;
            }
            return cont;
        } else {
            return 0;
        }
    }

    public void removehead() {
        if (head != null){
        ListNode node = head;
        head = head.next;
        node.next = null;
            if (head == null){
                tail = null;
            }
        size --;
        }
    }

    public void removetail() {
        if (head != null){
            if (head.next == null){
                head = null;
                tail = null;
                size = 0;
            }
            else{
                ListNode node = head;
                while (node.next.next != null){
                    node = node.next;
                }
                tail = node;
                node.next = null;
                size --;
            }
        
        }
    }

    public void removeelementPos(int n) {
        if (head != null){
            if(n == 0){
                ListNode node = head;
                head = head.next;
                node.next = null;
                    if (head == null)
                    {
                        tail = null;
                    }
                size --;
            }
            else if (n < size) {
                ListNode node = head;
                int cont = 0;
                while (cont < (n - 1)){
                    node = node.next;
                    cont ++;
                }
                ListNode nodetemp = node.next;
                node.next = nodetemp.next;
                if(node.next == null){
                    tail = node;
                }
                nodetemp.next = null;
                size --;
            }
        }
    }

    @Override
    public boolean contains(Object object) {
        if (object != null){
            return true;
        }
        else{
            return false;
        }
        
    }


    public Object[] toArray() {
        return new Object[0];
    }
    

    @Override
    public Object[] toArray(Object[] object) {
        ListNode listelements = head;
        for (int i = 0; i < size; i++){
            object[i] = listelements.getObject();
            listelements = listelements.next;
        }
        return object;
    }

    @Override
    public Object getBeforeTo() {
        return null;
    }

    @Override
    public ListNode getBeforeTo(ListNode node) {
        ListNode nodeh = head;
        if(contains(node) == true){
            if(nodeh != null){
                if(head == node){
                    return null;
                }
                else{
                    while(nodeh.next != node){
                        nodeh = nodeh.next;
                    }
                    return nodeh;
                }
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
        
    }

    @Override
    public Object getNextTo() {
        ListNode node = head;
        return node.next;
    }

    @Override
    public Object getNextTo(ListNode node) {
        return node.next.getObject();
    }

    @Override
    public List subList(ListNode from, ListNode to) {
        List element = new List();
        while(from != to){
            element.add(from.getObject());
            from = from.next;
        }
        element.add(from.getObject());
        return element;
    }

    @Override
    public List sortList() {
        String[] newArray = new String[size];
        ListNode listelements = head;
        for (int i = 0; i < size; i++){
            String elementstring =listelements.getObject().toString();
            newArray[i] = elementstring;
            listelements = listelements.next;
        }
        Arrays.sort(newArray);
        List listsort = new List();
        for (int i = 0; i < size; i++) {
            listsort.add(newArray[i]);
        }
        return listsort;
    }

    @Override
    public Iterator<ListNode> iterator() {
        inode = head;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return inode.next != null;
            }

            @Override
            public ListNode next() {
                if (inode != null) {
                    ListNode tmp = inode;
                    inode = inode.next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
    }

    public void rec(ListNode node) {
        if (node.next != null) {
            rec(node.next);
            // <- ;) ->
        }
        out.println(node.toString());
    }

}