package com.Project.member.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	
	private Connection getConnection(){
		try {
			//Context 객체를 생성 (프로젝트 정보를 가지고있는객체)
			Context initCTX = new InitialContext();
			// DB연동 정보를 불러오기(context.xml)
			DataSource ds =
			(DataSource) initCTX.lookup("java:comp/env/jdbc/mysql");
			
			conn = ds.getConnection();
			
			System.out.println(" 드라이버 로드, 디비연결 성공! ");
			System.out.println(conn);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	// getConnection() - 디비연결 끝
	
	// 자원해제코드 - finally 구문에서 사용
	public void closeDB(){
		try {
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close();}
			if(conn != null){ conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// insertMember(mdto)
	public void insertMember(MemberDTO mdto){
		
		
		try {
			// 1,2 디비연결
			conn = getConnection();
			// 3 sql 작성 & pstmt 객체
			sql = "insert into member (id,pass,name,age,gender,email,zipcode,roadAddress,jibunAddress,namujiAddress,reg_date) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			// ? 
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPass());
			pstmt.setString(3, mdto.getName());
			pstmt.setInt(4, mdto.getAge());
			pstmt.setString(5, mdto.getGender());
			pstmt.setString(6, mdto.getEmail());
			pstmt.setString(7,mdto.getZipcode());
			pstmt.setString(8,mdto.getRoadAddress());
			pstmt.setString(9,mdto.getJibunAddress());
			pstmt.setString(10,mdto.getNamujiAddress());
			pstmt.setTimestamp(11, mdto.getReg_date());

			// 4 sql 실행
			pstmt.executeUpdate();
			
			System.out.println("DAO : 회원가입 완료! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// insertMember(mdto)
	
	// idCheck(id,pass)
	public int idCheck(String id,String pass){
		int check = -1;
		
		try {
			// 1,2 디비연결
			conn = getConnection();
			// 3 sql 구문 & pstmt 객체생성
			sql = "select pass from member where id=?";
			pstmt = conn.prepareStatement(sql);
			//?
			pstmt.setString(1, id);
			// 4 sql 실행
			rs = pstmt.executeQuery();
			// 5 데이터 처리 (본인확인)
			if(rs.next()){
				if(pass.equals(rs.getString("pass"))){
					// 본인 
					check = 1;
				}else{
					// 비밀번호 오류
					check = 0;
				}
			}else{
				// 회원정보 x
				check = -1;
			}
			
			System.out.println("DAO : 로그인 처리 결과 "+check);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return check;
	}
	// idCheck(id,pass)
	
	// getMember(id)
	public MemberDTO getMember(String id){
		MemberDTO dto = null;
		try {
			// 1,2 디비연결
			conn = getConnection();
			// 3 sql & pstmt 객체 
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			//? 
			pstmt.setString(1, id);
			// 4 sql 실행
			rs = pstmt.executeQuery();
			// 5 데이터 처리
			if(rs.next()){
				dto = new MemberDTO();
				
				dto.setAge(rs.getInt("age"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setRoadAddress(rs.getString("roadAddress"));
				dto.setJibunAddress(rs.getString("jibunAddress"));
				dto.setNamujiAddress(rs.getString("namujiAddress"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
			}
			
			System.out.println("DAO : 회원정보 저장완료!");			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return dto;
	}
	// getMember(id)
	
	
	// updateMember(dto)
	public int updateMember(MemberDTO dto){
		int result = -1;
		
		try {
			// 1,2 디비연결
			conn = getConnection();
			// 3 sql구문 & pstmt 객체 생성
			sql = "select pass from member where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			
			//4 sql 실행
			rs = pstmt.executeQuery();
			
			//5 데이터 처리 
			if(rs.next()){
				// 아이디가 있음
				if(dto.getPass().equals(rs.getString("pass"))){
					// 본인 -> 정보 수정
					// 3 sql/pstmt 객체
					sql = "update member set name=?,age=?,gender=?,email=?,zipcode=?,roadAddress=?," +
							"jibunAddress=?,namujiAddress=? where id=?";

					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, dto.getName());
					pstmt.setInt(2, dto.getAge());
					pstmt.setString(3, dto.getGender());
					pstmt.setString(4, dto.getEmail());
					pstmt.setString(5,dto.getZipcode());
					pstmt.setString(6,dto.getRoadAddress());
					pstmt.setString(7,dto.getJibunAddress());
					pstmt.setString(8,dto.getNamujiAddress());
					pstmt.setString(9, dto.getId());
					
					//4 sql 실행
					result = pstmt.executeUpdate();
					System.out.println("DAO : 회원정보 수정완료!");
					
				}else{
					// 아이디는 있지만, 비밀번호 오류
					result = 0;
				}
			}else{
				// 아이디가 없음
				result = -1;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return result;
	}
	// updateMember(dto)
	
	
	// deleteMember(id,pass)
	public int deleteMember(String id,String pass){
		int result = -1;
		
		try {
			// 1,2 디비연결
			conn = getConnection();
			// 3 sql 구문(select) & pstmt 객체 생성
			sql = "select pass from member where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			// 4 sql 실행
			rs = pstmt.executeQuery();
			// 5 데이터처리
			if(rs.next()){
			    if(pass.equals(rs.getString("pass"))){
			    	//   3 sql 구문(delete) & pstmt 객체
					sql = "delete from member where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					//   4 sql 실행			
					result = pstmt.executeUpdate();
			    }else{
			       	result = 0;
			    }
			}else{
				result = -1;
			}
			
			System.out.println("DAO : 회원정보 삭제 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return result;
	}
	// deleteMember(id,pass)
	
	// getMemberList()
	public List getMemberList(){
		List memberList = new ArrayList();
		
		try {
			//1,2 디비연결
			conn = getConnection();
			//3 sql 작성 & pstmt 객체 생성
			sql = "select * from member where id !='admin'";
			pstmt = conn.prepareStatement(sql);
			//4 sql 실행
			rs = pstmt.executeQuery();
			//5 데이터 처리 
			while(rs.next()){
				MemberDTO dto = new MemberDTO();
				dto.setAge(rs.getInt("age"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setRoadAddress(rs.getString("roadAddress"));
				dto.setJibunAddress(rs.getString("jibunAddress"));
				dto.setNamujiAddress(rs.getString("namujiAddress"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
				// 리스트 한칸 -> 1명 정보 저장
				memberList.add(dto);								
			}
			
			System.out.println("DAO : 모든 회원 정보 저장 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return memberList;
	} // getMemberList()


	public boolean idCheck(String id) {
		if(id == null || id.length() == 0) throw new NullPointerException("아이디가 없습니다.");
		System.out.println("id : " + id);

		final String SQL = "select if(count(*)=1, 'true', 'false') as result"
				+ " from member"
				+" where id = ?";
		System.out.println("SQL : " + SQL);

		try {
			//DB연결 - 쿼리 등록 - '?'에 값 매핑 - 쿼리 전송 - 결과
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			//'result'라는 컬럼의 값을 받아온다.
			rs.next();
			String result = rs.getString(1);
			System.out.println("result : " +result);

			return Boolean.parseBoolean(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isExisted(MemberDTO dto){
		boolean result = false;
		String id = dto.getId();
		String pass = dto.getPass();

		try {
			conn = getConnection();
			sql = "select if(count(*) = 1, 'true','false') AS RESULT from member where id=? and pass=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pass);

			rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result :" + result);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;

	}

}
