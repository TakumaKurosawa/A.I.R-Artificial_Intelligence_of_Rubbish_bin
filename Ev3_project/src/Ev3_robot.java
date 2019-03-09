
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.remote.ev3.RMISampleProvider;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Ev3_robot {

	// static EV3GyroSensor gyroSensor = new EV3GyroSensor(SensorPort.S2);
	static EV3UltrasonicSensor sonic = new EV3UltrasonicSensor(SensorPort.S3);

	static RegulatedMotor leftMotor = Motor.B;

	static RegulatedMotor rightMotor = Motor.C;

	static final double tireDistance = 177;

	Delay wait = new Delay();

	// モーターのパワーを制御
	private static void motor_set(int l_motor_pow, int r_motor_pow) {
		leftMotor.setSpeed(l_motor_pow);
		rightMotor.setSpeed(r_motor_pow);
	}

	/**
	 * 指定された角度分左折します．
	 * 
	 * @param angle : 指定された角度
	 */
	public static void leftRotate(int angle) {

		motor_set(50, 50);

		rightMotor.rotate(angle * 2, true);
		leftMotor.rotate(-angle * 2, true);

	}

	/**
	 * 指定された角度分右折します．
	 * 
	 * @param angle : 指定された角度
	 */
	public static void rightRotate(int angle) {

		motor_set(40, 40);

		rightMotor.rotate(-angle * 2, true);
		leftMotor.rotate(angle * 2, true);

	}

	/**
	 * タイヤ1回転あたりに進む距離(165.3061mm)を利用して，指定された距離分前進する
	 * 
	 * @param distance : 進む距離(mm)
	 */
	public static void goStraight(double distance) {

		double rotatebefore = (distance / 165.3061) * 360.0;
		// int rotate =980で45㎝進む;
		int rotate = (int) rotatebefore;

		// LCD.drawInt(rotate, 0, 3);

		motor_set(500, 500);

		rightMotor.rotate(rotate, true);
		leftMotor.rotate(rotate, true);

	}

	public static void Obstacle(double distance, float sampleDistance, String operator,int sign) {
		
		
		

		if(sign==1) {
		LCD.clear();
		// めんどくさい
		int radius = 30;// 円の半径
		// 左外
		int Cx = 40;// 円の中心x座標(左)
		int Cy = 70;// 円の中心y座標(左)
		double dx, dy;
		int ix, iy;
		for (int i = 1; i <= 360; i++) {
			for (int k = 0; k <= 5; k++) {
				dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
				dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
				ix = (int) dx;
				iy = (int) dy;
				LCD.setPixel(ix, iy, 1);
			}
		}
		// 右外
		Cx = 140;
		Cy = 70;
		for (int i = 1; i <= 360; i++) {
			for (int k = 0; k <= 5; k++) {
				dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
				dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
				ix = (int) dx;
				iy = (int) dy;
				LCD.setPixel(ix, iy, 1);
			}
		}
		// 左内
		radius = 18;
		Cx = 40;
		Cy = 70;
		for (int i = 1; i <= 180; i++) {
			for (int k = 0; 0 < radius - k; k++) {
				dx = Cx + (radius - k) * Math.cos(Math.toRadians(i));
				dy = Cy + (radius - k) * Math.sin(Math.toRadians(i));
				ix = (int) dx;
				iy = (int) dy;
				LCD.setPixel(ix, iy, 1);
			}
		}
		// 左横
		for (int i = (Cx - radius - 25); i < (Cx + radius + 25); i++) {
			for (int k = 0; k <= 5; k++) {
				LCD.setPixel(i, Cy - k, 1);
			}
		}
		// 右内
		Cx = 140;
		Cy = 70;
		for (int i = 1; i <= 180; i++) {
			for (int k = 0; 0 < radius - k; k++) {
				dx = Cx + (radius - k) * Math.cos(Math.toRadians(i));
				dy = Cy + (radius - k) * Math.sin(Math.toRadians(i));
				ix = (int) dx;
				iy = (int) dy;
				LCD.setPixel(ix, iy, 1);
			}
		}
		for (int i = (Cx - radius - 25); i < (Cx + radius + 25); i++) {
			for (int k = 0; k <= 5; k++) {
				LCD.setPixel(i, Cy - k, 1);
			}
		}
		}else {
			
		}

		
		
		if (operator.equals("RIGHT")) {
			rightRotate(95 * sign);
		} else {
			leftRotate(95 * sign);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		goStraight(35 * 10.0 * sign);
		try {
			Thread.sleep(15000);// 15000
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (operator.equals("RIGHT")) {
			leftRotate(95 * sign);
		} else {
			rightRotate(95 * sign);
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		goStraight(70 * 10.0 * sign);
		try {
			Thread.sleep(15000);// 15000
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (operator.equals("RIGHT")) {
			leftRotate(95 * sign);
		} else {
			rightRotate(95 * sign);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		goStraight(35 * 10.0 * sign);
		try {
			Thread.sleep(15000);// 15000
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (operator.equals("RIGHT")) {
			rightRotate(95 * sign);
		} else {
			leftRotate(95 * sign);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(9999);

			while (true) {
				Socket socket = serverSocket.accept();
				new Ev3_Thread(socket).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
			}

		}
	}

	static class Ev3_Thread extends Thread {

		private Socket socket;

		public Ev3_Thread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				RMISampleProvider UltraSonicSensor = null;
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				String line;
				while ((line = in.readLine()) != null) {
					String[] operator = line.split(",", -1);

//					LCD.drawString(operator[0], 0, 0);
//					LCD.drawString(operator[1], 0, 1);
//					LCD.drawString(operator[2], 0, 2);

					/*
					 * if (sampleDistance[0] < 0.3) { LCD.clear();
					 * LCD.drawString(String.valueOf(sampleDistance[0]), 0, 0); Motor.B.stop();
					 * Sound.beep(); }
					 */

					LCD.clear();
					// うえみる
					int radius = 30;// 円の半径
					// 左外
					int Cx = 40;// 円の中心x座標(左)
					int Cy = 70;// 円の中心y座標(左)
					double dx, dy;
					int ix, iy;
					for (int i = 1; i <= 360; i++) {
						for (int k = 0; k <= 5; k++) {
							dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
							dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
							ix = (int) dx;
							iy = (int) dy;
							LCD.setPixel(ix, iy, 1);
						}
					}
					// 右外
					Cx = 140;
					Cy = 70;
					for (int i = 1; i <= 360; i++) {
						for (int k = 0; k <= 5; k++) {
							dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
							dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
							ix = (int) dx;
							iy = (int) dy;
							LCD.setPixel(ix, iy, 1);
						}
					}
					// 左内
					radius = 18;
					Cx = 40;
					Cy = 55;
					for (int i = 1; i <= 360; i++) {
						for (int k = 0; 0 < radius - k; k++) {
							dx = Cx + (radius - k) * Math.cos(Math.toRadians(i));
							dy = Cy + (radius - k) * Math.sin(Math.toRadians(i));
							ix = (int) dx;
							iy = (int) dy;
							LCD.setPixel(ix, iy, 1);
						}
					}
					// 右内
					Cx = 140;
					Cy = 55;
					for (int i = 1; i <= 360; i++) {
						for (int k = 0; 0 < radius - k; k++) {
							dx = Cx + (radius - k) * Math.cos(Math.toRadians(i));
							dy = Cy + (radius - k) * Math.sin(Math.toRadians(i));
							ix = (int) dx;
							iy = (int) dy;
							LCD.setPixel(ix, iy, 1);
						}
					}
					
					
					//最初に角度を変える
					int angle = (int) Double.parseDouble(operator[2].toString());
					leftRotate(angle);
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

					
					SensorMode distanceMode = sonic.getMode(0); // 距離検出モード
					float[] sampleDistance = new float[distanceMode.sampleSize()];
					distanceMode.fetchSample(sampleDistance, 0);

					double distance = Double.parseDouble(operator[1].toString());
					

					//障害物がスタート位置と目的地の間にあるとき
					if ((sampleDistance[0] * 100.0 )< distance ) {
						
						//障害物より35㎝手前まで進む
						goStraight((sampleDistance[0] - 0.35) * 1000.0);
						try {
							Thread.sleep(15000);// 15000
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						
						//避ける
						Obstacle(distance, sampleDistance[0], operator[0],1);

						LCD.clear();
						// うえみる
						radius = 30;// 円の半径
						// 左外
						Cx = 40;// 円の中心x座標(左)
						Cy = 70;// 円の中心y座標(左)
//							double dx, dy;
//							int ix, iy;
						for (int i = 1; i <= 360; i++) {
							for (int k = 0; k <= 5; k++) {
								dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						// 右外
						Cx = 140;
						Cy = 70;
						for (int i = 1; i <= 360; i++) {
							for (int k = 0; k <= 5; k++) {
								dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						// 左内
						radius = 18;
						Cx = 40;
						Cy = 55;
						for (int i = 1; i <= 360; i++) {
							for (int k = 0; 0 < radius - k; k++) {
								dx = Cx + (radius - k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius - k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						// 右内
						Cx = 140;
						Cy = 55;
						for (int i = 1; i <= 360; i++) {
							for (int k = 0; 0 < radius - k; k++) {
								dx = Cx + (radius - k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius - k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						
						
						//sencerdistance:障害物を避けた後現在進んだ距離
						//sampleDistance:障害物との距離
						
						double sencerdistance = (sampleDistance[0] + 0.35) * 100.0;
						
						
//						2回目の障害物感知
						float[] sampleDistance2 = new float[distanceMode.sampleSize()];
						distanceMode.fetchSample(sampleDistance2, 0);

//						障害物があったらまた避けて現在進んだ距離を更新する
						if ((sampleDistance2[0] * 100.0) < (distance - sencerdistance)) {
							
							//障害物より35㎝手前まで進む
							goStraight((sampleDistance[0] - 0.35) * 1000.0);
							try {
								Thread.sleep(15000);// 15000
							} catch (InterruptedException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
							
							
							Obstacle(distance, sampleDistance2[0], operator[0],1);
							double sencerdistance2 = sencerdistance + ((sampleDistance2[0] + 0.35) * 100.0) ;
							
							// 避けた後に残りの距離を進む
							goStraight((distance - sencerdistance2 ) * 10.0);
							try {
								Thread.sleep(15000);// 15000
							} catch (InterruptedException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
							
							
							
							//正面に向きを変える
							 leftRotate(-angle);
							 try {
								 Thread.sleep(5000); 
							} catch (InterruptedException e) { // TODO 自動生成された catch ブロック
								e.printStackTrace();
							}

							 
							 
							 
							LCD.clear();
							// にっこり帰宅
							radius = 30;// 円の半径
							// 左外
							Cx = 40;// 円の中心x座標(左)
							Cy = 70;// 円の中心y座標(左)
							for (int i = 1; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							// 右外
							Cx = 140;
							Cy = 70;
							for (int i = 1; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							// 左内
							radius = 15;
							Cx = 40;
							Cy = 80;
							for (int i = 180; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							// 右内
							Cx = 140;
							Cy = 80;
							for (int i = 180; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							
							
							
							//元に戻る
							 leftRotate(angle);
							 try {
								 Thread.sleep(5000); 
							} catch (InterruptedException e) { // TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
							 
							 
							goStraight((distance - sencerdistance2 ) * -10.0);
								try {
									Thread.sleep(15000);// 15000
								} catch (InterruptedException e) {
									// TODO 自動生成された catch ブロック
									e.printStackTrace();
								}
							
							//元に戻る
							Obstacle(distance, sampleDistance2[0], operator[0],-1);
							
							
							
							goStraight((sampleDistance[0] - 0.35) * -1000.0);
							try {
								Thread.sleep(15000);// 15000
							} catch (InterruptedException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
							
							
							
						} else {
						
							// 避けた後に残りの距離を進む
							goStraight((distance - sencerdistance ) * 10.0);
							try {
								Thread.sleep(15000);// 15000
							} catch (InterruptedException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
							
							
							leftRotate(-angle);
							 try {
								 Thread.sleep(5000); 
							} catch (InterruptedException e) { // TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
							
	
							LCD.clear();
							// にっこり帰宅
							radius = 30;// 円の半径
							// 左外
							Cx = 40;// 円の中心x座標(左)
							Cy = 70;// 円の中心y座標(左)
							for (int i = 1; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							// 右外
							Cx = 140;
							Cy = 70;
							for (int i = 1; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							// 左内
							radius = 15;
							Cx = 40;
							Cy = 80;
							for (int i = 180; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							// 右内
							Cx = 140;
							Cy = 80;
							for (int i = 180; i <= 360; i++) {
								for (int k = 0; k <= 5; k++) {
									dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
									dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
									ix = (int) dx;
									iy = (int) dy;
									LCD.setPixel(ix, iy, 1);
								}
							}
							
							leftRotate(angle);
							 try {
								 Thread.sleep(5000); 
							} catch (InterruptedException e) { // TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
							
							 
							// 避けた後に残りの距離を進む
								goStraight((distance - sencerdistance ) * -10.0);
								try {
									Thread.sleep(15000);// 15000
								} catch (InterruptedException e) {
									// TODO 自動生成された catch ブロック
									e.printStackTrace();
								}

						 
						}
						
						//元に戻る
						Obstacle(distance, sampleDistance[0], operator[0],-1);
						
						goStraight((sampleDistance[0] - 0.35) * -1000.0);
						try {
							Thread.sleep(15000);// 15000
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						
						leftRotate(-angle);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						
						
//					障害物なしの場合
					} else {

						goStraight(distance * 10.0);
						try {
							Thread.sleep(15000);// 15000
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						
						 leftRotate(-angle);
						 try {
							 Thread.sleep(5000); 
						} catch (InterruptedException e) { // TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						
						 

						LCD.clear();
						// にっこり帰宅
						radius = 30;// 円の半径
						// 左外
						Cx = 40;// 円の中心x座標(左)
						Cy = 70;// 円の中心y座標(左)
						for (int i = 1; i <= 360; i++) {
							for (int k = 0; k <= 5; k++) {
								dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						// 右外
						Cx = 140;
						Cy = 70;
						for (int i = 1; i <= 360; i++) {
							for (int k = 0; k <= 5; k++) {
								dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						// 左内
						radius = 15;
						Cx = 40;
						Cy = 80;
						for (int i = 180; i <= 360; i++) {
							for (int k = 0; k <= 5; k++) {
								dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						// 右内
						Cx = 140;
						Cy = 80;
						for (int i = 180; i <= 360; i++) {
							for (int k = 0; k <= 5; k++) {
								dx = Cx + (radius + k) * Math.cos(Math.toRadians(i));
								dy = Cy + (radius + k) * Math.sin(Math.toRadians(i));
								ix = (int) dx;
								iy = (int) dy;
								LCD.setPixel(ix, iy, 1);
							}
						}
						

						 leftRotate(angle);
						 try {
							 Thread.sleep(5000); 
						} catch (InterruptedException e) { // TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						goStraight(distance * -10.0);
						try {
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						leftRotate(-angle);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null) {
						socket.close();
					}
				} catch (IOException e) {
				}
			}

		}
	}
}