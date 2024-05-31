// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Motor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  MotorIO m_motor;
  /** Creates a new Motor. */
  public Motor(MotorIO motorIO) {
    m_motor = motorIO;
  }

  @Override
  public void periodic() {
    m_motor.periodic();
    SmartDashboard.putNumber("Motor Position", m_motor.getPosition());
    SmartDashboard.putNumber("Motor Speed", m_motor.getSpeed());
    SmartDashboard.putNumber("Motor P", m_motor.getP());
    SmartDashboard.putNumber("Motor I", m_motor.getI());
    SmartDashboard.putNumber("Motor D", m_motor.getD());
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    m_motor.setSpeed(speed);
  }

  public double getPosition() {
    return m_motor.getPosition();
  }

  public void setMotorPosition(double position) {
    m_motor.setMotorPosition(position);
  }

  public void stop(){
    m_motor.stop();
  }

  public void setPID(double kP, double kI, double kD) {
    m_motor.setPID(kP, kI, kD);
  }

  public void setP(double p) {
    m_motor.setP(p);
  }

  public void setI(double i) {
    m_motor.setI(i);
  }

  public void setD(double d) {
    m_motor.setD(d);
  }
}
