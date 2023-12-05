package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CommonFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 다음 필터가 있는지 호출하는 메서드 : 꼭필요함
        chain.doFilter(new CommonRequestWrapper((HttpServletRequest) request) , response);

        HttpServletRequest req = (HttpServletRequest) request; // 상위클래스를 하위클래스로 형변환
    }
}
