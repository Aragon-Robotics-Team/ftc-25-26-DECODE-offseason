package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.global.Robot;

public class ResetSpindexer extends CommandOpMode {
    private final Robot robot = Robot.getInstance();

    @Override
    public void initialize() {
        super.reset();
        robot.init(hardwareMap);
        robot.spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.spindexerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


}
