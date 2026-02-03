package com.example.First.project.service;

import com.example.First.project.entity.JournalEntry;
import com.example.First.project.entity.Users;
import com.example.First.project.repository.JournalEntryRepository;
import com.example.First.project.repository.UserRepository;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository jouranlEntryRepository;
    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry,String userName){
        Users user = userService.findByUsername(userName);
        JournalEntry saved = jouranlEntryRepository.save(journalEntry);
        user.getJournalEntryList().add(saved);
        userService.saveEntry(user);
    }
    public void saveEntry(JournalEntry journalEntry){
        jouranlEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return jouranlEntryRepository.findAll();
    }

    public Optional<JournalEntry> getDataById(String id){
        try {
            if(!StringUtils.hasText(id)) return Optional.empty();
            ObjectId objectId = new ObjectId(id);
            return jouranlEntryRepository.findById(objectId);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public boolean deleteById(String id,String username) {
        try {
            if(!StringUtils.hasText(id)) return false;
            ObjectId objectId = new ObjectId(id);

            if(jouranlEntryRepository.existsById(objectId)){
                Users user = userService.findByUsername(username);
                user.getJournalEntryList().removeIf(x -> x.getId().toHexString().equals(objectId.toHexString()));
                userService.saveEntry(user);
                jouranlEntryRepository.deleteById(objectId);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
