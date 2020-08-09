package com.adward.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author Adward_Z
 * @date 2020/8/9
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.clear();
        // 将Json对象转换成Java对象
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
