package com.segmentTree.update;

public interface Merger<E> {
    E merge(E a, E b);
}
