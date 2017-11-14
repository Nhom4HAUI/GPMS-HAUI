package com.truongdx.config;

import java.io.IOException;
import java.util.Collection;

import javax.security.auth.message.callback.PrivateKeyCallback.IssuerSerialNumRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;



@Component
/*Classes custom login susscess*/
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		handle(request, response, authentication);
		clearAuthenticationAttributes(request);

	}

	private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl = determineTargerUrl(authentication);
		 redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargerUrl(Authentication authentication) {
		boolean isStudent = false;
		boolean isAdmin = false;
		boolean isLecturer = false;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority grantedAuthority: authorities) {
			if(grantedAuthority.getAuthority().equals("ROLE_STUDENT")) {
				isStudent = true;
			}
			else if(grantedAuthority.getAuthority().equals("ROLE_LECTURE")) {
				isLecturer = true;
			}
			else if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		}
		if(isAdmin) {
			return "/admin";
		}else if(isLecturer) {
			return "/Test";
		}else if(isStudent) {
			return "/";
		}
		else {
			return "/";
		}
	}

	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	

}
