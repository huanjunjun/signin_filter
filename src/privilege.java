import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;

import domain.user;

public class privilege implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//判斷用於已經登陸
	   HttpServletRequest request= (HttpServletRequest) arg0;
		user user1=(user) request.getSession().getAttribute("existUser");
	    if(user1 == null)
	    {
	    	//跳转登录界面
	    	request.getSession().setAttribute("msg", "您还没有登录，无法访问！");
	    	request.getRequestDispatcher("/login.jsp").forward(request, arg1);;
	    }
	    else {
			//放行
	    	arg2.doFilter(request, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
