package com.study.binaryTree.mytest01.binaryTree.stack;

import org.junit.Test;

import java.util.*;

public class E_PriorityQueue {

    public List<Integer> myTopkFrequent(int[] nums, int k) {
        // 先计算每个数的出现次数
        Map<Integer, Integer> frequences = new HashMap<>();
        for (int num : nums) {
            if (frequences.containsKey(num)) {
                frequences.put(num, frequences.get(num) + 1);
            } else {
                frequences.put(num, 1);
            }
        }

        // 使用优先队列，队列里面只保存k个数(Pair<fre, num>) ，默认优先队列使用的是最小堆
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.k.compareTo(o2.k);
            }
        });

        for (Integer num : frequences.keySet()) {
            if (queue.size() >= k) {
                if (queue.peek().k < frequences.get(num)) {
                    queue.poll(); // 先弹出最小堆的堆顶元素
                    queue.add(new Pair<>(frequences.get(num), num)); // 添加新元素
                }
                // 抛弃
            } else {
                queue.add(new Pair<>(frequences.get(num), num));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().v);
        }
        return result;
    }

    public List<Integer> topkFrequent(int[] nums, int k) {

        // 统计每个单词出现的频率
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        // 扫描freq，维护当前出现频率最高的k个元素
        // 在优先队列中，按照频率排序，所以数据对是(频率，元素)的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>((p1, p2) -> {
            return Integer.compare(p1.k, p2.k);
        });

        for (Integer num : freq.keySet()) {
            int numFerq = freq.get(num); // num出现的次数
            if (pq.size() == k) { // 如果优先队列中的元素个数已经达到k个
                if (numFerq > pq.peek().k) { // 如果大于最小堆的堆顶元素
                    pq.poll(); // 把队列中最小元素弹出
                    pq.add(new Pair(numFerq, num));
                }
                // 否则丢弃该元素
            } else {
                pq.add(new Pair(numFerq, num));
            }
        }

        // 从优先队列中取出元素放入list中
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().v);
        }

        return result;
    }

    @Test
    public void test001() {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 6, 6,6,6,6,6};
        List<Integer> ret = myTopkFrequent(nums, 2);
        System.out.println(ret);
    }
}
