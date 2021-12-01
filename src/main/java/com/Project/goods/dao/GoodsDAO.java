package com.Project.goods.dao;

import com.Project.goods.vo.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.Project.goods.db.JdbcUtil.close;


public class GoodsDAO {

	Connection con;
	private static GoodsDAO goodsDAO;

	private GoodsDAO() {

	}

	public void setConnection(Connection con){
		this.con = con;
	}

	public static GoodsDAO getInstance(){

		if(goodsDAO ==null){
			goodsDAO = new GoodsDAO();
		}

		return goodsDAO;
	}

	public ArrayList<Goods> selectGoodsList() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Goods> goodsList = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM goods");
			rs = pstmt.executeQuery();

			if(rs.next()){
				goodsList = new ArrayList<Goods>();

				do {
					goodsList.add(new Goods(
							rs.getInt("id")
							,rs.getString("name")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getInt("size")
							,rs.getString("color")
							,rs.getString("content")
							,rs.getInt("readcount")));
				} while (rs.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return goodsList;
	}

	public Goods selectGoods(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM goods WHERE id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()){
				goods = new Goods(
						rs.getInt("id")
						,rs.getString("name")
						,rs.getInt("price")
						,rs.getString("image")
						,rs.getInt("size")
						,rs.getString("color")
						,rs.getString("content")
						,rs.getInt("readcount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return goods;
	}

	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";

		try {
			sql = "UPDATE goods SET readcount = readcount + 1 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

	public int insertGoods(Goods goods) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";

		try {
			sql = "INSERT INTO goods VALUES(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,goods.getId());
			pstmt.setString(2,goods.getName());
			pstmt.setInt(3,goods.getPrice());
			pstmt.setString(4,goods.getImage());
			pstmt.setInt(5,goods.getSize());
			pstmt.setString(6,goods.getColor());
			pstmt.setString(7,goods.getContent());
			pstmt.setInt(8,goods.getReadcount());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public int deleteArticle(int id) {
		PreparedStatement pstmt =null;
		String goods_delte_sql ="delete from goods where id =?";
		int deleteCount =0;

		try {
			pstmt=con.prepareStatement(goods_delte_sql);
			pstmt.setInt(1,id);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException throwables) {
			System.out.println("goodsDelete 에러" + throwables);
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}


}
