package frc.robot.subsystems.Feeder;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeDeplo extends SubsystemBase {
    private final SparkMax DeployMotor = new SparkMax(1, MotorType.kBrushless);
    
    public void feeder(int speed){
        DeployMotor.set(speed);
    
    }
    public SparkMax getMotor1(){
        return DeployMotor;
    }

}
