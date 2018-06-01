package com.example.philip.vibs;

import com.example.philip.vibs.model.CalendarItem;
import com.example.philip.vibs.model.InboxItem;

import java.util.List;

public  class DataHolder {

    public static List<InboxItem> inboxItemList;
    public static List<Object> feedObjectList;
    public static boolean swipeRight, swipeLeft;
    public static List<CalendarItem> calendarItemsList;

    public List<InboxItem> getInboxItemList() {
        return inboxItemList;
    }

    public void setInboxItemList(List<InboxItem> inboxItemList) {
        this.inboxItemList = inboxItemList;
    }

    //test
    public List<Object> getFeedObjectList() {
        return feedObjectList;
    }

    public void setFeedObjectList(List<Object> feedObjectList) {
        this.feedObjectList = feedObjectList;
    }

    public static boolean isSwipeRight() {
        return swipeRight;
    }

    public static void setSwipeRight(boolean swipeRight) {
        DataHolder.swipeRight = swipeRight;
    }

    public static boolean isSwipeLeft() {
        return swipeLeft;
    }

    public static void setSwipeLeft(boolean swipeLeft) {
        DataHolder.swipeLeft = swipeLeft;
    }

    public static List<CalendarItem> getCalendarItemsList() {
        return calendarItemsList;
    }

    public static void setCalendarItemsList(List<CalendarItem> calendarItemsList) {
        DataHolder.calendarItemsList = calendarItemsList;
    }
}
