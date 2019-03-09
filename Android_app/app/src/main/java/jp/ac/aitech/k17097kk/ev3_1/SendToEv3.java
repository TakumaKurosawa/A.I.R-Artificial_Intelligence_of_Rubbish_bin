package jp.ac.aitech.k17097kk.ev3_1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class SendToEv3 extends Thread {

    private static final long serialVersionUID = 1L;
    private BufferedWriter bw;
    private Socket socket;
    private String turn;
    private String dis;
    private String ang;

    public SendToEv3(String mode, String number, String ang) {
        this.turn = mode;
        this.dis = number;
        this.ang = ang;
    }

    @Override
    public void run() {

        try {
            // ソケットを開く
            // 192.168.00.00の部分はEV3のIPアドレスを指定
            // 9999の部分にはEV3側のプログラムと同じ任意のポートを指定
            socket = new Socket("10.11.20.211", 9999);
            bw = new BufferedWriter(new
                    OutputStreamWriter(socket.getOutputStream()));

            sendCommand(this.turn, this.dis, this.ang);


            bw.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }


    // EV3に命令を送る
    private void sendCommand(String mode, String number, String ang) {
        try {
            String command = mode + "," + number + "," + ang + "\n";
            bw.write(command);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
