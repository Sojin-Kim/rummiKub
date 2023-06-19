package com.workout.app.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCTests {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@QX36Z5MIUP9ONYCL_high?TNS_ADMIN=C:/dev/DB/Wallet_QX36Z5MIUP9ONYCL";
			//String url = "jdbc:oracle:thin:@DB이름_medium?TNS_ADMIN=지갑폴더경로";
			String user = "ADMIN";
			String password = "Dongpig96@00";
			con = DriverManager.getConnection(url, user, password);
			
			//실행 쿼리
			String sql = "SELECT EMPID, NAME FROM TEST1";
			//Statement 생성 후 실행할 쿼리정보 등록
			Statement stmt = con.createStatement();
			//결과를 담을 ResultSet 생성 후 결과 담기
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("쿼리 실행");
			//결과를 담을 ArrayList생성
			ArrayList<TestDto> list = new ArrayList<TestDto>();
			
			//ResultSet에 담긴 결과를 ArrayList에 담기
			while(rs.next()) {
				TestDto bean = new TestDto();
				bean.setEmpId(rs.getString("EMPID"));
				bean.setName(rs.getString("NAME"));
				list.add(bean);
			}
			System.out.println("담기");
			//결과물 출력
			for(int i=0; i<list.size(); i++) {
				System.out.println("회원아이디:"+list.get(i).getEmpId());
				System.out.println("회원이름:"+list.get(i).getName());
			}
			System.out.println("연결완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
// 확인용
	}

}