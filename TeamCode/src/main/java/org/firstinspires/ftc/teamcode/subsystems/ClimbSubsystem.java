package org.firstinspires.ftc.teamcode.subsystems;

import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.global.Robot;
import static org.firstinspires.ftc.teamcode.global.Constants.*;

public class ClimbSubsystem extends SubsystemBase {
    private final Robot robot = Robot.getInstance();
    public enum LiftState {
        DOWN, UP
    }
    public LiftState currentState = LiftState.DOWN; //for debug

    public void setClimb(LiftState state) {
        switch(state) {
            case DOWN:
                robot.liftLeft.setPosition(LEFT_CLIMB_DOWN);
                robot.liftRight.setPosition(RIGHT_CLIMB_DOWN);
                break;
            case UP:
                robot.liftLeft.setPosition(LEFT_CLIMB_UP);
                robot.liftRight.setPosition(RIGHT_CLIMB_UP);
                break;
        }
        currentState = state;
    }
}
