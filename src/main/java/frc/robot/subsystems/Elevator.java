// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  private final CANSparkMax elevatorMotor;
  public Elevator() {
    elevatorMotor = new CANSparkMax(Constants.ELEVATOR_CONTROLLER, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void moveUp() {
    System.out.println("Moving up");
    elevatorMotor.set(0.2);
  }

  public void moveDown() {
    System.out.println("Moving down");
    elevatorMotor.set(-0.2);
  }

  public void stop() {
    System.out.println("Stopping");
    elevatorMotor.set(0);
  }
}
