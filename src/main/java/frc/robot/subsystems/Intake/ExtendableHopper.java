package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExtendableHopper extends SubsystemBase{
    private final Solenoid solo = new Solenoid(PneumaticsModuleType.REVPH, 0);

    public void flip(){
        solo.set(!solo.get());
    }
    public void on(){
        solo.set(true);
    }
    public void off(){
        solo.set(false);
    }
}