package com.finance.service;


	import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finance.entity.FinancialRecord;
import com.finance.repository.FinancialRecordRepository;

	@Service
	public class FinancialRecordService {

	    private final FinancialRecordRepository repo;

	    public FinancialRecordService(FinancialRecordRepository repo) {
	        this.repo = repo;
	    }

	    public FinancialRecord create(FinancialRecord record) {
	        if (record.getAmount() <= 0)
	            throw new RuntimeException("Amount must be positive");

	        return repo.save(record);
	    }

	    public Page<FinancialRecord> getAll(Pageable pageable) {
	        return repo.findAll(pageable);
	    }

	    public FinancialRecord update(Long id, FinancialRecord r) {
	        FinancialRecord existing = getById(id);

	        existing.setAmount(r.getAmount());
	        existing.setType(r.getType());
	        existing.setCategory(r.getCategory());
	        existing.setDate(r.getDate());
	        existing.setNotes(r.getNotes());

	        return repo.save(existing);
	    }

	    public void delete(Long id) {
	        if (!repo.existsById(id)) {
	            throw new RuntimeException("Cannot delete. Record not found with id: " + id);
	        }
	        repo.deleteById(id);
	    }

	    public List<FinancialRecord> filter(String type, String category) {
	        if (type != null) return repo.findByType(type);
	        if (category != null) return repo.findByCategory(category);
	        return repo.findAll();
	    }
	    
	    public Page<FinancialRecord> getAll(int page, int size) {
	        return repo.findAll(PageRequest.of(page, size));
	    }
	    public FinancialRecord getById(Long id) {
	        return repo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Record not found"));
	    }
	    
	}

