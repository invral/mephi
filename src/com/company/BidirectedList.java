package com.company;

public class BidirectedList {

    Node node;
    int size;
    Node firstNode;
    Node lastNode;

//класс который является звеном списка
    private class Node{
        Object value;
        Node next;
        Node prev;

        private Node(){
            this.value = null;
            this.next = null;
            this.prev = null;
        }

        private Node(Object obj){
            this.value = obj;
            this.next = null;
            this.prev = null;
        }

    }
//конструктор класса листа
    public BidirectedList(){
        Node node = new Node();
        this.firstNode = node;
        this.lastNode = node;
        this.node = node;
        this.size = 0;
    }
//вставка в конец
    public void add(Object obj) {
//        проверить сайз и если ничего не добавлял, то закинуть значение в первый нод
        if (this.size == 0){
            node.value = obj;
            this.size = 1;
        }
        else{
            Node node_next = new Node(obj);
            Node tmp = this.lastNode;
            tmp.next = node_next;
            node_next.prev = tmp;
            node_next.next = null;
            this.lastNode = node_next;
            this.size += 1;

//            node_next.prev = lastNode;
//            node_next.next = null;
//            lastNode.next = node_next;
//            lastNode = node_next;

        }
    }
//вставка по индексу
    public void add(Object obj, int x){
        if ((this.size < x) | (x < 0)){
            add(obj);
        }
        else{
            if (x == 0){
              Node start_node = new Node(obj);
              start_node.next = firstNode;
              firstNode.prev = start_node;
              firstNode = start_node;
            }
            else{
                int number = 0;
                Node tmp = firstNode;

                while (number != x){
                    tmp = tmp.next;
                    number +=1;
                }
                Node middle_node = new Node(obj);
                middle_node.prev = tmp.prev;
                middle_node.next = tmp;
                tmp.prev = middle_node;
            }

        }
    }
//выдает размер списка
    public int size(){
        return this.size;
    }
//выдает булевое значение, если в списке есть элемент
    public boolean isEmpty(){
        if (this.size > 0){
            return true;
        }
        else{
            return false;
        }

    }
//возвращает элемент списка по индексу
    public Object get(int x){

        if ((x < 0) | (this.size < x)){
            return  null;
        }
        if (this.size == 0){
            return null;
        }

        boolean find = true;
        Object answer = null;
        Node current  = firstNode;
        int number = 0;

        while (find == true){
            if (number == x){
                find = false;
                answer = current.value;
            }
            else{
                current = current.next;
                number +=1;
            }

        }
        return answer;
    }
//возвращает индекс объекта в списке
    public int indexof(Object obj){
        Node tmp = firstNode;
        boolean check = true;
        int number = 0;

        while (check == true){
            if(tmp.value == obj){
                check = false;
            }
            else{
                if (tmp.next == null){
                    check = false;
                    number = -1;
                }
                tmp = tmp.next;
                number +=1;
            }
        }
        return number;
    }
//вставляет элемент по индексу и возвращает тот, что мы заменили
    public Object set(Object obj, int x){

        int index = 0;
        Node tmp = firstNode;
        Object value ;

        if ((x>this.size) | (x<0)){
            return null;
        }
        while (index < x){
            tmp = tmp.next;
        }
        value = tmp.value;
        tmp.value = obj;

        return value;
    }
//убирает узел в списке
    public Object remove(int x){

        int index = 0;
        Node tmp = firstNode;
        Object value;

        if ((this.size<x)|(x<0)){
            return null;
        }
        while(index<x){
            tmp = tmp.next;
            index +=1;
        }
        Node prev = tmp.prev;
        Node next = tmp.next;
        if (prev != null){
            prev.next = next;
        }
        if (next != null){
            next.prev = prev;
        }
        value = tmp.value;

        return value;
    }
//проверяет наличие элемента в списке
    public boolean contains(Object obj){
        Node tmp = firstNode;

        while (tmp.value!=obj){
            if(tmp.next==null){
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }

}