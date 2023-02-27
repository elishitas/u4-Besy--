package com.besysfot.bootcampspringboot.config;

import com.besysfot.bootcampspringboot.servicios.implementacion.PersonaServiceImpl;
import com.besysfot.bootcampspringboot.servicios.interfaces.PersonaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAppConfig {

    /*@Bean("nombreBean")
    public PersonaService getComponentPersonaService(){
        return new PersonaServiceImpl();
    }*/

}
