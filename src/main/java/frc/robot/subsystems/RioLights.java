// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RioLights extends SubsystemBase {

  private final AddressableLED m_leds;
  private final AddressableLEDBuffer m_ledBuffer;

  public RioLights() {
    m_leds = new AddressableLED(9);
    m_ledBuffer = new AddressableLEDBuffer(60);
    m_leds.setLength(m_ledBuffer.getLength());
    m_leds.setData(m_ledBuffer);
    m_leds.start();
  }

  @Override
  public void periodic() {}

  public void off() {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 0, 0, 0);
    }
    m_leds.setData(m_ledBuffer);
  }

  public void purple() {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 255, 0, 255);
    }
    m_leds.setData(m_ledBuffer);
  }

  public void yellow() {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 255, 255, 0);
    }
    m_leds.setData(m_ledBuffer);
  }
}
