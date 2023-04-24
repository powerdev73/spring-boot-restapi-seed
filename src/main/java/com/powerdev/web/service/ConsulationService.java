package com.powerdev.web.service;

import com.powerdev.web.domain.consultation.Consultation;
import com.powerdev.web.exception.ResourceNotFoundException;
import com.powerdev.web.repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsulationService {
    private final ConsultationRepository consultationRepository;

    public Consultation createConsultation(Consultation consultation){
        return consultationRepository.save(consultation);
    }

    public Consultation getConsulation(Long id){
        Optional<Consultation> resConsulation = consultationRepository.findById(id);
        if(resConsulation.isPresent()){
            return resConsulation.get();
        } else {
            return null;
        }
    }

    public Consultation createConsulation(Consultation consultation){
        return consultationRepository.save(consultation);
    }

    public Consultation updateConsulation(Consultation consultation){
        Consultation updateConsulation = consultationRepository.findById(consultation.getId())
                .orElseThrow(ResourceNotFoundException::new);

        return consultationRepository.save(consultation);
    }

    public void deleteConsulation(Long id){
        Consultation deleteConsulation = consultationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        consultationRepository.deleteById(id);
    }
}
