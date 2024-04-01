package com.shop.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.shop.repository.MemberRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application.properties")
public class MemberTest {
 
    @Autowired
    MemberRepository memberRepository;
    
    @PersistenceContext
    EntityManager em;
    
    @Test
    @DisplayName("Auditing 테스트")
    @WithMockUser( username = "gildong", roles="user") 
    //스프링 시큐리티에서 제공하는 @WithMockUser는 사용자가 로그인한 상태라고 가정하고 테스트를 진행할 수 있다.
    public void auditingTest() {
    	Member newMember = new Member();
    	memberRepository.save(newMember);
    	
    	em.flush();
    	em.clear();
    	
    	Member member = memberRepository.findById( newMember.getId() )
    	                     .orElseThrow( EntityNotFoundException::new);  
    	
    	System.out.println("~~~~ register Time : " + newMember.getRegTime() );
    	System.out.println("~~~~ update Time : " + newMember.getUpdateTime() );
    	System.out.println("~~~~ create Member : " + newMember.getCreatedBy() );
    	System.out.println("~~~~ modify Member : " + newMember.getModifyedBy() );

    }
     
}
