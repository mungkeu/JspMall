package common;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", value = "/*") // all url pattern
public class EncodingFilter implements Filter {

    private String charset="utf-8";

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // main action 전에 선처리할 코드
        request.setCharacterEncoding(charset);

        // 요청한 main action 실행
        chain.doFilter(request, response);
    }
}
