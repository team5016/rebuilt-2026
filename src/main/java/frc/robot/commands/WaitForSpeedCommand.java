package frc.robot.commands;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;

public class WaitForSpeedCommand extends Command {
    private final TalonFX motor;
    private final double targetRPS;
    private final double tolerance;

    public WaitForSpeedCommand(TalonFX motor, double targetRPS, double tolerance) {
        this.motor = motor;
        this.targetRPS = targetRPS;
        this.tolerance = tolerance;
    }

    @Override
    public boolean isFinished() {
        return motor.getVelocity().isNear(targetRPS, tolerance);
    }

}
