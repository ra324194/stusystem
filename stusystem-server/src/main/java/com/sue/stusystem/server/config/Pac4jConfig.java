package com.sue.stusystem.server.config;


import io.buji.pac4j.context.ShiroSessionStore;
import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.cas.config.CasProtocol;
import org.pac4j.core.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Pac4jConfig {


//    @Bean("config")
//    public Config config(CasClient casClient) {
//         Config config = new Config();
//
//         return config;
//    }
//
//
//    @Bean
//    public CasClient casClient(CasConfiguration casConfig){
//        CasClient casClient = new CasClient(casConfig);
//        //客户端回调地址
//        casClient.setCallbackUrl("localhost:9001" + "/callback?client_name=" + "client1");
//        casClient.setName("client1");
//        return casClient;
//    }
//    @Bean
//    public CasConfiguration casConfig(){
//        final CasConfiguration configuration = new CasConfiguration();
//        //CAS server登录地址
//        configuration.setLoginUrl("localhost:8080/cas" + "/login");
//        //CAS 版本，默认为 CAS30，我们使用的是 CAS20
//        configuration.setProtocol(CasProtocol.CAS10);
//        configuration.setAcceptAnyProxy(true);
//        configuration.setPrefixUrl("localhost:8080/cas" + "/");
//        return configuration;
//    }

}