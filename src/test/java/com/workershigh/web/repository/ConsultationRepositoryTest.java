package com.workershigh.web.repository;

import com.workershigh.web.domain.consultation.Consultation;
import com.workershigh.web.domain.consultation.enums.SpaceType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ConsultationRepositoryTest {
    @Autowired
    ConsultationRepository consultationRepository;

    @Test
    @DisplayName("무료상담 신청 등록 테스트")
    void createConsultation(){
        Consultation consultation = new Consultation();
        consultation.setSpace(SpaceType.SPORT);
        consultation.setCompany("워커스하이");
        consultation.setPhone("010-1234-9876");
        consultation.setEmail("workershigh@gmail.com");
        consultation.setCreateAt(LocalDateTime.now());

        Consultation saveResult = consultationRepository.save(consultation);
        Optional<Consultation> findResult = consultationRepository.findById(saveResult.getId());
        System.out.println(findResult.get().getSpace().label());
        assertThat(saveResult.getCompany()).isEqualTo(findResult.get().getCompany());
    }

    @Test
    void getList(){
       initialData();

       Pageable pageable = PageRequest.of(0,2);
       Page<Consultation> consultListPage = consultationRepository.findAll(pageable);
       consultListPage.forEach(System.out::println);
    }

    void initialData(){
        Consultation consultation1 = new Consultation();
        consultation1.setSpace(SpaceType.HOTEL);
        consultation1.setCompany("워커스하이");
        consultation1.setPhone("010-1234-9876");
        consultation1.setEmail("workershigh@gmail.com");
        consultation1.setCreateAt(LocalDateTime.now());
        consultationRepository.save(consultation1);

        Consultation consultation2 = new Consultation();
        consultation2.setSpace(SpaceType.OFFICE);
        consultation2.setCompany("쿠팡");
        consultation2.setPhone("010-3434-3232");
        consultation2.setEmail("cupang@cupang.com");
        consultation2.setCreateAt(LocalDateTime.now());
        consultationRepository.save(consultation2);
    }
}