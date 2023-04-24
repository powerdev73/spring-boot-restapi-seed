package com.powerdev.web.repository;

import com.powerdev.web.domain.consultation.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    Page<Consultation> findAll(Pageable pageable);

//    @Query(value = """
//            SELECT id, space, company, phone, email, createAt
//            FROM tb_consultation
//            WHERE (:company IS NULL OR company LIKE %:company%)
//            AND (:phone IS NULL OR phone LIKE %:phone%)
//            AND (:email IS NULL OR email LIKE %:email%)
//            ORDER BY id DESC
//            """, countQuery = """
//            SELECT count(id)
//            FROM tb_consultation
//            WHERE (:company IS NULL OR company LIKE %:company%)
//            AND (:phone IS NULL OR phone LIKE %:phone%)
//            AND (:email IS NULL OR email LIKE %:email%)
//            """,nativeQuery = true)
//    Page<Consultation> findListConsultationWithPagination(Pageable pageable,
//                                                          @Param("company") String company,
//                                                          @Param("phone") String phone,
//                                                          @Param("email") String email);
}
