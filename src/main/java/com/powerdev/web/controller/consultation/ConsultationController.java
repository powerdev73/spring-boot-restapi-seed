package com.powerdev.web.controller.consultation;

import com.powerdev.web.controller.base.BaseController;
import com.powerdev.web.domain.consultation.Consultation;
import com.powerdev.web.exception.ResourceNotFoundException;
import com.powerdev.web.repository.ConsultationRepository;
import com.powerdev.web.response.PageResultOf;
import com.powerdev.web.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class ConsultationController extends BaseController {
    private final ConsultationRepository consultationRepository;
    @GetMapping("/consulation/{page}")
    public ResponseResult<PageResultOf<Consultation>> getListConsulationWithPagenation(@PathVariable Integer page){

        PageResultOf<Consultation> result = PageResultOf.of(Collections.emptyList(), page, 10, 0,0);
        Pageable pageable = PageRequest.of(page, 10);

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
        Consultation resConsulation = consultationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulation", "id", id));
        return successResult(resConsulation);
    }

    @PostMapping("/consulation")
    public ResponseResult createConsulation(@RequestBody Consultation consultation){
        consultationRepository.save(consultation);
        return successResult();
    }

    @PutMapping("/consulation")
    public ResponseResult updateConsulationById(@RequestBody Consultation consultation){
        Consultation findConsulation = consultationRepository.findById(consultation.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Consulation", "id", consultation.getId()));
        consultationRepository.save(consultation);
        return successResult();
    }

    @DeleteMapping("/consulation/{id}")
    public ResponseResult deleteConsulation(@PathVariable Long id){
        Consultation findConsulation = consultationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulation", "id", id));
        consultationRepository.deleteById(id);
        return successResult();
    }
}
