package com.workout.app.game.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer implements Runnable {
	private static Socket clientSocket; // 각각의 클라이언트를 구분하기 위함
	static PrintWriter out = null;
	static ArrayList<Socket> list = new ArrayList<Socket>(); // 클라이언트 쓰레드를 담을 ArrayList 생성
	static int UserNum = 0; // 서버에서 클라이언트에게 번호를 부여하기 위한 변수

	public TCPServer(Socket clientSocket) { // 멀티 쓰레드 환경을 구축하기 위한 생성자. 각각의 개별 쓰레드를 생성
		this.clientSocket = clientSocket;
		list.add(clientSocket); // 쓰레드들을 리스트에 추가하는 부분
	}

	public static void main(String[] args) {
		ExecutorService eService = Executors.newFixedThreadPool(4);
		// 쓰레드 생성. 4번째 접속부터는 BLOCKING-참가자를 4명으로 제한

		System.out.println("#서버 시작");

		try (ServerSocket sSocket = new ServerSocket(10000)) {
			// try-with-resource문 사용 시 자동으로 자원 해제
			while (true) { // 접속하는 클라이언트들에게 무한 서비스
				System.out.println("#연결 대기 중 ......");
				clientSocket = sSocket.accept();
				// 연결 수락. client 연결정보, ip주소 담음
				TCPServer tes = new TCPServer(clientSocket);
				// 개별 쓰레드 객체 생성. 연결 수락시 접속한 클라이언트의 정보 담김
				// new Thread(tes).start();
				// 각각의 쓰레드가 식별가능한 인수를 갖게 된다, 개별적인 수행으로 효율적이지는 않다
				eService.submit(tes);
				// 더 효율적인 방법
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("#서버 종료");
		eService.shutdown();
	}

	public void run() {
		// 각각의 클라이언트들에 대한 피드백을 하는 run함수
		// 접속한 클라이언트들에 대응가능한 송수신용 버퍼와 각종 변수들이 들어있음
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// 수신 버퍼
			// OutputStream : 서버에서 클라이언트로 메세지 보내기
			OutputStream out = clientSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);
			// out = new PrintWriter(clientSocket.getOutputStream(), true); //송신 버퍼

			UserNum++;
			System.out.println("#클라이언트 : " + UserNum + "(" + Thread.currentThread() + ")" + " 연결됨!");

			String UserID = br.readLine(); // 사용자에게서 id를 입력받아 설정
			String inputLine; // 클라이언트가 보낸 값 저장

			writer.println("#[" + UserID + "]님이 접속하셨습니다.");
			System.out.println("#[" + UserID + "]님이 접속하셨습니다.");

			while ((inputLine = br.readLine()) != null) {
				// readLine(): client가 보낸 msg를 br에서 한줄씩 꺼냄
				// System.out.println("[" + UserID + "] " + inputLine);
				// 클라이언트에게서 받아온 정보를 한줄씩 출력
 
				for (int i = 0; i < list.size(); i++) {
					// ArrayList의 사이즈만큼 for문을 돌리면서 모든 클라이언트에게 메시지 전송
					out = list.get(i).getOutputStream();
					// ArrayList의 i번째 getOutputStream()요소를 가져와 out객체에 대입한다.
					writer = new PrintWriter(out, true);
					// 새로운 printWriter객체를 생성
					writer.println("[" + UserID + "] " + inputLine);
					// ArrayList의 i번째 요소를 클라이언트에게 송신한다.
				}
			}
			out.close();
			System.out.println("#클라이언트 : " + Thread.currentThread() + " 종료됨!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}