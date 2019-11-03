package com.segmentTree.leetcode;

public interface Merger<E> {
    E merge(E a, E b);
}
