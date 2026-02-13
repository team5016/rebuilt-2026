package frc.robot.subsystems.Feeder;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private final SparkMax hopperMotor1 = new SparkMax(1, MotorType.kBrushless);
    
    public void feeder(int speed){
        hopperMotor1.set(speed);
    
    }
    public SparkMax getMotor1(){
        return hopperMotor1;
    }

}
