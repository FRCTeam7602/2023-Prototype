// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain extends SubsystemBase {
  private CANSparkMax driveLeft = new CANSparkMax(Constants.DRIVE_LEFT_CONTROLLER, MotorType.kBrushless);
  private CANSparkMax driveRight = new CANSparkMax(Constants.DRIVE_RIGHT_CONTROLLER, MotorType.kBrushless);
  private DifferentialDrive drive = new DifferentialDrive(driveLeft, driveRight);

  private CANSparkMax omniLeft = new CANSparkMax(Constants.OMNI_LEFT_CONTROLLER, MotorType.kBrushless);
  private CANSparkMax omniRight = new CANSparkMax(Constants.OMNI_RIGHT_CONTROLLER, MotorType.kBrushless);
  private DifferentialDrive omniDrive = new DifferentialDrive(omniLeft, omniRight);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double forward, double rotation) {
    System.out.format("DRIVING %.2f by %.2f\n", forward, rotation);
    drive.arcadeDrive(forward, rotation);
    if(Math.abs(forward) > .7) {
      System.out.format("OMNI %.2f by %.2f\n", forward, rotation);
      omniDrive.arcadeDrive(forward, rotation);
    }
  }
}
