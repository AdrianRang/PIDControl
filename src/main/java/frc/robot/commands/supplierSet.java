// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor.Motor;

public class supplierSet extends Command {
  Motor m_motor;
  Supplier<Double> m_angleSupplier;
  /** Creates a new supplierSet. */
  public supplierSet(Motor m_motor, Supplier<Double> angleSupplier) {
    this.m_motor = m_motor;
    m_angleSupplier = angleSupplier;

    addRequirements(m_motor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_motor.setMotorPosition(m_angleSupplier.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
