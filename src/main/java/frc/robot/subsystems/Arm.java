// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  public Arm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Extend the arm by driving motor at given rate.  A positive number would
   * push the arm out and a negative number brings it back in.
   */
  public void extend(double rate) {
    if (rate > 0.4) {
      System.out.printf("Extending Arm %.2f\n", rate);
    } else if(rate < -0.4) {
      System.out.printf("Retracting Arm %.2f\n", rate);
    }

    // TODO add actual motor controller and set value
    // TODO make sure controller for arm is in brake mode
    // TODO add encoder and limit switches
  }
}
