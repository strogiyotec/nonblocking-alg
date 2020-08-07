package com.algs.stack;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
final class SingleThreadNode {

    private final SingleThreadNode next;

    private final int value;
}
