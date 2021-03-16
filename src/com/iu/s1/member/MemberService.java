package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;

import com.iu.s1.util.ActionFoward;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	//memberLogin
	


	public ActionFoward memberJoin(HttpServletRequest request)throws Exception{
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		actionFoward.setPath("../WEB-INF/member/memberJoin.jsp");
		if(method.toUpperCase().equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setName(request.getParameter("name"));
			memberDTO.setEmail(request.getParameter("email"));
			memberDTO.setMobile(request.getParameter("mobile"));
			int result = memberDAO.memberJoin(memberDTO);
			actionFoward.setPath("../index.jsp");
		}
		
		
		return actionFoward;
	}

}