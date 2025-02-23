package org.example;

import org.example.submersible.model.Grid;
import org.example.submersible.model.SubProbe;
import org.example.submersible.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for App.
 */
public class AppTest
{
    @Test
    public void testInitialPosition() {
        Grid grid = new Grid(10, 10);
        SubProbe subProbe =  new SubProbe(0, 0, Direction.N, grid);
        assertEquals(0, subProbe.getX());
        assertEquals(0, subProbe.getY());
        assertTrue(subProbe.getVisitedPositions().contains("(0, 0)"));
    }

    @Test
    void testMoveForward() {
        Grid grid = new Grid(10, 10);
        SubProbe subProbe =  new  SubProbe(0, 0, Direction.N, grid);
        subProbe.move(1);
        assertEquals(1, subProbe.getY());
    }

    @Test
    public void testMoveBackward() {
        Grid grid = new Grid(10, 10);
        SubProbe subProbe =  new SubProbe(1, 1, Direction.E, grid);
        subProbe.move(-1);
        assertEquals(0, subProbe.getX());
        assertEquals(1, subProbe.getY());
    }

    @Test
    public void testTurning() {
        Grid grid = new Grid(10, 10);
        SubProbe subProbe =  new SubProbe(1, 1, Direction.N, grid);
        subProbe.turnRight();
        // After turning right from North, the expected direction is East.
        subProbe.turnLeft();
        // After turning left from East, the expected direction is North again.
        assertEquals(Direction.N, subProbe.getDirection());
    }


    @Test
    public void testEdgeOfGrid() {
        Grid grid = new Grid(10, 4);
        SubProbe subProbe =  new SubProbe(0, 3, Direction.N, grid);
        subProbe.move(1);
        assertEquals(0, subProbe.getX());
        assertEquals(3, subProbe.getY());
    }

    @Test
    void testTurnLeft() {
        Grid grid = new Grid(10, 10);
        SubProbe subProbe =  new  SubProbe(0, 0, Direction.N, grid);
        subProbe.turnLeft();
        assertEquals(Direction.W, subProbe.getDirection());
    }

    @Test
    void testObstacle() {
        Grid grid = new Grid(10, 10);
        grid.addObstacle(1, 0);
        SubProbe subProbe =  new  SubProbe(0, 0, Direction.E, grid);
        subProbe.move(1);
        assertEquals(0, subProbe.getY()); // Should not move due to obstacle
    }
}
