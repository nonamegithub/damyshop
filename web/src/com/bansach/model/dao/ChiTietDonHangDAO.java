package com.bansach.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bansach.model.bean.ChiTietDonHang;

public class ChiTietDonHangDAO {
	private String sqlGetTatCaChiTietDonHang = "SELECT MaDonHang, MaSanPham, Gia, SoLuong FROM tblChiTietDonHang";
	private String sqlGetChiTietDonHangTheoMa = "SELECT MaDonHang, MaSanPham, Gia, SoLuong FROM tblChiTietDonHang WHERE MaDonHang = ? AND MaSanPham = ?";
	private String sqlChiTietDonHangTheoMaDonHang = "SELECT MaDonHang, MaSanPham, Gia, SoLuong FROM tblChiTietDonHang WHERE MaDonHang = ?";
	private String sqlAddChiTietDonHang = "INSERT INTO tblChiTietDonHang (MaDonHang, MaSanPham, Gia, SoLuong) VALUES (?, ?, ?, ?)";
	private String sqlUpdateChiTietDonHang = "UPDATE tblChiTietDonHang SET Gia = ?, SoLuong = ? WHERE MaDonHang = ? AND MaSanPham = ?";
	private String sqlDeleteChiTietDonHang = "DELETE FROM tblChiTietDonHang WHERE MaDonHang = ? AND MaSanPham = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<ChiTietDonHang> listChiTietDonHang = null;
	private ChiTietDonHang chiTietDonHang = null;

	public ArrayList<ChiTietDonHang> getTatCaChiTietDonHang() {
		this.listChiTietDonHang = new ArrayList<ChiTietDonHang>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaChiTietDonHang);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.chiTietDonHang = new ChiTietDonHang(rs.getInt(1),
						rs.getInt(2), rs.getBigDecimal(3), rs.getInt(4));
				this.listChiTietDonHang.add(this.chiTietDonHang);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.listChiTietDonHang;
	}

	public ChiTietDonHang getChiTietDonHangTheoMa(int maDonHang, int maSanPham) {
		this.chiTietDonHang = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetChiTietDonHangTheoMa);

			pstmt.setInt(1, maDonHang);
			pstmt.setInt(2, maSanPham);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.chiTietDonHang = new ChiTietDonHang(rs.getInt(1),
						rs.getInt(2), rs.getBigDecimal(3), rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.chiTietDonHang;
	}

	public int addChiTietDonHang(ChiTietDonHang ctdh) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddChiTietDonHang);

			pstmt.setInt(1, ctdh.getMaDonHang());
			pstmt.setInt(2, ctdh.getMaSanPham());
			pstmt.setBigDecimal(3, ctdh.getGia());
			pstmt.setInt(4, ctdh.getSoLuong());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public int updateChiTietDonHang(ChiTietDonHang ctdh) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateChiTietDonHang);

			pstmt.setBigDecimal(1, ctdh.getGia());
			pstmt.setInt(2, ctdh.getSoLuong());
			pstmt.setInt(3, ctdh.getMaDonHang());
			pstmt.setInt(4, ctdh.getMaSanPham());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public int deleteChiTietDonHang(int maDonHang, int maSanPham) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteChiTietDonHang);

			pstmt.setInt(1, maDonHang);
			pstmt.setInt(2, maSanPham);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public ArrayList<ChiTietDonHang> getChiTietDonHangTheoMaDonHang(
			int maDonHang) {
		this.listChiTietDonHang = new ArrayList<ChiTietDonHang>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlChiTietDonHangTheoMaDonHang);
			pstmt.setInt(1, maDonHang);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.chiTietDonHang = new ChiTietDonHang(rs.getInt(1),
						rs.getInt(2), rs.getBigDecimal(3), rs.getInt(4));
				this.listChiTietDonHang.add(this.chiTietDonHang);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.listChiTietDonHang;
	}

}
