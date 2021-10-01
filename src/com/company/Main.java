package com.company;

public class Main {

    public static void main(String[] args) {

        int x =5;
        int x1 = 7;
        String y= "Hello";
        BidirectedList bl = new BidirectedList();
        bl.add(null);
        bl.add(x);
        bl.add(y,1);
        int size_bl = bl.size();
        boolean isEmptyCheck = bl.isEmpty();
        Object element = bl.get(0);
        int indexOfY = bl.indexof(y);
        Object copy_x = bl.set(x1,0);
        boolean keyContains_x1 = bl.contains(x1);
        bl.remove(0);

        int x_key = 123;
        String x1_key = "HEllO_HEY";
        boolean y_key = true;
        String key = "fsahjfa";

        Map map = new Map();
        map.put(x_key,x);
        map.put(y_key,y);
        Object getXkey = map.get(x_key);
        Object getKey = map.get(key, x1);
        map.remove(key);
        BidirectedList l_keys = map.getKeys();
        BidirectedList l_values = map.getValues();
        BidirectedList l_entries = map.getEntries();
        int mapSize = map.size();
        boolean checkKeyContains = map.keyContains(key);
        boolean MapisEmptyCheck = map.isEmpty();




    }
}
