package com.workout.app.game.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	Socket cSocket;
	BufferedReader br;
	PrintWriter out;
	Scanner scv;

	public TCPClient() { // 메시지 송신
		System.out.println("서버에 접속하는 중입니다.");
		try {
			// accept() 호출 후 쓰레드 만들어지고, Array List에 추가된다.
			InetAddress localAddress = InetAddress.getLocalHost();
			System.out.println("localAddress ==== " + localAddress);
			cSocket = new Socket(localAddress, 10000);// Socket cSocket = new Socket("127.0.0.1", 9000);
			// 10000번 포트와 로컬 주소를 사용하는 cSocket이라는 새로운 소켓을 생성
			SocketThread st = new SocketThread(); // 소켓 쓰레드의 새로운 객체인 st라는 쓰레드를 생성한다.
			st.start(); // st를 실행시킨다.
			// Test클래스가 Thread 클래스를 상속했다.
			// Thread 클래스의 run 메소드를 구현하면 st.start() 실행 시 st객체의 run 메소드가 수행이 된다.
			out = new PrintWriter(cSocket.getOutputStream(), true);
			scv = new Scanner(System.in);

			// 사용자 아이디 지정하는 부분
			String UserID = "";
			System.out.println("#서버에 연결됨!");
			System.out.println("#사용할 ID를 입력해주세요.");
			out.print(UserID);

			while (true) {
				String inputLine = scv.nextLine(); // 사용자에게서 서버로 보낼 값을 입력받는 변수
				out.println(inputLine); // 입력받은 키보드 값을 서버로 전송
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class SocketThread extends Thread { // 메시지 수신
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(cSocket.getInputStream())); // 송신 버퍼 객체 생성
				String response = null; // 송신된 메시지를 저장하기 위한 변수
				while ((response = br.readLine()) != null) { // br에 읽을 메시지가 있는 한 무한반복
					System.out.println(response); // br 객체에 저장된 문자열을 한 줄 씩 받아와서 출력
				}
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		new TCPClient(); // 메인문에서 생성자 실행시켜주기
	}
}