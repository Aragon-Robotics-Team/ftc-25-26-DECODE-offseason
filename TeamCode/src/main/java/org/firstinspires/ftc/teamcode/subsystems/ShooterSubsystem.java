package org.firstinspires.ftc.teamcode.subsystems;
import static org.firstinspires.ftc.teamcode.global.Constants.*;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;

import org.firstinspires.ftc.teamcode.global.Robot;


public class ShooterSubsystem extends SubsystemBase {
     private final Robot robot = Robot.getInstance();
     private final PIDFController flywheelController = new PIDFController(FLYWHEEL_PIDF_COEFFICIENTS);
     private double targetHoodAngle = MIN_HOOD_ANGLE;

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
     public void setTargetLinearSpeed(double vel) {
          double ticksPerRev = 28.0;
          double flywheelDiameter = 2.83465;
          double gearRatio = 32.0 / 24.0; //
          double flywheelRPS = vel / (Math.PI * flywheelDiameter);
          double motorRPS = flywheelRPS / gearRatio;
          double targetTicksPerSec = motorRPS * ticksPerRev;
          flywheelController.setSetPoint(targetTicksPerSec);
     }
     public double getFlywheelLinearSpeed() {
          double ticksPerRev = 28.0;
          double flywheelDiameter = 2.83465; //72 mm to inches
          double gearRatio = 32.0 / 24.0;
          return robot.shooter.getCorrectedVelocity() / ticksPerRev * gearRatio * Math.PI * flywheelDiameter;
     }

     public void init() {
          setTargetTicks(0);
     }

     public void periodic() {
          robot.shooter.set(flywheelController.calculate(getVelocityTicks()));
     }
}
