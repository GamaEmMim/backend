package br.com.ruavarejo.backend.configuration;

import static java.util.Arrays.asList;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

import br.com.ruavarejo.backend.annotation.WebComponent;
import br.com.ruavarejo.backend.annotation.WebConfiguration;
import br.com.ruavarejo.backend.interceptor.Interceptor;

@WebConfiguration
@WebComponent
class WebConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Interceptor interceptor;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		final JsonStringHttpMessageConverter stringConverter = new JsonStringHttpMessageConverter();
		
		final ObjectMapper objectMapper = new ObjectMapper();
		final Hibernate4Module module = new Hibernate4Module();
		
		module.enable(Feature.FORCE_LAZY_LOADING);
		objectMapper.registerModule(module);
		converter.setObjectMapper(objectMapper);
		stringConverter.setSupportedMediaTypes(asList(APPLICATION_JSON));
		converters.add(stringConverter);
		converters.add(converter);
		super.configureMessageConverters(converters);
	}
}
