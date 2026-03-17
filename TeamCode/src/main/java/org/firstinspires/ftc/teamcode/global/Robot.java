package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class Robot extends com.seattlesolvers.solverslib.command.Robot {
    private static final Robot instance = new Robot();
    public static Robot getInstance() {
        return instance;
    }
    public MotorGroup shooterMotors;

    public ShooterSubsystem shooterSubsystem;

    public void init(HardwareMap hMap) {
        shooterMotors = new MotorGroup(
                new MotorEx(hMap, "shooter1").setInverted(true),
                new MotorEx(hMap, "shooter2").setInverted(false)
        );
        shooterMotors.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
        shooterMotors.setRunMode(Motor.RunMode.RawPower);
        shooterMotors.set(0);
    }
}
