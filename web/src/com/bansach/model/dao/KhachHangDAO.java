package com.bansach.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bansach.model.bean.KhachHang;

public class KhachHangDAO {
	private String sqlGetTatCaKhachHang = "SELECT MaKhachHang, Ten, Email, SoDienThoai, NgaySinh, DiaChi, GhiChu FROM tblKhachHang";
	private String sqlGetKhachHangTheoMa = "SELECT MaKhachHang, Ten, Email, SoDienThoai, NgaySinh, DiaChi, GhiChu FROM tblKhachHang WHERE MaKhachHang = ?";
	private String sqlAddKhachHang = "INSERT INTO tblKhachHang (Ten, Email, SoDienThoai, NgaySinh, DiaChi, GhiChu) OUTPUT INSERTED.MaKhachHang VALUES (?, ?, ?, ?, ?, ?)";
	private String sqlUpdateKhachHang = "UPDATE tblKhachHang SET Ten = ?, Email = ?, SoDienThoai = ?, NgaySinh = ?, DiaChi = ?, GhiChu = ? WHERE MaKhachHang = ?";
	private String sqlDeleteKhachHang = "DELETE FROM tblKhachHang WHERE MaKhachHang = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<KhachHang> listKhachHang = null;
	private KhachHang khachHang = null;

	public ArrayList<KhachHang> getTatCaKhachHang() {
		this.listKhachHang = new ArrayList<KhachHang>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaKhachHang);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.khachHang = new KhachHang(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				this.listKhachHang.add(this.khachHang);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.listKhachHang;
	}

	public KhachHang getKhachHangTheoMa(int maKhacHang) {
		this.khachHang = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetKhachHangTheoMa);
			pstmt.setInt(1, maKhacHang);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.khachHang = new KhachHang(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.khachHang;
	}

	public int addKhachHang(KhachHang kh) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddKhachHang);
			pstmt.setString(1, kh.getTen());
			pstmt.setString(2, kh.getEmail());
			pstmt.setString(3, kh.getSoDienThoai());
			pstmt.setString(4, kh.getNgaySinh());
			pstmt.setString(5, kh.getDiaChi());
			pstmt.setString(6, kh.getGhiChu());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public int updateKhachHang(KhachHang kh) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateKhachHang);
			pstmt.setString(1, kh.getTen());
			pstmt.setString(2, kh.getEmail());
			pstmt.setString(3, kh.getSoDienThoai());
			pstmt.setString(4, kh.getNgaySinh());
			pstmt.setString(5, kh.getDiaChi());
			pstmt.setString(6, kh.getGhiChu());
			pstmt.setInt(7, kh.getMaKhachHang());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public int deleteKhachHang(int maKhachHang) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteKhachHang);

			pstmt.setInt(1, maKhachHang);

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
