package com.company;

import javafx.beans.binding.ObjectBinding;

public class Map {
    Node node;
    int size;
    Node firstNode;
    Node lastNode;
    Object bydefault;

    private class Node {
        Object value;
        Object key;
        Node prev;
        Node next;

        private Node(){
            this.value = null;
            this.key = null;
            this.prev = null;
            this.next = null;
        }

        private Node(Object key, Object value){
            this.value = value;
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

    public Map(){
        Node node = new Node();
        firstNode = node;
        lastNode = node;
        this.node = node;
        size = 0;
    }
//- Положить по ключу значение:
    public void put(Object key, Object value){
        if (size == 0){
            node.value = value;
            node.key = key;
            size = 1;
        }
        else{
          Node tmp = lastNode;
          Node put_node = new Node(key, value);
          tmp.next = put_node;
          put_node.prev = tmp;
          lastNode = put_node;
          size +=1;
        }
    }
//    - Получить по ключу, если значение null, тогда надо вернуть значение по умолчанию,
//    которое задается вторым параметром.
//    Значение по умолчанию необходимо сохранить.
    public Object get(Object key, Object bydefault){
        this.bydefault = bydefault;
        Object check = get(key);

        if (check == null){
            put(key,bydefault);
            return bydefault;
        }
        return key;
    }
    //- Положить по ключу значение:
    public Object get(Object key){
        Node tmp = firstNode;
        boolean check = true;
        Object obj = null;

        while (check==true) {
            if (tmp.key == key){
                obj = tmp.value;
                check = false;
            }
            if (tmp.next!=null){
                tmp = tmp.next;
            }
            else{
                check = false;
            }
        }
        return obj;
    }
//- Удалить по ключу, возвращает текущее значение
    public Object remove(Object key){
        Node tmp = firstNode;
        Object obj = null;

        while (tmp.next != null){
            if (tmp.key == key){
                obj = tmp.value;
                break;
            }
            tmp = tmp.next;
        }

        Node node_prev = tmp.prev;
        Node node_next = tmp.next;
        if (node_prev != null){
            node_prev.next = node_next;
        }
        if (node_next != null){
            node_next.prev = node_prev;
        }

        return obj;
    }
//    - Проверить наличие ключа:
    public boolean keyContains(Object key){
        boolean res = false;
        Node tmp = firstNode;

        while (tmp.next!=null){
            if(tmp.key == key){
                res = true;
                break;
            }
            tmp = tmp.next;
        }
        return res;
    }
// - Получить список ключей:
    public BidirectedList getKeys(){
        //проверить вариант, если список пустой
        Node tmp = firstNode;
        BidirectedList list_keys = new BidirectedList();
        if (size == 0){
            list_keys.add(null);
            return list_keys;
        }

        while (tmp.next != null){
            list_keys.add(tmp.key);
            tmp = tmp.next;
        }
        list_keys.add(tmp.key);
        return list_keys;
    }
//  - Получить список значений:
    public BidirectedList getValues(){
        Node tmp = firstNode;
        BidirectedList list_values = new BidirectedList();
        if (size == 0){
            list_values.add(null);
            return list_values;
        }

        while (tmp.next != null){
            list_values.add(tmp.value);
            tmp = tmp.next;
        }
        list_values.add(tmp.value);
        return list_values;
    }
//  - Получить список пар: ключ, значение:
    public BidirectedList getEntries(){
        Node tmp = firstNode;
        BidirectedList list_entries = new BidirectedList();
        if (size == 0){
            list_entries.add(null);
            return list_entries;
        }

        while (tmp.next != null){
            Object[] tmpArr = new Object[2];
            tmpArr[0] = tmp.key;
            tmpArr[1] = tmp.value;
            list_entries.add(tmpArr);
            tmp = tmp.next;
        }

        Object[] tmpArr = new Object[2];
        tmpArr[0] = tmp.key;
        tmpArr[1] = tmp.value;
        list_entries.add(tmpArr);

        return  list_entries;
    }
//  - Размер словаря:
    public int size(){
        return size;
    }
//  - Пустой или нет:
    public boolean isEmpty(){
        if (size>0){
            return true;
        }
        return false;
    }



}
