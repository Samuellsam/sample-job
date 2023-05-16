package com.sandbox.playground1.service.ychord;

import com.sandbox.playground1.dao.entity.ychord.MstChord;
import com.sandbox.playground1.dao.repository.ychord.MstChordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MstChordService {

    MstChordRepository mstChordRepository;

    public MstChordService(MstChordRepository mstChordRepository) {
        this.mstChordRepository = mstChordRepository;
    }

    public void saveAll(List<MstChord> mstChords) {
        mstChordRepository.saveAll(mstChords);
    }
}
