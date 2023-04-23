package com.workershigh.web.controller.consultation;

import com.workershigh.web.controller.base.BaseController;
import com.workershigh.web.domain.consultation.Consultation;
import com.workershigh.web.repository.ConsultationRepository;
import com.workershigh.web.response.PageResultOf;
import com.workershigh.web.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ConsultationController extends BaseController {
    private final ConsultationRepository consultationRepository;
    @GetMapping("/consulation")
    public ResponseResult<PageResultOf<Consultation>> consulationList(){

        PageResultOf<Consultation> result = PageResultOf.of(Collections.emptyList(), 0, 2, 0,0);
        Pageable pageable = PageRequest.of(0, 2);

        var resultList = consultationRepository.findAll(pageable);

        if(resultList.getTotalElements() > 0) {
            result.setItems(resultList.getContent());
            result.setTotalPage(resultList.getTotalPages());
            result.setTotalRow(resultList.getTotalElements());
        }

        return successResult(result);
    }
}
