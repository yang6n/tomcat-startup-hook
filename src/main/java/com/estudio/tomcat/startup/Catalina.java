/**
 * Copyright (c) 2015 Jian. All rights reserved.
 */
package com.estudio.tomcat.startup;

import org.apache.catalina.Server;

/**
 * 
 * @author Jian
 * 
 *         Created: Sep 5, 2015
 */
public final class Catalina extends org.apache.catalina.startup.Catalina {
    
    private ServerWraper serverWraper;
    
    /**
     * 
     */
    public Catalina() {
    
        super();
        serverWraper = new ServerWraper(server);
    }
    
    @Override
    public Server getServer() {
    
        return serverWraper;
    }
    
    @Override
    public void setServer(Server server) {
    
        if (server != null) serverWraper.setServer(server);
    }
    
}
