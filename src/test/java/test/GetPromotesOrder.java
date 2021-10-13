package test;

import cache.DataHolder;
import cache.LinkedListItem;
import cache.MyLinkedList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetPromotesOrder {
    public static int MAX_NO_OF_ELEMENTS = 3;

    @Test
    public void getPromotesOrder_promotingItemByGetAfterOverFlow_ItemRemainsInCache(){
        MyLinkedList list = new MyLinkedList(MAX_NO_OF_ELEMENTS);
        list.push(new LinkedListItem(new DataHolder("item1")));
        list.push(new LinkedListItem(new DataHolder("item2")));
        list.push(new LinkedListItem(new DataHolder("item3")));
        //item1 to be promoted to be first and to be  deleted last possible.
        list.get("item1");
        list.push(new LinkedListItem(new DataHolder("item4")));
        LinkedListItem item = list.get("item1");

        assertThat(item,is(not(nullValue())));
    }
}
