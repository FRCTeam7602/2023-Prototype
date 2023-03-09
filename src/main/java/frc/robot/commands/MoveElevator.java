// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.IntSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class MoveElevator extends CommandBase {
  /** Creates a new ElevatorJoystick. */

  private final Elevator m_elevator;
  private final IntSupplier m_pov;
  private boolean moving;

  public MoveElevator(Elevator elevator, IntSupplier pov) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = elevator;
    m_pov = pov;
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    moving = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_pov.getAsInt() > -1){
    System.out.println("POV");
    }
    if(m_pov.getAsInt() == 0){
      m_elevator.moveUp();
      moving = true;
    }
    if(m_pov.getAsInt() == 180){
      m_elevator.moveDown();
      moving = true;
    }
    if(moving && m_pov.getAsInt() == -1) {
      m_elevator.stop();
      moving = false;
    }
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
