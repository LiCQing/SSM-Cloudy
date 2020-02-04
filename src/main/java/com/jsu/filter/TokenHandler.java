package com.jsu.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.alibaba.druid.support.json.JSONUtils;
import com.jsu.util.AESUtil;

/**
 * Servlet Filter implementation class TokenHandler
 */
@WebFilter("/*")
public class TokenHandler implements Filter {

    /**
     * Default constructor. 
     */
    public TokenHandler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String token = request.getParameter("token");
		if(token == null || token.equals("")){
			 //return;
		}else{
			if(token.indexOf("ISGETCODE")==-1){
				//将请求参数置于request 属性中
				String userId = AESUtil.dcodes(token);
				request.setAttribute("uid", userId);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/* private static class RequestWrapper extends HttpServletRequestWrapper {//这里用的是内部类，也可以不用
	        
	        private Map<String, String[]> params = new HashMap<String, String[]>();//将request对象中的参数修改后，放在这个集合里，随后项目取的所有Parameter都是从这个集合中取数
	        
	        public RequestWrapper(HttpServletRequest request) {//定义构造函数
	            super(request);//将request交给父类

	            //先通过request原生的方法，遍历获取到的参数
	            Enumeration enu=request.getParameterNames(); 
	            while (enu.hasMoreElements()) {
	                String paraName=(String)enu.nextElement();
	                
	                Map<String, Object> paraObj = (Map<String, Object>)JSONUtils.parse(paraName);//因为我前台传过来的是json格式的参数
	                Set<Entry<String, Object>> entrySet = paraObj.entrySet();
	                for (Entry<String, Object> entry : entrySet) {
	                    String key = entry.getKey();
	                    Object value = entry.getValue();
	                    params.put(key, value);//
	                }
	            }
	            //在这里修改params中的数据，不管是添加、修改
	            
	            //将修改好的params重新放入RequestWrapper对象中
	            addParameters(request,params);
	        }
	        public void addAllParameters(Map<String , Object>otherParams) {//增加多个参数
	            for(Map.Entry<String , Object>entry : otherParams.entrySet()) {
	                addParameter(entry.getKey() , entry.getValue());
	            }
	        }
	        @Override
	        public String getParameter(String name) {
	             String[]values = params.get(name);
	             if(values == null || values.length == 0) {
	                 return null;
	             }
	             return StringEscapeUtils.escapeHtml4(values[0]);
	        }
	        @Override
	        public Enumeration<String> getParameterNames() {
	            Vector<String> v = new Vector<String>();
	            Set<Entry<String, String[]>> entrySet = params.entrySet();
	            for (Entry<String, String[]> entry : entrySet) {
	                v.add(entry.getKey());
	            }
	            Enumeration<String> en =  v.elements();

	            return v.elements();
	        }
	        
	        @Override
	        public String[] getParameterValues(String name) {
	            return params.get(name);
	        }
	    }
	}*/

}
