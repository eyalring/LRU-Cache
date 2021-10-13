package cache;


import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class CacheRun {
    public static int MAX_NO_OF_ELEMENTS = 3;

    public static void main (String [] args){

        MyLinkedList list = new MyLinkedList(MAX_NO_OF_ELEMENTS);
        list.push(new LinkedListItem(new DataHolder("item1")));
        list.push(new LinkedListItem(new DataHolder("item2")));
        list.push(new LinkedListItem(new DataHolder("item3")));
        list.push(new LinkedListItem(new DataHolder("item4")));
        list.push(new LinkedListItem(new DataHolder("item5")));

        list.get("item3");
    }

    private static void getItemFromCache(HashMap<String,DataHolder> dictionary, LinkedList<DataHolder> listOfCacheItems, String name) {
        DataHolder dataItem = dictionary.get(name);
        if(dataItem != null){
            listOfCacheItems.remove(dataItem);
            listOfCacheItems.push(dataItem);

        }

    }

    private static void putItemInCache(HashMap<String,DataHolder> dictionary, LinkedList<DataHolder> listOfCacheItems, String name) {
        DataHolder dataItem = new DataHolder(name);
        listOfCacheItems.push(dataItem);
        if(listOfCacheItems.size()>MAX_NO_OF_ELEMENTS) {
            DataHolder lastdataItem = listOfCacheItems.removeLast();
            dictionary.remove(lastdataItem.getName());
        }
        dictionary.put(name,dataItem);
    }

}
