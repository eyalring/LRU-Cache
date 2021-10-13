package cache;

public class LinkedListItem {
    LinkedListItem head;
    LinkedListItem tail;

    public DataHolder getDataHolder() {
        return dataHolder;
    }

    DataHolder dataHolder;

    public LinkedListItem getHead() {
        return head;
    }

    public void setHead(LinkedListItem head) {
        this.head = head;
    }

    public LinkedListItem getTail() {
        return tail;
    }

    public void setTail(LinkedListItem tail) {

        this.tail = tail;
    }



    public LinkedListItem(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }


    public LinkedListItem next() {
        return head;
    }

    public LinkedListItem previous() {
        return tail;
    }
}
