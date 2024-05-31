package frc.robot.subsystems.Motor;

public interface MotorIO {


    public void setSpeed(double speed);
    public double getPosition();
    public void setMotorPosition(double position);
    public void stop();

    public void setPID(double kP, double kI, double kD);
    public void setP(double p);
    public void setI(double i);
    public void setD(double d);

    public double getSpeed();
    public double getP();
    public double getI();
    public double getD();

    default void periodic(){};
}
