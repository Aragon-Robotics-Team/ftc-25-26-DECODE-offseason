package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

public class LiftSubsystem extends SubsystemBase {
    private MotorEx liftLeft;
    private MotorEx liftRight;
    private MotorGroup liftMotorGroup;
    public LiftSubsystem(final HardwareMap hardwareMap) {
        liftLeft = hardwareMap.get(MotorEx.class, "liftLeft");
        liftRight = hardwareMap.get(MotorEx.class, "liftRight");
        liftMotorGroup = new MotorGroup(liftLeft, liftRight);
    }
    public void up() {
        //set pid target to up
    }
    public void down() {
        //set pid target to down
    }
}
