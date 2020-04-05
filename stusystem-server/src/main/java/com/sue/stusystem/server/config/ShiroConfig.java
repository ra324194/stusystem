package com.sue.stusystem.server.config;
import io.buji.pac4j.filter.SecurityFilter;
import io.buji.pac4j.filter.CallbackFilter;
import io.buji.pac4j.filter.LogoutFilter;

import io.buji.pac4j.subject.Pac4jSubjectFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.cas.config.CasProtocol;
import org.pac4j.core.config.Config;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.security.auth.callback.Callback;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {




    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("subjectFactory") Pac4jSubjectFactory pac4jSubjectFactory,@Qualifier("sessionManager") SessionManager sessionManager,@Qualifier("casRealm")CASRealm casRealm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager);
        securityManager.setSubjectFactory(pac4jSubjectFactory);
        securityManager.setRealm(casRealm);
        return  securityManager;
    }
    @Bean
    public CASRealm casRealm() {

        return new CASRealm();
    }
    @Bean(name = "subjectFactory")
    public Pac4jSubjectFactory pac4jSubjectFactory() {
        return new Pac4jSubjectFactory();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        return filterRegistration;
    }

//    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
//        Map<String, String> shiroFilterMap = new LinkedHashMap<>();
//        shiroFilterMap.put("/", "securityFilter");
//        shiroFilterMap.put("/application/**", "securityFilter");
//        shiroFilterMap.put("/index", "securityFilter");
//        shiroFilterMap.put("/callback", "callbackFilter");
//        shiroFilterMap.put("/logout", "logoutFilter");
//        //shiroFilterMap.put("/**", "anon");
//        shiroFilterMap.put("/hello","securityFilter");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterMap);
//    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager,@Qualifier("config") Config config) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        Map<String,Filter> filters = new HashMap<>(3);
        SecurityFilter securityFilter = new SecurityFilter();
        securityFilter.setConfig(config);
        filters.put("securityFilter",securityFilter);
        CallbackFilter callbackFilter = new CallbackFilter();
        callbackFilter.setConfig(config);
        filters.put("callbackFilter",callbackFilter);
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setConfig(config);
        logoutFilter.setCentralLogout(true);
        logoutFilter.setLocalLogout(true);
        logoutFilter.setDefaultUrl("localhost:9001" + "/callback?client_name=" + "client1");
        filters.put("logoutFilter",logoutFilter);
        bean.setFilters(filters);
        Map<String, String> shiroFilterMap = new LinkedHashMap<>();
        shiroFilterMap.put("/hello","securityFilter");
        shiroFilterMap.put("/logout","logoutFilter");
        shiroFilterMap.put("/login","securityFilter");
        shiroFilterMap.put("/callback", "callbackFilter");
        bean.setFilterChainDefinitionMap(shiroFilterMap);
        return bean;

    }





    @Bean
    public SessionDAO sessionDAO() {
        return new MemorySessionDAO();
    }

//    @Bean(name = "cookie")
//    public SimpleCookie sessionIdCookie() {
//        SimpleCookie cookie = new SimpleCookie("sid");
//        cookie.setMaxAge(-1);
//        cookie.setPath("/");
//        cookie.setHttpOnly(false);
//        return cookie;
//    }

    @Bean(name = "sessionManager")
    public DefaultSessionManager getDefaultSessionManager(SessionDAO sessionDAO) {

        DefaultSessionManager sessionManager = new DefaultSessionManager();

        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setGlobalSessionTimeout(180000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }


    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager")DefaultSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }









    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setName("singleSignOutFilter");
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        bean.setFilter(singleSignOutFilter);
        bean.addUrlPatterns("/*");
        bean.setEnabled(true);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        singleSignOutFilter.setCasServerUrlPrefix(casServerUrl);

        return bean;
    }

    @Bean("config")
    public Config config(CasClient casClient) {
        Config config = new Config(casClient);

        return config;
    }


    @Bean
    public CasClient casClient(CasConfiguration casConfig){
        CasClient casClient = new CasClient(casConfig);
        //客户端回调地址
        casClient.setCallbackUrl("localhost:9001" + "/callback?client_name=" + "client1");
        casClient.setName("client1");
        return casClient;
    }
    @Bean
    public CasConfiguration casConfig(){
        final CasConfiguration configuration = new CasConfiguration("localhost:8080/cas/login");
        //CAS server登录地址
        //configuration.setLoginUrl("localhost:8080/cas/login");
        //CAS 版本，默认为 CAS30，我们使用的是 CAS20
        configuration.setProtocol(CasProtocol.CAS20);
        configuration.setAcceptAnyProxy(true);
        configuration.setPrefixUrl("localhost:8080/cas" + "/");
        return configuration;
    }


}
