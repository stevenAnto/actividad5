package com.example.demo.servidor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;


import java.rmi.RemoteException;

@Configuration//Configuracion de Spring
public class AppConfig {

    @Bean
    public RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("CalculatorService");
        exporter.setServiceInterface(CalculatorService.class);
        try {
            exporter.setService(new CalculatorServiceImpl());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return exporter;
    }

}
