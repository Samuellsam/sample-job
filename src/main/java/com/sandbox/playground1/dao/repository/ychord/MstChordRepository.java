package com.sandbox.playground1.dao.repository.ychord;

import com.sandbox.playground1.config.AppConfig;
import com.sandbox.playground1.dao.entity.ychord.MstChord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class MstChordRepository {

    JdbcTemplate yChordJdbcTemplate;

    AppConfig appConfig;

    public MstChordRepository(
            @Qualifier("ychord-jdbc-template") JdbcTemplate yChordJdbcTemplate,
            AppConfig appConfig
    ) {
        this.yChordJdbcTemplate = yChordJdbcTemplate;
        this.appConfig = appConfig;
    }

    //    @Transactional(transactionManager = "ychord-trx-manager")
    public void saveAll(List<MstChord> mstChords) {
        yChordJdbcTemplate.batchUpdate("INSERT INTO MST_CHORDS (CHORD_ID, NAME) " +
                        "VALUES (?, ?)",
                mstChords,
                appConfig.getBatchSize(),
                (PreparedStatement ps, MstChord mstChord) -> {
                    ps.setString(1, mstChord.getChordId());
                    ps.setString(2, mstChord.getName());
                }
        );
    }

    ;
}
