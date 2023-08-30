package com.jdbcex.practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbcex.ex01.Author;

public class BookSelect {
	
	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		    // 3. SQL문 준비 / 바인딩 / 실행
			
			String query = "SELECT b.*, a.author_name, a.author_desc "
					       + "FROM book b, author a "
					      + "WHERE b.author_id = a.author_id";
	
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();     //insert, update, delete
			// 실행
			List<BookVO> list = new ArrayList<BookVO>();
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				Date pubDate = rs.getDate(4);
				int authorId = rs.getInt(5);
				String authorName = rs.getString(6);
				String authorDesc = rs.getString(7);
				Author author = new Author(authorId,authorName,authorDesc);
				list.add(new BookVO(authorId, title, pubs, pubDate,author));
			}
			
			for(BookVO book : list) {
				System.out.println(book);
			}

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }
		}
	}
}


