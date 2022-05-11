package com.example.lifewaycodeassessment.service;

import com.example.lifewaycodeassessment.model.Count;
import com.example.lifewaycodeassessment.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountService {

    @Autowired
    CountRepository countRepository;

    public List<Count> getAllCount() {
        List<Count> countList = new ArrayList<Count>();
        countRepository.findAll().forEach(count -> countList.add(count));
        return countList;
    }

    public List<Count> deleteAllButLast() {
        List<Count> countList = new ArrayList<>();
        countRepository.findAll().forEach(count -> countList.remove(count));
        return countList;
    }
    public void saveOrUpdate (Count count) {
        countRepository.save(count);
    }
}
