// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Motor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

public class SparkPID extends SubsystemBase implements MotorIO {
  private final CANSparkMax m_motor;
  private final RelativeEncoder m_encoder;
  private final SparkPIDController m_pidController;

  /** Creates a new Motor. */
  public SparkPID(int motorCANID) {
    m_motor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);
    m_encoder = m_motor.getEncoder();
    m_pidController = m_motor.getPIDController();

    m_encoder.setPositionConversionFactor(Math.PI * 2.0 / 42.0);
    m_pidController.setPositionPIDWrappingEnabled(false); // If the encoder where absolute, this would be true
  }

  @Override
  public void periodic() {  
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    m_motor.set(speed);
  }

  public double getPosition() {
    return m_encoder.getPosition();
  }

  public void setMotorPosition(double position) {
    m_pidController.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  public void stop(){
    m_motor.stopMotor();
  }

  public void setPID(double kP, double kI, double kD) {
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
  }

  public void setP(double p) {
    m_pidController.setP(p);
  }

  public void setI(double i) {
    m_pidController.setI(i);
  }

  public void setD(double d) {
    m_pidController.setD(d);
  }

  public double getP(){
    return m_pidController.getP();
  }

  public double getI(){
    return m_pidController.getI();
  }

  public double getD(){
    return m_pidController.getD();
  }

  public double getSpeed(){
    return m_motor.get();
  }
}
