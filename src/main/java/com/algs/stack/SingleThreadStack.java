package com.algs.stack;

final class SingleThreadStack {
    private SingleThreadNode head;

    int pop() {
        if (this.head == null) {
            return -1;
        }
        var value = this.head.getValue();
        this.head = this.head.getNext();
        return value;
    }

    void push(final int value) {
        if (this.head == null) {
            this.head = new SingleThreadNode(null, value);
        } else {
            final SingleThreadNode oldHead = this.head;
            this.head = new SingleThreadNode(oldHead, value);
        }
    }

}
