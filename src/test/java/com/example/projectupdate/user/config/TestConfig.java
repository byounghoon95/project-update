package com.example.projectupdate.user.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/** @DataJpaTest
 * 위 테스트 진행 시 별도의 스프링 빈을 등록하지 않고
 * Entity와 EntityManager만 등록을 해 테스트를 진행하므로
 * querydsl 사용시 필요한 JPAQueryFactory를 사용할 수 없게됨
 * @TestConfiguration을 통해 테스트 환경에서만 필요한 빈을 추가 등록시켜 문제 해결
 * */
@TestConfiguration
public class TestConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
