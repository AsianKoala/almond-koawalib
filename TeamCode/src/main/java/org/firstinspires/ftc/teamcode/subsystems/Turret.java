package org.firstinspires.ftc.teamcode.subsystems;

import com.asiankoala.koawalib.control.controller.PIDGains;
import com.asiankoala.koawalib.control.motor.FFGains;
import com.asiankoala.koawalib.hardware.motor.EncoderFactory;
import com.asiankoala.koawalib.hardware.motor.KMotor;
import com.asiankoala.koawalib.hardware.motor.MotorFactory;
import com.asiankoala.koawalib.subsystem.KSubsystem;

public class Turret extends KSubsystem {
    private final KMotor tmotor = new MotorFactory("tmotor")
            .getBrake()
            .createEncoder(
                    new EncoderFactory(1.0)
                            .zero()
            )
            .withPositionControl(
                    new PIDGains(
                            0.012,
                            0.0,
                            0.000002
                    ),
                    new FFGains(),
                    10.0
            )
            .build();

    public void setTarget(double position) {
        tmotor.setPositionTarget(position);
    }
}
