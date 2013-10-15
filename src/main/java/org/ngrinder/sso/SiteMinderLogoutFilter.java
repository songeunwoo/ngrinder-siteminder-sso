package org.ngrinder.sso;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.ngrinder.service.IConfig;

public class SiteMinderLogoutFilter implements Filter {

	private IConfig config;

	public SiteMinderLogoutFilter(IConfig config) {
		this.config = config;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(final ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (httpServletRequest.getRequestURI().endsWith("/logout")) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			String domain = config.getSystemProperties().getProperty("ngrinder.sso.domain", "");
			String cookiename = config.getSystemProperties().getProperty("ngrinder.sso.cookiename", "");
			if (StringUtils.isNotBlank(cookiename) && StringUtils.isNotBlank(domain)) {
				Cookie cookie = new Cookie(cookiename, "");
				cookie.setDomain(domain);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				httpServletResponse.addCookie(cookie);
				Cookie smText = new Cookie("SMTEXT", "");
				smText.setDomain(domain);
				smText.setMaxAge(0);
				smText.setPath("/");
				httpServletResponse.addCookie(smText);
			}
			Cookie switchUser = new Cookie("switchUser", "");
			switchUser.setMaxAge(0);
			switchUser.setPath("/");
			httpServletResponse.addCookie(switchUser);
		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
	}

}
