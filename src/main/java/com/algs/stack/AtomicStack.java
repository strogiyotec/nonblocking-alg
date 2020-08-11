package com.algs.stack;

import java.util.concurrent.atomic.AtomicReference;

final class AtomicStack {
    private AtomicReference<SingleThreadNode> heap = new AtomicReference<>();

    void push(final int value) {
        while (true) {
            var current = this.heap.get();
            var upd = new SingleThreadNode(current, value);
            if (this.heap.compareAndSet(current, upd)) return;
            else {
                System.out.printf("Thread %s will repeat\n", Thread.currentThread().getName());
            }
        }
    }

    int pop() {
        while (true) {
            final SingleThreadNode node = this.heap.get();
            if (node == null) {
                return -1;
            }
            if (this.heap.compareAndSet(node, node.getNext())) return node.getValue();
        }
    }
}
