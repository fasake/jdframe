/*
 * Copyright 2002-2007,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensymphony.xwork2;

import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * The Interface Action.
 *
 * @copyright www.jdframe.com
 * @Package com.opensymphony.xwork2
 * @Description: TODO
 * @author: support@jdframe.com
 * @date: 2013-09-15 15:26:29
 * @version v1.0
 */
public interface Action {

    /** The Constant SUCCESS. */
    public static final String SUCCESS = "success";

    /** The Constant NONE. */
    public static final String NONE = "none";

    /** The Constant ERROR. */
    public static final String ERROR = "error";

    /** The Constant INPUT. */
    public static final String INPUT = "input";

    /** The Constant LOGIN. */
    public static final String LOGIN = "login";
    
    public static final String COPYRIGHT = "www.jdframe.com";
    
    public static final String EMAIL = "support@jdframe.com";
    
    
    // ·µ»Ø³õÊ¼»¯×Ö·û´®
 	/** The Constant SUCCESS_INITIAL. */
    public static final String INITIAL = "init";

 
   
    /**
     * Execute.
     *
     * @return the string
     * @throws Exception the exception
     */
    public String execute() throws Exception;
    
    /**
     * Access privilege.
     */
    public void accessPrivilege();

}
