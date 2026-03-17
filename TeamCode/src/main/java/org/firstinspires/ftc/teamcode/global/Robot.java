package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

public class Robot extends com.seattlesolvers.solverslib.command.Robot {
    private static final Robot instance = new Robot();

    private MotorEx liftLeft;
    private MotorEx liftRight;
    private MotorGroup liftMotorGroup;

    public void init(final HardwareMap hm) {
        liftLeft = hm.get(MotorEx.class, "liftLeft");
        liftRight = hm.get(MotorEx.class, "liftRight");
        liftMotorGroup = new MotorGroup(liftLeft, liftRight);


    }

    public static Robot getInstance() {
        return instance;
    }


}
