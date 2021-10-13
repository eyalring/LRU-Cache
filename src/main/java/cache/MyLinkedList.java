package cache;

import java.lang.reflect.Array;
import java.util.HashMap;

public class MyLinkedList {
    LinkedListItem [] arrayOfItems;
    HashMap<String,LinkedListItem> mapOfItems = new HashMap<>();
    int maxIndex;
    int size = 0;
    LinkedListItem lastItem ;
    LinkedListItem firstItem ;
    LinkedListItem lastItemInserted;
    int max_no_of_elements;

    public MyLinkedList(int max_no_of_elements) {
        arrayOfItems = (LinkedListItem[]) Array.newInstance(LinkedListItem.class,max_no_of_elements*5);
        this.maxIndex = 0;
        this.size=0;
        firstItem= null;
        lastItem = null;
        this.max_no_of_elements = max_no_of_elements;
    }

    public int getSize() {
        return size;
    }
    public void push(LinkedListItem item) {
        arrayOfItems[maxIndex] = item;
        item.getDataHolder().setIndex(maxIndex);
        attachTailAndHeadForNewItem(item,firstItem);
        maxIndex++;
        size++;
        updateLastItem(item);
        updateFirstItem(item);
        addItemToHashMap(item);
        updateLastInsertedItem(item);
        removeIfOverFlow();


    }

    private void addItemToHashMap(LinkedListItem item) {
        mapOfItems.put(item.getDataHolder().getName(),item);
    }

    private void updateLastInsertedItem(LinkedListItem item) {
        lastItemInserted=item;
    }

    private void updateFirstItem(LinkedListItem item) {
        firstItem=item;
    }

    private void updateLastItem(LinkedListItem item) {
        if(size==1){
            lastItem=item;
        }
    }

    private void removeIfOverFlow() {
        if(size>max_no_of_elements){
            size--;
            int indexToRemove = lastItem.getDataHolder().getIndex();
            mapOfItems.remove(lastItem.getDataHolder().getName());
            lastItem = lastItem.head;
            lastItem.tail=null;
            arrayOfItems[indexToRemove] = null;
        }
    }

    private void attachTailAndHeadForNewItem(LinkedListItem item, LinkedListItem lastItemInserted) {
        item.setTail(lastItemInserted);
        if(lastItemInserted !=null){
            lastItemInserted.setHead(item) ;
        } else{
            //do nothing
        }
    }


    public LinkedListItem get(String itemName) {
        LinkedListItem item = mapOfItems.get(itemName);

        if(item !=null){
            if(item == lastItem){
                LinkedListItem lastItemToBeDeleted = lastItem;
                lastItem = lastItem.head;
                lastItem.tail=null;
            }
            item.setHead(null);
            item.setTail(firstItem);
            firstItem.setHead(item);
            firstItem = item;
            return item;
        }else{
            return null;
        }
    }
}
