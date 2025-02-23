package org.example.submersible.model;

public enum Direction {
    N, E, S, W;

    public Direction left() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
            default: throw new IllegalStateException("Invalid direction");
        }
    }

    public Direction right() {
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
            default: throw new IllegalStateException("Invalid direction");
        }
    }
}
