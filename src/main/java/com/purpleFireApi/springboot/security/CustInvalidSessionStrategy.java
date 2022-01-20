package com.purpleFireApi.springboot.security;

import java.io.IOError;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

public class CustInvalidSessionStrategy implements InvalidSessionStrategy {

    private final Log logger = LogFactory.getLog(this.getClass());
    private String destinationUrl = null;
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private boolean createNewSession = true;

    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOError, IOException {
        this.logger.debug("Starting new session (if required) and redirecting to '" + this.destinationUrl + "'");
        if (this.createNewSession) {
            request.getSession();
        }

        if (destinationUrl == null) {
            this.redirectStrategy.sendRedirect(request, response, request.getRequestURI());
        } else {
            this.redirectStrategy.sendRedirect(request, response, this.destinationUrl);
        }
    }

    public void setCreateNewSession(final boolean createNewSession) {
        this.createNewSession = createNewSession;
    }

    public void setInvalidSessionUrl(final String invalidSessionUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSessionUrl), "url must start with '/' or with 'http(s)'");
        this.destinationUrl = invalidSessionUrl;
    }
}