package org.example.submersible.model;

import java.util.HashSet;
import java.util.Set;


public class Grid {
    private final int width;
    private final int height;
    private final Set<Coordinate> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>();
    }

    public void addObstacle(int x, int y) {
        obstacles.add(new Coordinate(x, y));
    }

    public boolean isWithinBounds(int x, int y) {
        return (x >= 0 && x < width) && (y >= 0 && y < height);
    }

    public boolean isObstacle(int x, int y) {
        return obstacles.contains(new Coordinate(x, y));
    }

    public static class Coordinate {
        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Coordinate)) return false;
            Coordinate other = (Coordinate) obj;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }


    }
}
