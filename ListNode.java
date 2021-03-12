public class ListNode {

    private Object object;
    public ListNode next;
    private int value;

    public ListNode() {
        this.object = null;
        this.next = null;
        this.value = 0;
    }

    public ListNode(Object object) {
        this.object = object;
        this.next = null;
    }

    public ListNode(Object object, ListNode next) {
        this.object = object;
        this.next = next;
    }

    public int getValor() {
        return value;
    }

    public void setValor(int value) {
        this.value = value;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isEquals(Object object) {
        if (this.getObject().toString().equals(object.toString())) {
            return true;
        }
        return false;
    }

    public boolean isEquals(ListNode node) {
        if (this.toString().equals(node.toString())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "object=" + object +
                ", next=" + next +
                '}';
    }
}
