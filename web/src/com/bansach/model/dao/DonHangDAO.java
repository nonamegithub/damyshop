package com.bansach.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bansach.model.bean.DonHang;

public class DonHangDAO {
	private String sqlGetTatCaDonHang = "SELECT MaDonHang, MaKhachHang, NgayDat, GhiChu, TrangThai FROM tblDonHang";
	private String sqlGetDonHangChuaXem = "SELECT MaDonHang, MaKhachHang, NgayDat, GhiChu, TrangThai FROM tblDonHang WHERE TrangThai = 'ChuaXem'";
	private String sqlGetDonHangTheoMa = "SELECT MaDonHang, MaKhachHang, NgayDat, GhiChu, TrangThai FROM tblDonHang WHERE MaDonHang = ?";
	private String sqlAddDonHang = "INSERT INTO tblDonHang (MaKhachHang, NgayDat, GhiChu, TrangThai)  OUTPUT INSERTED.MaDonHang VALUES (?, ?, ?, ?)";
	private String sqlUpdateDonHang = "UPDATE tblDonHang SET GhiChu = ?, TrangThai = ? WHERE MaDonHang = ?";
	private String sqlDeleteDonHang = "DELETE FROM tblDonHang WHERE MaDonHang = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<DonHang> listDonHang = null;
	private DonHang donHang = null;

	public ArrayList<DonHang> getTatCaDonHang() {
		this.listDonHang = new ArrayList<DonHang>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaDonHang);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.donHang = new DonHang(rs.getInt(1), rs.getInt(2),
						rs.getTimestamp(3), rs.getString(4), rs.getString(5));
				this.listDonHang.add(this.donHang);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.listDonHang;
	}

	public DonHang getDonHangTheoMa(int maDonHang) {
		this.donHang = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetDonHangTheoMa);
			pstmt.setInt(1, maDonHang);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.donHang = new DonHang(rs.getInt(1), rs.getInt(2),
						rs.getTimestamp(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.donHang;
	}

	public int addDonHang(DonHang dh) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddDonHang);

			pstmt.setInt(1, dh.getMaKhachHang());
			pstmt.setTimestamp(2, dh.getNgayDat());
			pstmt.setString(3, dh.getGhiChu());
			pstmt.setString(4, dh.getTrangThai());

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

	public int updateDonHang(DonHang dh) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateDonHang);

			pstmt.setString(1, dh.getGhiChu());
			pstmt.setString(2, dh.getTrangThai());
			pstmt.setInt(3, dh.getMaDonHang());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public int deleteDonHang(int maDonHang) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteDonHang);

			pstmt.setInt(1, maDonHang);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public ArrayList<DonHang> getDonHangChuaXem() {
		this.listDonHang = new ArrayList<DonHang>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetDonHangChuaXem);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.donHang = new DonHang(rs.getInt(1), rs.getInt(2),
						rs.getTimestamp(3), rs.getString(4), rs.getString(5));
				this.listDonHang.add(this.donHang);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.listDonHang;
	}

}
