package com.Project.goods.action;

import com.Project.goods.svc.RegistService;
import com.Project.goods.vo.ActionForward;
import com.Project.goods.vo.Goods;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class RegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RegistService registService = new RegistService();
		String realFolder = "";
		//파일 업로드될 서버 상의 물리적인 경로
		
		String saveFolder = "/image";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		// 한번에 업로드 할 수 있는 파일의 크기
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		Goods goods = new Goods(	0,
				multi.getParameter("name"),
				Integer.parseInt(multi.getParameter("price")),
				image,
				Integer.parseInt(multi.getParameter("size")),
				multi.getParameter("color"),
				multi.getParameter("content"),
				0);

		boolean isRegistSuccess = registService.registGoods(goods);
		ActionForward forward = null;
		
		if(isRegistSuccess){
			forward = new ActionForward("/admin/List.gd", true);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
