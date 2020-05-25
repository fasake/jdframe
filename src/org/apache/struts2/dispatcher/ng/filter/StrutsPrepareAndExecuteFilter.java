/*
 * $Id: DefaultActionSupport.java 651946 2008-04-27 13:41:38Z apetrelli $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.dispatcher.ng.filter;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.ng.ExecuteOperations;
import org.apache.struts2.dispatcher.ng.InitOperations;
import org.apache.struts2.dispatcher.ng.PrepareOperations;

import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.security.SessionTimeOutFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Handles both the preparation and execution phases of the Struts dispatching process.  This filter is better to use
 * when you don't have another filter that needs access to action context information, such as Sitemesh.
 */
public class StrutsPrepareAndExecuteFilter implements StrutsStatics, Filter {
    protected PrepareOperations __prepare;
    protected ExecuteOperations __execute;
	protected List<Pattern> __excludedPatterns = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        initImpl(filterConfig);

    }

	private void initImpl(FilterConfig filterConfig) {
		InitOperations init = new InitOperations();
        try {
            FilterHostConfig config = new FilterHostConfig(filterConfig);
            init.initLogging(config);
            Dispatcher dispatcher = init.initDispatcher(config);
            init.initStaticContentLoader(config, dispatcher);

            __prepare = new PrepareOperations(filterConfig.getServletContext(), dispatcher);
            __execute = new ExecuteOperations(filterConfig.getServletContext(), dispatcher);
			this.__excludedPatterns = init.buildExcludedPatternsList(dispatcher);

            postInit(dispatcher, filterConfig);
        } finally {
            init.cleanup();
        }
	}

    /**
     * Callback for post initialization
     */
    protected void postInit(Dispatcher dispatcher, FilterConfig filterConfig) {
    	
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        doFilterImpl(req, res, chain);
    }

	private void doFilterImpl(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        try {
        	
        	String requestQueryString = request.getQueryString();
        	
        	//http://struts.apache.org/release/2.3.x/docs/s2-016.html
        	//http://struts.apache.org/release/2.3.x/docs/s2-017.html
        	if (requestQueryString!=null ){
		        	if(requestQueryString.toLowerCase().startsWith("redirect:")
		        			|| requestQueryString.toLowerCase().startsWith("action:")
		        			|| requestQueryString.toLowerCase().startsWith("redirectaction:")
		        			) {
		        		 response.setStatus(response.SC_BAD_REQUEST);
		        		 __prepare.cleanupRequest(request);
		        		return;
					}
        	}
            __prepare.setEncodingAndLocale(request, response);
            __prepare.createActionContext(request, response);
            __prepare.assignDispatcherToThread();
			if ( __excludedPatterns != null && __prepare.isUrlExcluded(request, __excludedPatterns)) {
				chain.doFilter(request, response);
			} else {
				request = __prepare.wrapRequest(request);
				ActionMapping mapping = __prepare.findActionMapping(request, response, true);
				if (mapping == null) {
					boolean handled = __execute.executeStaticResourceRequest(request, response);
					if (!handled) {
						chain.doFilter(request, response);
					}
				} else {
					//Do Security Check 
					if ( request.getSession() == null || request.getSession().getAttribute(com.jdframe.sys.core.model.Tokens._USER_PROFILE)==null){
						if(!request.getRequestURI().equalsIgnoreCase("/loginAction")){
				        	 response.sendRedirect("/");
				        	 return;
						}
					}
					__execute.executeAction(request, response, mapping);
				
			 }
			}
        } finally {
            __prepare.cleanupRequest(request);
        }
	}

    public void destroy() {
        __prepare.cleanupDispatcher();
    }
}
