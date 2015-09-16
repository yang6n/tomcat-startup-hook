/**
 * Copyright (c) 2015 Jian. All rights reserved.
 */
package com.estudio.tomcat.startup;

import java.io.File;

import javax.naming.Context;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.deploy.NamingResources;
import org.apache.catalina.startup.Catalina;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 * 
 * @author Jian
 * 
 *         Created: Sep 12, 2015
 */
public final class ServerWraper implements Server {
    
    private final Log log = LogFactory.getLog(ServerWraper.class);
    
    private Server mServer;
    
    /**
     * @param server
     */
    public ServerWraper(Server server) {
    
        super();
        this.mServer = server;
    }
    
    public Server getServer() {
    
        return this.mServer;
    }
    
    public void setServer(Server server) {
    
        if (server != null) this.mServer = server;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#addLifecycleListener(org.apache.catalina.LifecycleListener)
     */
    public void addLifecycleListener(LifecycleListener listener) {
    
        mServer.addLifecycleListener(listener);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#findLifecycleListeners()
     */
    public LifecycleListener[] findLifecycleListeners() {
    
        return mServer.findLifecycleListeners();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#removeLifecycleListener(org.apache.catalina.LifecycleListener)
     */
    public void removeLifecycleListener(LifecycleListener listener) {
    
        mServer.removeLifecycleListener(listener);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#init()
     */
    public void init() throws LifecycleException {
    
        mServer.init();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#start()
     */
    public void start() throws LifecycleException {
    
        log.info("Starting");
        mServer.start();
        log.info("After starting");
        
        final String startupHookScript = System.getProperty("StartupHook");
        if (startupHookScript == null) return;
        
        executeStartupHookScript(startupHookScript);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#stop()
     */
    public void stop() throws LifecycleException {
    
        mServer.stop();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#destroy()
     */
    public void destroy() throws LifecycleException {
    
        mServer.destroy();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#getState()
     */
    public LifecycleState getState() {
    
        return mServer.getState();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Lifecycle#getStateName()
     */
    public String getStateName() {
    
        return mServer.getStateName();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getInfo()
     */
    public String getInfo() {
    
        return mServer.getInfo();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getGlobalNamingResources()
     */
    public NamingResources getGlobalNamingResources() {
    
        return mServer.getGlobalNamingResources();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#setGlobalNamingResources(org.apache.catalina.deploy.NamingResources)
     */
    public void setGlobalNamingResources(NamingResources globalNamingResources) {
    
        mServer.setGlobalNamingResources(globalNamingResources);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getGlobalNamingContext()
     */
    public Context getGlobalNamingContext() {
    
        return mServer.getGlobalNamingContext();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getPort()
     */
    public int getPort() {
    
        return mServer.getPort();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#setPort(int)
     */
    public void setPort(int port) {
    
        mServer.setPort(port);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getAddress()
     */
    public String getAddress() {
    
        return mServer.getAddress();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#setAddress(java.lang.String)
     */
    public void setAddress(String address) {
    
        mServer.setAddress(address);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getShutdown()
     */
    public String getShutdown() {
    
        return mServer.getShutdown();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#setShutdown(java.lang.String)
     */
    public void setShutdown(String shutdown) {
    
        mServer.setShutdown(shutdown);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getParentClassLoader()
     */
    public ClassLoader getParentClassLoader() {
    
        return mServer.getParentClassLoader();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#setParentClassLoader(java.lang.ClassLoader)
     */
    public void setParentClassLoader(ClassLoader parent) {
    
        mServer.setParentClassLoader(parent);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#getCatalina()
     */
    public Catalina getCatalina() {
    
        return mServer.getCatalina();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#setCatalina(org.apache.catalina.startup.Catalina)
     */
    public void setCatalina(Catalina catalina) {
    
        mServer.setCatalina(catalina);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#addService(org.apache.catalina.Service)
     */
    public void addService(Service service) {
    
        mServer.addService(service);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#await()
     */
    public void await() {
    
        mServer.await();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#findService(java.lang.String)
     */
    public Service findService(String name) {
    
        return mServer.findService(name);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#findServices()
     */
    public Service[] findServices() {
    
        return mServer.findServices();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.catalina.Server#removeService(org.apache.catalina.Service)
     */
    public void removeService(Service service) {
    
        mServer.removeService(service);
    }
    
    private void executeStartupHookScript(final String startupHookScript) {
    
        if (!new File(startupHookScript).exists()) {
            log.warn("script file not exist: " + startupHookScript);
            return;
        }
        
        try {
            log.info("Calling Startup Hook: " + startupHookScript);
            Runtime.getRuntime().exec(startupHookScript);
        } catch (Exception ex) {
            log.error("Exception occurs when executing: " + startupHookScript, ex);
        }
    }
}
