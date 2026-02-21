// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.apriltag.AprilTagFieldLayout;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation
    public static final int DriverControllerPort = 0;
    public static final int OperatorControllerPort = 1;
  }

  public static class FieldConstants {
    private static AprilTagFieldLayout layout;
    static {
      layout = AprilTagFieldLayout.loadField(AprilTagFields.k2026RebuiltWelded);
    }

    private static Translation2d getTagPoseTranslation(int ID) {
      return layout.getTagPose(ID).get().toPose2d().getTranslation();
    }

    public static Translation2d HubRed = (getTagPoseTranslation(9).plus(getTagPoseTranslation(10))).div(2);
    public static Translation2d HubBlue = (getTagPoseTranslation(25).plus(getTagPoseTranslation(26))).div(2);

    /**
     * Returns the length (X-axis) of the field in meters.
     * -- From Team 340
     */
    public static double length() {
        return layout.getFieldLength();
    }

    /**
     * Returns the width (Y-axis) of the field in meters.
     * -- From Team 340
     */
    public static double width() {
        return layout.getFieldWidth();
    }

  }
}
