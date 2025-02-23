package org.example.submersible.controller;


import org.example.submersible.model.Grid;
import org.example.submersible.model.SubProbe;
import org.springframework.web.bind.annotation.*;
import  org.example.submersible.model.Direction;

@RestController
@RequestMapping("/submarine")
public class SubController {

    private final Grid grid = new Grid(10, 10);
    SubProbe subProbe;


    public SubController() {
        // Example obstacles
        grid.addObstacle(3, 3);
        grid.addObstacle(7, 5);
        subProbe = new SubProbe(0, 0, Direction.N, grid);
    }

    @PostMapping("/move-forward")
    public String moveForward() {
        subProbe.move(1);
        return subProbe.getPositionSummary();
    }

    @PostMapping("/move-backward")
    public String moveBackward() {
        subProbe.move(-1);
        return subProbe.getPositionSummary();
    }

    @PostMapping("/turn-left")
    public String turnLeft() {
        subProbe.turnLeft();
        return subProbe.getPositionSummary();
    }

    @PostMapping("/turn-right")
    public String turnRight() {
        subProbe.turnRight();
        return subProbe.getPositionSummary();
    }

    @GetMapping("/position")
    public String getPosition() {
        return subProbe.getPositionSummary();
    }
}