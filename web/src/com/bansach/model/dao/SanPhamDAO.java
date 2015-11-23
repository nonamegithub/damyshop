package com.bansach.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bansach.model.bean.SanPham;

public class SanPhamDAO {
	private String sqlGetTatCaSanPham = "SELECT MaSanPham, MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia FROM tblSanPham ORDER BY MaSanPham DESC";
	private String sqlGetRandomSanPham = "SELECT MaSanPham, MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia FROM tblSanPham ORDER BY NEWID()";
	private String sqlGetSanPhamTheoMa = "SELECT MaSanPham, MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia FROM tblSanPham WHERE MaSanPham = ?";
	private String sqlGetSanPhamTheoLoai = "SELECT MaSanPham, MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia FROM tblSanPham WHERE MaLoai = ?";
	private String sqlGetSanPhamTheoTen = "SELECT MaSanPham, MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia FROM tblSanPham WHERE Ten LIKE ? COLLATE Latin1_General_CI_AI";
	private String sqlGetSanPhamTheoTacGia = "SELECT MaSanPham, MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia FROM tblSanPham WHERE TacGia LIKE ? COLLATE Latin1_General_CI_AI";
	private String sqlGetSanPhamTheoMoTa = "SELECT MaSanPham, MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia FROM tblSanPham WHERE MoTa LIKE ? COLLATE Latin1_General_CI_AI";
	private String sqlAddSanPham = "INSERT INTO tblSanPham (MaLoai, Ten, Gia, NhaXuatBan, TrongLuong, KichThuoc, SoTrang, MoTa, Anh, TacGia)  VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String sqlUpdateSanPham = "UPDATE tblSanPham SET MaLoai = ?, Ten = ?, Gia = ?, NhaXuatBan = ?, TrongLuong = ?, KichThuoc = ?, SoTrang = ?, MoTa = ?, Anh = ?, TacGia = ? WHERE MaSanPham = ?";
	private String sqlDeleteSanPham = "DELETE FROM tblSanPham WHERE MaSanPham = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<SanPham> listSanPham = null;
	private SanPham sanPham = null;

	public ArrayList<SanPham> getTatCaSanPham() {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaSanPham);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}
	
	public ArrayList<SanPham> getSanPhamTheoLoai(int maLoai) {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetSanPhamTheoLoai);
			pstmt.setInt(1, maLoai);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}
	
	public ArrayList<SanPham> getSanPhamTheoTen(String ten) {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetSanPhamTheoTen);
			pstmt.setString(1, "%" + ten + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}
	
	public ArrayList<SanPham> getTopSanPham(int soDong) {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaSanPham);
			pstmt.setMaxRows(soDong);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}
	
	public ArrayList<SanPham> getRandomSanPham(int soDong) {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetRandomSanPham);
			pstmt.setMaxRows(soDong);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}

	public SanPham getSanPhamTheoMa(int maSanPham) {
		this.sanPham = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetSanPhamTheoMa);
			pstmt.setInt(1, maSanPham);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.sanPham;
	}
	
	public ArrayList<SanPham> getTopSanPhamTheoLoai(int maLoai, int soDong) {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetSanPhamTheoLoai);
			pstmt.setInt(1, maLoai);
			pstmt.setMaxRows(soDong);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}

	public int addSanPham(SanPham sp) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddSanPham);
			
			pstmt.setInt(1, sp.getMaLoai());
			pstmt.setString(2, sp.getTen());
			pstmt.setBigDecimal(3, sp.getGia());
			pstmt.setString(4, sp.getNhaXuatBan());
			pstmt.setInt(5, sp.getTrongLuong());
			pstmt.setString(6, sp.getKichThuoc());
			pstmt.setInt(7, sp.getSoTrang());
			pstmt.setString(8, sp.getMoTa());
			pstmt.setString(9, sp.getAnh());
			pstmt.setString(10, sp.getTacGia());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}

	public int updateSanPham(SanPham sp) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateSanPham);
			
			pstmt.setInt(1, sp.getMaLoai());
			pstmt.setString(2, sp.getTen());
			pstmt.setBigDecimal(3, sp.getGia());
			pstmt.setString(4, sp.getNhaXuatBan());
			pstmt.setInt(5, sp.getTrongLuong());
			pstmt.setString(6, sp.getKichThuoc());
			pstmt.setInt(7, sp.getSoTrang());
			pstmt.setString(8, sp.getMoTa());
			pstmt.setString(9, sp.getAnh());
			pstmt.setString(10, sp.getTacGia());
			pstmt.setInt(11, sp.getMaSanPham());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}

	public int deleteSanPham(int maSanPham) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteSanPham);
			
			pstmt.setInt(1, maSanPham);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}

	public ArrayList<SanPham> getSanPhamTheoTacGia(String tacGia) {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetSanPhamTheoTacGia);
			pstmt.setString(1, "%" + tacGia + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}

	public ArrayList<SanPham> getSanPhamTheoMoTa(String moTa) {
		this.listSanPham = new ArrayList<SanPham>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetSanPhamTheoMoTa);
			pstmt.setString(1, "%" + moTa + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
				this.listSanPham.add(this.sanPham);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.listSanPham;
	}

	public SanPham getRandomSanPham() {
		this.sanPham = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetRandomSanPham);
			pstmt.setMaxRows(1);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.sanPham = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.sanPham;
	}

}
