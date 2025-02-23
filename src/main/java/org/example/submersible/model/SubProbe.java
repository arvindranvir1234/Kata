package org.example.submersible.model;


import java.util.ArrayList;
import java.util.List;

public class SubProbe {

    private int x;
    private int y;
    private Direction direction;
    private final Grid grid;
    private final List<String> visitedPositions;

    public SubProbe(int x, int y, Direction direction, Grid grid) {
        if (!grid.isWithinBounds(x, y)) {
            throw new IllegalArgumentException("Init Not within the grid");
        }
        if (grid.isObstacle(x, y)) {
            throw new IllegalArgumentException("Init is an obstacle");
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
        this.visitedPositions = new ArrayList<>();
        recordPosition();
    }

    public void move(int step) {
        int newX = x;
        int newY = y;
        switch (direction) {
            case N:
                newY += step;
                break;
            case S:
                newY -= step;
                break;
            case E:
                newX += step;
                break;
            case W:
                newX -= step;
                break;
        }
        if (grid.isWithinBounds(newX, newY) && !grid.isObstacle(newX, newY)) {
            x = newX;
            y = newY;
            recordPosition();
        }
    }

    public void turnLeft() {

        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    private void recordPosition() {
        visitedPositions.add(String.format("(%d, %d)", x, y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<String> getVisitedPositions()
    {
        return visitedPositions;
    }

    public String getPositionSummary() {
        return String.format("Current Position: (%d, %d), Direction: %s, Visited: %s",
                x, y, direction, visitedPositions);
    }
}