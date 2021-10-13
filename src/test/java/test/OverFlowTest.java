package test;

import cache.DataHolder;
import cache.LinkedListItem;
import cache.MyLinkedList;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class OverFlowTest {
    public static int MAX_NO_OF_ELEMENTS = 3;

    @Test
    public void overFlowTest_itemIsBeingAddedANdOverFLows_sizeOfCacheItemsRemainMax(){
        MyLinkedList list = new MyLinkedList(MAX_NO_OF_ELEMENTS);
        list.push(new LinkedListItem(new DataHolder("item1")));
        list.push(new LinkedListItem(new DataHolder("item2")));
        list.push(new LinkedListItem(new DataHolder("item3")));
        list.push(new LinkedListItem(new DataHolder("item4")));
        assertThat(list.getSize(),equalTo(MAX_NO_OF_ELEMENTS));
    }
    @Test
    public void overFlowTest_itemIsBeingAddedAndOverFLows_1stItemIsRemoved(){
        MyLinkedList list = new MyLinkedList(MAX_NO_OF_ELEMENTS);
        list.push(new LinkedListItem(new DataHolder("item1")));
        list.push(new LinkedListItem(new DataHolder("item2")));
        list.push(new LinkedListItem(new DataHolder("item3")));
        list.push(new LinkedListItem(new DataHolder("item4")));
        assertThat(list.get("item1"),is(CoreMatchers.nullValue()));
    }
}
