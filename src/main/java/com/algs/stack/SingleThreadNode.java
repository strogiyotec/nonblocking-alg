package com.algs.stack;

final class SingleThreadNode {

    private final SingleThreadNode next;

    private final int value;

    SingleThreadNode(final SingleThreadNode next, final int value) {
        this.next = next;
        this.value = value;
    }

    SingleThreadNode getNext() {
        return next;
    }

    int getValue() {
        return value;
    }
}
