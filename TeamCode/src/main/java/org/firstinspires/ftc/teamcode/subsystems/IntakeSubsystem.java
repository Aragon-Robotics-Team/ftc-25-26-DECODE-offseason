package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.global.Constants;
import org.firstinspires.ftc.teamcode.global.Robot;

public class IntakeSubsystem extends SubsystemBase {
    private final Robot robot = Robot.getInstance();
    public enum IntakeState {
        INTAKE_IN, INTAKE_STILL, INTAKE_OUT
    }

    public IntakeState currentState = IntakeState.INTAKE_STILL; //for debug

    public void setIntake(IntakeState state) {
        switch(state) {
            case INTAKE_IN:
                robot.intakeMotor.setPower(Constants.INTAKE_MOTOR_IN);
                currentState = state;
                break;
            case INTAKE_STILL:
                robot.intakeMotor.setPower(0);
                currentState = state;
                break;
            case INTAKE_OUT:
                robot.intakeMotor.setPower(Constants.INTAKE_MOTOR_OUT);
                currentState = state;
                break;
        }
    }

}



