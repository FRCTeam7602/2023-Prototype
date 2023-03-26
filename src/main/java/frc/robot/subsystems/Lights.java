// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.ELEVATOR_CONTROLLER;
import static frc.robot.Constants.ELEVATOR_SLOW_SCALING;
import static frc.robot.Constants.ELEVATOR_MOVE_VELOCITY;
import static frc.robot.Constants.Elevator.MAX_POSITION;
import static frc.robot.Constants.Elevator.MIN_POSITION;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.LEDChannel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase {

  private final CANifier canifier;

  public Lights() {
    canifier = new CANifier(14);
  }

  @Override
  public void periodic() {}

  public void off() {
    canifier.setLEDOutput(0, LEDChannel.LEDChannelA);
    canifier.setLEDOutput(0, LEDChannel.LEDChannelB);
    canifier.setLEDOutput(0, LEDChannel.LEDChannelC);
  }

  public void purple() {
    canifier.setLEDOutput(0, LEDChannel.LEDChannelA);
    canifier.setLEDOutput(1, LEDChannel.LEDChannelB);
    canifier.setLEDOutput(1, LEDChannel.LEDChannelC);
  }

  public void yellow() {
    canifier.setLEDOutput(0.2, LEDChannel.LEDChannelA);
    canifier.setLEDOutput(1, LEDChannel.LEDChannelB);
    canifier.setLEDOutput(0, LEDChannel.LEDChannelC);
  }
}
