package kdo6301.DeliverySystem.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kdo6301.DeliverySystem.filter.LoginFilter;
import kdo6301.DeliverySystem.repository.item.ItemQueryRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @PersistenceContext
    private EntityManager em;

    @Bean
    public FilterRegistrationBean logFilter()
    {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LoginFilter());
        filterFilterRegistrationBean.setOrder(1);
        filterFilterRegistrationBean.addUrlPatterns("/*");
        return filterFilterRegistrationBean;
    }

    @Bean
    public EntityManager entityManager()
    {
        return em;
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em)
    {
        return new JPAQueryFactory(em);
    }


}
