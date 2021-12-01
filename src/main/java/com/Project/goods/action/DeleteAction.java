package com.Project.goods.action;

import com.Project.goods.svc.DeleteProService;
import com.Project.goods.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class DeleteAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
       ActionForward forward = null;
       int goods_id = Integer.parseInt(request.getParameter("id"));
       String nowPage = request.getParameter("page");
       DeleteProService deleteProService = new DeleteProService();
        boolean isDeleteSuccess = deleteProService.removeArticle(goods_id);
        if (!isDeleteSuccess){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            out.println("<script>");
            out.println("alert('삭제 실패');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        }
        else {
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("/admin/List.gd");
        }



        return forward;
    }
}
