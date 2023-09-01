package com.javaex.phonebook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public List<PersonVO> selectPersonList() {
		ResultSet rs = null;
		List<PersonVO> list = new ArrayList<PersonVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			String query = "SELECT * FROM person";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int personId = rs.getInt(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String company = rs.getString(4);
				PersonVO phonevo = new PersonVO(personId,name,hp,company);
				list.add(phonevo);
			}
		} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    try {                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		        if (rs != null) {
		        	rs.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }
		}
		return list;
	}
	
	public List<PersonVO> selectSearchPersonList(String keyword) {
		ResultSet rs = null;
		List<PersonVO> list = new ArrayList<PersonVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			String query = "SELECT * "
					       + "FROM person "
					      + "WHERE name LIKE '%"+keyword+"%'";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int personId = rs.getInt(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String company = rs.getString(4);
				PersonVO phonevo = new PersonVO(personId,name,hp,company);
				list.add(phonevo);
			}
		} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    try {                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		        if (rs != null) {
		        	rs.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }
		}
		return list;
	}
	
	public int deletePerson(int phoneId) {
		int count = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			String query = "DELETE FROM person "
						 + " WHERE person_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, phoneId);
			count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		    try {                
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
		return count;
	}
	
	public int insertPerson(PersonVO person) {
		int count = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			String query = "INSERT INTO person "
						 + "VALUES(seq_person_id.nextval, ?, ?, ?) ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getHp());
			pstmt.setString(3, person.getCompany());
			count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		    try {                
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
		return count;
	}
	
	public int updatePerson(PersonVO person) {
		int count = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			String query = "UPDATE person "
						    + "SET name = ?, hp = ?, company = ? "
						  + "WHERE person_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getHp());
			pstmt.setString(3, person.getCompany());
			pstmt.setInt(4, person.getPersonId());
			count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		    try {                
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
		return count;
	}
	
}
