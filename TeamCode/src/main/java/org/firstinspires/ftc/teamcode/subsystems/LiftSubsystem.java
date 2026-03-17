package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

import org.firstinspires.ftc.teamcode.global.Robot;

public class LiftSubsystem extends SubsystemBase {
    private final Robot robot = Robot.getInstance();
    public enum LiftState {
        DOWN, UP
    }

    public LiftSubsystem() {

    }
    public void up() {
        //set pid target to up
    }
    public void down() {
        //set pid target to down
    }
}
