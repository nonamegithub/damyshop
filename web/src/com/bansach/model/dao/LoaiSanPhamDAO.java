package com.bansach.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bansach.model.bean.LoaiSanPham;

public class LoaiSanPhamDAO {
	private String sqlGetTatCaLoaiSanPham = "SELECT MaLoai, Ten, MoTa FROM tblLoaiSanPham";
	private String sqlGetLoaiSanPhamTheoMa = "SELECT MaLoai, Ten, MoTa FROM tblLoaiSanPham WHERE MaLoai = ?";
	private String sqlAddLoaiSanPham = "INSERT INTO tblLoaiSanPham (Ten, MoTa) VALUES (?, ?)";
	private String sqlUpdateLoaiSanPham = "UPDATE tblLoaiSanPham SET Ten = ?, MoTa = ? WHERE MaLoai = ?";
	private String sqlDeleteLoaiSanPham = "DELETE FROM tblLoaiSanPham WHERE MaLoai = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<LoaiSanPham> listLoaiSanPham = null;
	private LoaiSanPham loaiSanPham = null;

	public ArrayList<LoaiSanPham> getTatCaLoaiSanPham() {
		this.listLoaiSanPham = new ArrayList<LoaiSanPham>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaLoaiSanPham);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.loaiSanPham = new LoaiSanPham(rs.getInt(1), rs.getString(2),
						rs.getString(3));
				this.listLoaiSanPham.add(this.loaiSanPham);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.listLoaiSanPham;
	}

	public LoaiSanPham getLoaiSanPhamTheoMa(int maLoaiSanPham) {
		this.loaiSanPham = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetLoaiSanPhamTheoMa);
			pstmt.setInt(1, maLoaiSanPham);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				this.loaiSanPham = new LoaiSanPham(rs.getInt(1), rs.getString(2),
						rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.loaiSanPham;
	}

	public int addLoaiSanPham(LoaiSanPham lsp) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddLoaiSanPham);

			pstmt.setString(1, lsp.getTen());
			pstmt.setString(2, lsp.getMoTa());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public int updateLoaiSanPham(LoaiSanPham lsp) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateLoaiSanPham);

			pstmt.setString(1, lsp.getTen());
			pstmt.setString(2, lsp.getMoTa());
			pstmt.setInt(3, lsp.getMaLoai());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	public int deleteLoaiSanPham(int maLoaiSanPham) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteLoaiSanPham);

			pstmt.setInt(1, maLoaiSanPham);

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
