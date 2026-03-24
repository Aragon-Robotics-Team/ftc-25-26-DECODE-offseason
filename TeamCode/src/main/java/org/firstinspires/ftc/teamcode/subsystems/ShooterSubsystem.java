package org.firstinspires.ftc.teamcode.subsystems;
import static org.firstinspires.ftc.teamcode.global.Constants.*;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;

import org.firstinspires.ftc.teamcode.global.Robot;


public class ShooterSubsystem extends SubsystemBase {
     private final Robot robot = Robot.getInstance();
     private final PIDFController flywheelController = new PIDFController(FLYWHEEL_PIDF_COEFFICIENTS);

     public double getTargetTicks() {
          return flywheelController.getSetPoint();
     }
     public double getVelocityTicks() {
          return robot.shooter.getCorrectedVelocity();
     }
     public boolean isAtTargetVelocity() {
          return Math.abs(flywheelController.getSetPoint() - getVelocityTicks()) < 50;
     }
     public void setPIDF(double p, double i, double d, double f) {
          this.flywheelController.setPIDF(p,i,d,f);
     }
     public void setTargetTicks(double ticksPerSec) {
          flywheelController.setSetPoint(Math.min(ticksPerSec, SHOOTER_MAX_VELOCITY));
     }

     public void init() {
          setTargetTicks(0);
     }

     public void periodic() {
          robot.shooter.set(flywheelController.calculate(getVelocityTicks()));
     }
}
