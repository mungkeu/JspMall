package common;

import member.MemberDAO;
import member.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/member_servlet/*")
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberController(){}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url = request.getRequestURI(); // 사용자가 요청한 주소
        String context = request.getContextPath(); // 프로젝트 식별자
        System.out.println(url);
        MemberDAO dao = new MemberDAO();
        if(url.indexOf("list.do")!=-1){ // 해당하는 문자열이 존재하지 않으면 -1을 반환
            Map<String,Object> map = new HashMap<>();
            List<MemberDTO> list = dao.memberList();
            map.put("list",list); // 맵에 저장
            map.put("count",list.size()); // 리스트의 아이템 개수
            request.setAttribute("map",map); // 자료 저장
            String page="/member/list.jsp"; // 출력 페이지
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request,response);
        }else if(url.indexOf("join.do")!=-1){
            String userid=request.getParameter("userid");
            String passwd=request.getParameter("passwd");
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            String tel = request.getParameter("tel");
            MemberDTO dto = new MemberDTO(userid,passwd,name,address,tel);
            dao.insert(dto);
            response.sendRedirect(context+"/member_servlet/list.do");
        }else if(url.indexOf("view.do")!=-1){
            String userid = request.getParameter("userid");
            MemberDTO dto = dao.memberDetail(userid);
            request.setAttribute("dto",dto);
            String page = "/member/view.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request,response);
        }else if(url.indexOf("update.do")!=-1){
            String userid=request.getParameter("userid");
            String passwd=request.getParameter("passwd");
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            String tel=request.getParameter("tel");
            MemberDTO dto = new MemberDTO(userid,passwd,name,address,tel);
            dao.update(dto);
            response.sendRedirect(context+"/member_servlet/list.do");
        }else if(url.indexOf("delete.do")!=-1){
            String userid=request.getParameter("userid");
            dao.delete(userid);
            response.sendRedirect(context+"/member_servlet/list.do");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

}
