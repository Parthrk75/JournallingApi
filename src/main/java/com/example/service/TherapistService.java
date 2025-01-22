package com.example.service;

import com.example.entity.Therapist;
import com.example.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TherapistService {

    @Autowired
    private TherapistRepository therapistRepository;

    public List<Therapist> getAllTherapists() {
        return therapistRepository.findAll();
    }

    public Optional<Therapist> getTherapistById(Long id) {
        return therapistRepository.findById(id);
    }

    public Therapist saveTherapist(Therapist therapist) {
        return therapistRepository.save(therapist);
    }

    public void deleteTherapist(Long id) {
        therapistRepository.deleteById(id);
    }
}
