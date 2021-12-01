package com.Project.goods.svc;

import com.Project.goods.dao.GoodsDAO;

import java.sql.Connection;

import static com.Project.goods.db.JdbcUtil.*;

public class DeleteProService {
   public boolean removeArticle(int id)throws Exception{
       boolean isRemoveSuccess = false;
       Connection con = getConnection();
       GoodsDAO goodsDAO = GoodsDAO.getInstance();
       goodsDAO.setConnection(con);
       int deleteCount = goodsDAO.deleteArticle(id);

       if (deleteCount > 0) {
           commit(con);
           isRemoveSuccess = true;
       }
       else {
           rollback(con);
       }
       close(con);
       return isRemoveSuccess;
   }
}
