// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class blingblong extends SubsystemBase {


  /** Creates a new blingblong. */
  private AddressableLED blinkblank = new AddressableLED(9);
  private AddressableLEDBuffer blankblink = new AddressableLEDBuffer(5);
  private int rainbow;
  private void rgb() {
    // For every pixel
    for (var i = 0; i < blankblink.getLength(); i++) {
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (rainbow + (i * 180 / blankblink.getLength())) % 180;
      // Set the value
      blankblink.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    rainbow += 3;
    // Check bounds
    rainbow %= 180;
  }
  public blingblong() {
      rgb();
      
      blinkblank.setLength(blankblink.getLength());
      blinkblank.setData(blankblink);
    
    
    
    }
    
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    blinkblank.start();
  }
}
