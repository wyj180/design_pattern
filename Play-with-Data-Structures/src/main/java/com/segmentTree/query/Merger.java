package com.segmentTree.query;

public interface Merger<E> {
    E merge(E a, E b);
}
