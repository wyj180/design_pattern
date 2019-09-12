package com.study.duilie;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 给定一个非空数组，返回前k个出现频率最高的元素
public class TopkFrequent {

    @Test
    public void test01() {
        int k = 2;
        int[] arr = {1,1,1,2,2,3};

        // 构建 <元素，出现频率>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // 使用优先队列 <频率，元素>
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Integer key : map.keySet()){
            Integer value = map.get(key);
            if(queue.size() == k){ // 元素个数已经达到k个,根据value的大小判断是否保留该元素
                if(queue.peek().getKey() < value){
                    queue.poll();
                    queue.add(new Pair<>(value, key));
                }
            } else {
                queue.add(new Pair<>(value, key));
            }
        }

        // 遍历queue
        while (!queue.isEmpty()){
            System.out.print(queue.poll().getValue() + " ");
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Pair<Integer, Integer> v1 = new Pair<>(1, 333);
        Pair<Integer, Integer> v2 = new Pair<>(2, 22);
        Pair<Integer, Integer> v3 = new Pair<>(3, 11);

        queue.add(v1);
        queue.add(v2);
        queue.add(v3);

        while (!queue.isEmpty()){
            System.out.println(queue.poll().getKey());
        }
    }

}
