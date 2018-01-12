import lejos.nxt.*;

public class As1a
{
   public static void main(String[] args) throws InterruptedException
   {
      UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S3);
      LightSensor light = new LightSensor(SensorPort.S2);
      TouchSensor touch = new TouchSensor(SensorPort.S4);
      MotorPort A = MotorPort.A;
      MotorPort B = MotorPort.B;
      MotorPort C = MotorPort.C;
      int time1 = (int) (System.currentTimeMillis() + 90000); // 90 seconds

      // calibrating
      while (!Button.ENTER.isDown())
      {
         LCD.drawString(
               "Press LEFT to calibrate LOW and RIGHT to calibrate HIGH", 0, 0);
         LCD.drawInt(light.getLightValue(), 0, 3);
         if (Button.LEFT.isDown())
         {
            light.calibrateLow();
            LCD.drawString("Calibrated LOW", 0, 0);
         }
         if (Button.RIGHT.isDown())
         {
            light.calibrateHigh();
            LCD.drawString("Calibrated HIGH", 0, 1);
         }
      }

      Sound.playTone(262, 3644);
      Sound.pause(1280);
      Sound.playTone(392, 1642);
      Sound.pause(740);
      Sound.playTone(349, 166);
      Sound.pause(250);
      Sound.playTone(330, 166);
      Sound.pause(250);
      Sound.playTone(294, 166);
      Sound.pause(250);
      Sound.playTone(523, 3642);
      Sound.pause(1250);
      Sound.playTone(392, 1100);
      Sound.pause(1150);
      Sound.playTone(349, 166);
      Sound.pause(250);
      Sound.playTone(330, 166);
      Sound.pause(250);
      Sound.playTone(294, 166);
      Sound.pause(250);
      Sound.playTone(523, 3642);
      Sound.pause(1250);
      Sound.playTone(392, 1400);
      Sound.pause(1250);
      Sound.playTone(349, 266);
      Sound.pause(250);
      Sound.playTone(330, 266);
      Sound.pause(250);
      Sound.playTone(349, 266);
      Sound.pause(250);
      Sound.playTone(294, 1642);
      Sound.pause(1250);

      Button.waitForAnyPress();
      Thread.sleep(3000);
      while (C.getTachoCount() < 90)
      {
         C.controlMotor(70, 1);
      }
      C.controlMotor(60, 3);
      Thread.sleep(500);
      while (System.currentTimeMillis() < time1)
      {
         if (light.getLightValue() > 35)
         {
            if (ultra.getDistance() < 40)
            {
               A.controlMotor(100, 1);
               B.controlMotor(100, 1);
               if (ultra.getDistance() < 20)
               {
                  C.resetTachoCount();
                  while (C.getTachoCount() > -90)
                  {
                     C.controlMotor(100, 2);
                  }
                  C.controlMotor(100, 3);
               }

            }
            else
            {
               A.controlMotor(100, 1);
               B.controlMotor(100, 1);
            }
         }
         else if (light.getLightValue() <= 35)
         {
            A.resetTachoCount();
            while (A.getTachoCount() > -840)
            {
               A.controlMotor(100, 2);
               B.controlMotor(100, 3);
            }
         }
         else if (light.getLightValue() <= 100 && touch.isPressed())
         {
            A.controlMotor(100, 3);
            B.controlMotor(100, 3);
         }
      }
      A.controlMotor(100, 3);
      B.controlMotor(100, 3);
      C.controlMotor(100, 3);
      Thread.sleep(1000);
      Sound.playTone(262, 3644);
      Sound.pause(1280);
      Sound.playTone(392, 1642);
      Sound.pause(740);
      Sound.playTone(349, 166);
      Sound.pause(250);
      Sound.playTone(330, 166);
      Sound.pause(250);
      Sound.playTone(294, 166);
      Sound.pause(250);
      Sound.playTone(523, 3642);
      Sound.pause(1250);
      Sound.playTone(392, 1100);
      Sound.pause(1150);
      Sound.playTone(349, 166);
      Sound.pause(250);
      Sound.playTone(330, 166);
      Sound.pause(250);
      Sound.playTone(294, 166);
      Sound.pause(250);
      Sound.playTone(523, 3642);
      Sound.pause(1250);
      Sound.playTone(392, 1400);
      Sound.pause(1250);
      Sound.playTone(349, 266);
      Sound.pause(250);
      Sound.playTone(330, 266);
      Sound.pause(250);
      Sound.playTone(349, 266);
      Sound.pause(250);
      Sound.playTone(294, 1642);
      Sound.pause(1250);
   }
}
