//6767676767
package frc.robot.subsystems.Feeder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederConveyor extends SubsystemBase {
    private final SparkMax feederConveyor1 = new SparkMax(1, MotorType.kBrushless);
    private final SparkMax feederConveyor2 = new SparkMax(1, MotorType.kBrushless);//ChangeIDLater
    public void feeder(int speed){
        feederConveyor1.set(speed);
        feederConveyor2.set(speed);
    
    }
    public SparkMax getMotor1(){
        return feederConveyor1;
    }
    public SparkMax getMotor2(){
        return feederConveyor2;
    }
}
