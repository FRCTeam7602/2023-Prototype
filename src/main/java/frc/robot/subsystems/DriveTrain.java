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
  private final CANSparkMax driveLeft;
  private final CANSparkMax driveRight;
  private final DifferentialDrive drive;

  private CANSparkMax omniLeft;
  private CANSparkMax omniRight;
  private DifferentialDrive omniDrive;

  public DriveTrain() {
    driveLeft = new CANSparkMax(Constants.DRIVE_LEFT_CONTROLLER, MotorType.kBrushless);
    driveRight = new CANSparkMax(Constants.DRIVE_RIGHT_CONTROLLER, MotorType.kBrushless);
    omniLeft = new CANSparkMax(Constants.OMNI_LEFT_CONTROLLER, MotorType.kBrushless);
    omniRight = new CANSparkMax(Constants.OMNI_RIGHT_CONTROLLER, MotorType.kBrushless);

    driveLeft.restoreFactoryDefaults();
    driveLeft.restoreFactoryDefaults();
    omniLeft.restoreFactoryDefaults();
    omniRight.restoreFactoryDefaults();

    driveLeft.setSmartCurrentLimit(Constants.NEO_CURRENT_LIMIT);
    driveRight.setSmartCurrentLimit(Constants.NEO_CURRENT_LIMIT);
    omniLeft.setSmartCurrentLimit(Constants.NEO_CURRENT_LIMIT);
    omniRight.setSmartCurrentLimit(Constants.NEO_CURRENT_LIMIT);

    drive = new DifferentialDrive(driveLeft, driveRight);
    omniDrive = new DifferentialDrive(omniLeft, omniRight);

    // disabling motor safety since this is drive train and user controls
    // don't always change 10 times per second
    drive.setSafetyEnabled(false);
    omniDrive.setSafetyEnabled(false);
  }

  public void drive(double forward, double rotation) {
    // trying out curvatureDrive to compare with arcadeDrive
    drive.curvatureDrive(forward, rotation, true);
    System.out.format("DRIVING %.2f by %.2f\n", forward, rotation);
    if(Math.abs(forward) > .7) {
      omniDrive.curvatureDrive(forward, rotation, true);
      System.out.format("BOOSTING with OMNI %.2f by %.2f\n", forward, rotation);
    }
  }
}
