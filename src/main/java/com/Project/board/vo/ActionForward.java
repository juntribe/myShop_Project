package com.Project.board.vo;

public class ActionForward {
    // 서블릿에서 요청 처리 후 포워딩될 최종 뷰 페이지 url이 저장되는 변수 정의
    private String path=null;
    // 포워딩 방식이 저장되는 변수 값이 false 면 디스패치 방식으로 true면 리다이렉트 방식으로 포워딩한다.
    private boolean isRedirect=false;

   public boolean isRedirect(){
       return isRedirect;
   }
   public String getPath(){
       return path;
   }
   public void setRedirect(boolean b){
       isRedirect=b;
   }
   public void setPath(String string){
       path=string;
   }
}
