package com.kk.smartPhoneApp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kk.smartPhoneApp.DTO.SmartPhone;

public class SmartPhoneDAO {
	private Connection con; // Connection
	private Statement st; // Query Run
	private PreparedStatement pstmt;
	private ResultSet rs; // Query Result Set
	private ArrayList<SmartPhone> smartPhoneList = new ArrayList<>();
	// DBColName은 Database의 Column의 이름을 모아둔 배열
	private String DBColName[] = { "Product_Num", "name", "Model", "Price", "Company", "Screen", "Resolution",
			"Scan_Rate", "Ram", "Disk", "Camera", "Battery", "Weight" };

	// ArrayList Getter, Setter
	public ArrayList<SmartPhone> getSmartPhoneList() {
		return smartPhoneList;
	}

	public void setSmartPhoneList(ArrayList<SmartPhone> smartPhoneList) {
		this.smartPhoneList = smartPhoneList;
	}

	// SmartPhoneDAO Constructor => DB Connection , Using MySQL
	public SmartPhoneDAO() {
		String user = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/smartphonetp?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw); // 연결
			st = con.createStatement(); // Creates a Statement object for sendingSQL statements to the database.

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getSmartListsize() {
		return smartPhoneList.size();
	}
	
	public void selectSmartPhone() { // Select * from SmartPhone Query => Using ArrayList
		String SQL = "select * from smartphone";
		try {
			smartPhoneList.clear(); // ArrayList Clear
			rs = st.executeQuery(SQL); // Query Run
			while (rs.next()) {
				int productNum = rs.getInt(DBColName[0]);
				String name = rs.getString(DBColName[1]);
				String model = rs.getString(DBColName[2]);
				int price = rs.getInt(DBColName[3]);
				String company = rs.getString(DBColName[4]);
				double screen = rs.getDouble(DBColName[5]);
				String resolution = rs.getString(DBColName[6]);
				int scanRate = rs.getInt(DBColName[7]);
				int ram = rs.getInt(DBColName[8]);
				int disk = rs.getInt(DBColName[9]);
				int camera = rs.getInt(DBColName[10]);
				int battery = rs.getInt(DBColName[11]);
				int weight = rs.getInt(DBColName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution,
						scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printSmartPhoneList() { // Print ArrayList SmartPhoneList
		for (int i = 0; i < smartPhoneList.size(); i++) {
			smartPhoneList.get(i).pritSmartPhone();
		}
	}

	
	public void searchByOneKeyWordsStringLike(String searchByString, int searchSmartPhoneMenuNum) { // String Data Search by KeyWords Mean Search Query Using "Like" 
		String SQL = "select * from smartphone where " + DBColName[searchSmartPhoneMenuNum - 1] + " like ?";

		try {
			smartPhoneList.clear(); // ArrayList Clear
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, "%" + searchByString + "%");
			rs = pstmt.executeQuery(); // Query Run
			while (rs.next()) {
				int productNum = rs.getInt(DBColName[0]);
				String name = rs.getString(DBColName[1]);
				String model = rs.getString(DBColName[2]);
				int price = rs.getInt(DBColName[3]);
				String company = rs.getString(DBColName[4]);
				double screen = rs.getDouble(DBColName[5]);
				String resolution = rs.getString(DBColName[6]);
				int scanRate = rs.getInt(DBColName[7]);
				int ram = rs.getInt(DBColName[8]);
				int disk = rs.getInt(DBColName[9]);
				int camera = rs.getInt(DBColName[10]);
				int battery = rs.getInt(DBColName[11]);
				int weight = rs.getInt(DBColName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution,
						scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchByOneKeyWordsInteger(int searchByInt, int searchSmartPhoneMenuNum) { // Integer Data Search by KeyWords Mean Search Query Find ">=" Data 
		String SQL = "select * from smartphone where " + DBColName[searchSmartPhoneMenuNum - 1] + " >= ?";

		try {
			smartPhoneList.clear(); // ArrayList Clear
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, searchByInt);
			rs = pstmt.executeQuery(); // Query Run
			while (rs.next()) {
				int productNum = rs.getInt(DBColName[0]);
				String name = rs.getString(DBColName[1]);
				String model = rs.getString(DBColName[2]);
				int price = rs.getInt(DBColName[3]);
				String company = rs.getString(DBColName[4]);
				double screen = rs.getDouble(DBColName[5]);
				String resolution = rs.getString(DBColName[6]);
				int scanRate = rs.getInt(DBColName[7]);
				int ram = rs.getInt(DBColName[8]);
				int disk = rs.getInt(DBColName[9]);
				int camera = rs.getInt(DBColName[10]);
				int battery = rs.getInt(DBColName[11]);
				int weight = rs.getInt(DBColName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution,
						scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchByOneKeyWordsDouble(double searchByDouble, int searchSmartPhoneMenuNum) { // Double Data Search by KeyWords Mean Search Query Find ">=" Data
		String SQL = "select * from smartphone where " + DBColName[searchSmartPhoneMenuNum - 1] + " >= ?";

		try {
			smartPhoneList.clear(); // ArrayList clear
			pstmt = con.prepareStatement(SQL);
			pstmt.setDouble(1, searchByDouble);
			rs = pstmt.executeQuery(); // Query Run
			while (rs.next()) {
				int productNum = rs.getInt(DBColName[0]);
				String name = rs.getString(DBColName[1]);
				String model = rs.getString(DBColName[2]);
				int price = rs.getInt(DBColName[3]);
				String company = rs.getString(DBColName[4]);
				double screen = rs.getDouble(DBColName[5]);
				String resolution = rs.getString(DBColName[6]);
				int scanRate = rs.getInt(DBColName[7]);
				int ram = rs.getInt(DBColName[8]);
				int disk = rs.getInt(DBColName[9]);
				int camera = rs.getInt(DBColName[10]);
				int battery = rs.getInt(DBColName[11]);
				int weight = rs.getInt(DBColName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution,
						scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertSmartPhoneInfo(SmartPhone sm) { // Insert Query
		String SQL = "insert into SmartPhone("
				+ DBColName[1] + ", " + DBColName[2] + ", "
				+ DBColName[3] + ", " + DBColName[4] + ", "
				+ DBColName[5] + ", " + DBColName[6] + ", "
				+ DBColName[7] + ", " + DBColName[8] + ", "
				+ DBColName[9] + ", " + DBColName[10] + ", "
				+ DBColName[11] + ", " + DBColName[12] + ") "
				+"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, sm.getName());
			pstmt.setString(2, sm.getModel());
			pstmt.setInt(3, sm.getPrice());
			pstmt.setString(4, sm.getCompany());
			pstmt.setDouble(5, sm.getScreen());
			pstmt.setString(6, sm.getResolution());
			pstmt.setInt(7, sm.getScan_Rate());
			pstmt.setInt(8, sm.getRam());
			pstmt.setInt(9, sm.getDisk());
			pstmt.setInt(10, sm.getCamera());
			pstmt.setInt(11, sm.getBattery());
			pstmt.setInt(12, sm.getWeight());
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifySmartPhoneOnePointByString(int ProdNum, String modifyByString, int modifySmartPhoneMenuNum) { // Update Query Input Data String 
		String SQL = "update Smartphone "
				+ "set " + DBColName[modifySmartPhoneMenuNum - 1] + " = ? "
						+ "where " + DBColName[0] + " = ?";
		try {
			smartPhoneList.clear();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, modifyByString);
			pstmt.setInt(2, ProdNum);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void modifySmartPhoneOnePointByInteger(int ProdNum, int modifyByInteger, int modifySmartPhoneMenuNum) { // Update Query Input Data Integer
		String SQL = "update Smartphone "
				+ "set " + DBColName[modifySmartPhoneMenuNum - 1] + " = ? "
						+ "where " + DBColName[0] + " = ?";
		try {
			smartPhoneList.clear();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, modifyByInteger);
			pstmt.setInt(2, ProdNum);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void modifySmartPhoneOnePointByDouble(int ProdNum, double modifyByDouble, int modifySmartPhoneMenuNum) { // Update Query Input Data Double
		String SQL = "update Smartphone "
				+ "set " + DBColName[modifySmartPhoneMenuNum - 1] + " = ? "
						+ "where " + DBColName[0] + " = ?";
		try {
			smartPhoneList.clear();
			pstmt = con.prepareStatement(SQL);
			pstmt.setDouble(1, modifyByDouble);
			pstmt.setInt(2, ProdNum);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSmartPhoneDataCols(int deleteIndex) { // Delete Query
		String SQL = "Delete FROM SmartPhone "
				+ "where " + DBColName[0] + " = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, deleteIndex);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void quit() { // Database Close
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}









}
