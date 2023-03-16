// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class RetractArm extends CommandBase {

  private final Arm m_arm;
  private final DoubleSupplier m_triggerAxis;

  public RetractArm(Arm arm, DoubleSupplier triggerAxis) {
    m_arm = arm;
    m_triggerAxis = triggerAxis;
    addRequirements(m_arm);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_arm.retract(getTriggerAxis());
  }

  @Override
  public void end(boolean interrupted) {
    m_arm.stop();
  }

  @Override
  public boolean isFinished() {
    return (getTriggerAxis() < .2f) || m_arm.isFullyRetracted();
  }

  /**
   * Don't want to think about the sign of the trigger axis so getting abs
   * here to use when we want to know value.
   */
  private double getTriggerAxis() {
    return Math.abs(m_triggerAxis.getAsDouble());
  }
}
