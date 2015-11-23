package com.bansach.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bansach.model.bean.NhanVien;

public class NhanVienDAO {
	private String sqlGetTatCaNhanVien = "SELECT MaNhanVien, Ten, TenDangNhap, MatKhau, GhiChu FROM tblNhanVien";
	private String sqlGetNhanVienTheoMa = "SELECT MaNhanVien, Ten, TenDangNhap, MatKhau, GhiChu FROM tblNhanVien WHERE MaNhanVien = ?";
	private String sqlGetNhanVienTheoTenDangNhapVaMatKhau = "SELECT MaNhanVien, Ten, TenDangNhap, MatKhau, GhiChu FROM tblNhanVien WHERE TenDangNhap = ? AND MatKhau = ?";
	private String sqlAddNhanVien = "INSERT INTO tblNhanVien (Ten, TenDangNhap, MatKhau, GhiChu) VALUES (?, ?, ?, ?)";
	private String sqlUpdateNhanVien = "UPDATE tblNhanVien SET Ten = ?, TenDangNhap = ?, MatKhau = ?, GhiChu = ? WHERE MaNhanVien = ?";
	private String sqlDeleteNhanVien = "DELETE FROM tblNhanVien WHERE MaNhanVien = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<NhanVien> listNhanVien = null;
	private NhanVien nhanVien = null;

	public ArrayList<NhanVien> getTatCaNhanVien() {
		this.listNhanVien = new ArrayList<NhanVien>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaNhanVien);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.nhanVien = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				this.listNhanVien.add(this.nhanVien);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listNhanVien;
	}

	public NhanVien getNhanVienTheoMa(int maNhanVien) {
		this.nhanVien = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetNhanVienTheoMa);
			
			pstmt.setInt(1, maNhanVien);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.nhanVien = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.nhanVien;
	}

	public NhanVien getNhanVienTheoTenDangNhapVaMatKhau(String tenDangNhap,
			String matKhau) {
		this.nhanVien = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetNhanVienTheoTenDangNhapVaMatKhau);
			
			pstmt.setString(1, tenDangNhap);
			pstmt.setString(2, matKhau);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.nhanVien = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.nhanVien;
	}

	public int addNhanVien(NhanVien nv) {
		int result = 0;
		
		 try {
			 con = SQLConnection.getConnection();
			 pstmt = con.prepareStatement(sqlAddNhanVien);
			 
			 pstmt.setString(1, nv.getTen());
			 pstmt.setString(2, nv.getTenDangNhap());
			 pstmt.setString(3, nv.getMatKhau());
			 pstmt.setString(4, nv.getGhiChu());
			 
			 result = pstmt.executeUpdate();
			 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		 }
		
		return result;
	}

	public int updateNhanVien(NhanVien nv) {
		int result = 0;
		
		 try {
			 con = SQLConnection.getConnection();
			 pstmt = con.prepareStatement(sqlUpdateNhanVien);
			 
			 pstmt.setString(1, nv.getTen());
			 pstmt.setString(2, nv.getTenDangNhap());
			 pstmt.setString(3, nv.getMatKhau());
			 pstmt.setString(4, nv.getGhiChu());
			 pstmt.setInt(5, nv.getMaNhanVien());
			 
			 result = pstmt.executeUpdate();
			 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		 }
		
		return result;
	}

	public int deleteNhanVien(int maNhanVien) {
		int result = 0;
		
		 try {
			 con = SQLConnection.getConnection();
			 pstmt = con.prepareStatement(sqlDeleteNhanVien);
			 
			 pstmt.setInt(1, maNhanVien);
			 
			 result = pstmt.executeUpdate();
			 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		 }
		
		return result;
	}

}
