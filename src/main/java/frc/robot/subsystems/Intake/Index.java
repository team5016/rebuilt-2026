package frc.robot.subsystems.Intake;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Index extends SubsystemBase {
    private final SparkMax IndexMotor = new SparkMax(1, MotorType.kBrushless);
    
    public void feeder(int speed){
        IndexMotor.set(speed);
    
    }
    public SparkMax getMotor1(){
        return IndexMotor;
    }
    RelativeEncoder encoder = IndexMotor.getEncoder();

    double position = encoder.getPosition(); // rotations
    double velocity = encoder.getVelocity(); // RPM
}