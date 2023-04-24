package com.workershigh.web.controller.consultation;

import com.workershigh.web.controller.base.BaseController;
import com.workershigh.web.domain.consultation.Consultation;
import com.workershigh.web.exception.ResourceNotFoundException;
import com.workershigh.web.repository.ConsultationRepository;
import com.workershigh.web.response.PageResultOf;
import com.workershigh.web.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ConsultationController extends BaseController {
    private final ConsultationRepository consultationRepository;
    @GetMapping("/consulation")
    public ResponseResult<PageResultOf<Consultation>> getListConsulationWithPagenation(){

        PageResultOf<Consultation> result = PageResultOf.of(Collections.emptyList(), 0, 10, 0,0);
        Pageable pageable = PageRequest.of(0, 10);

        var resultList = consultationRepository.findAll(pageable);

        if(resultList.getTotalElements() > 0) {
            result.setItems(resultList.getContent());
            result.setTotalPage(resultList.getTotalPages());
            result.setTotalRow(resultList.getTotalElements());
        }

        return successResult(result);
    }

    @GetMapping("/consulation/{id}")
    public ResponseResult<Consultation> getConsulationById(@PathVariable Long id){
        Consultation resConsulation = consultationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return successResult(resConsulation);
    }

    @PostMapping("/consulation")
    public ResponseResult createConsulation(@RequestBody Consultation consultation){
        consultationRepository.save(consultation);
        return successResult();
    }

    @PutMapping("/consulation")
    public ResponseResult updateConsulationById(@RequestBody Consultation consultation){
        Consultation findConsulation = consultationRepository.findById(consultation.getId()).orElseThrow(ResourceNotFoundException::new);
        consultationRepository.save(consultation);
        return successResult();
    }

    @DeleteMapping("/consulation/{id}")
    public ResponseResult deleteConsulation(@PathVariable Long id){
        Consultation findConsulation = consultationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        consultationRepository.deleteById(id);
        return successResult();
    }
}
