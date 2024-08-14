package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarpoolDao {

    private final JdbcTemplate template;

    @Autowired
    public CarpoolDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public String saveCarpool(CarpoolObj obj) {
        String sql = "insert into carpool (title, cnt, reg_seq, reg_dt) values (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int cnt = template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, obj.getTitle());
            ps.setString(2, obj.getCnt());
            ps.setInt(3, 1);
            ps.setString(4, String.valueOf(LocalDateTime.now()));
            return ps;
        }, keyHolder);

        if(cnt > 0){
            return "ok";
        }else{
            return "no";
        }
    }

    public List<CarpoolObj> getList(){
        String sql = "select * from carpool order by _id desc";

        return template.query(sql, carpoolRowMapper());
    }

    private RowMapper<CarpoolObj> carpoolRowMapper() {
        return ((rs, rowNum) -> {
            CarpoolObj obj = new CarpoolObj();
            obj.setId(rs.getInt("_id"));
            obj.setTitle(rs.getString("title"));
            obj.setCnt(rs.getString("cnt"));
            obj.setReg_seq(rs.getInt("reg_seq"));
            obj.setReg_dt(rs.getString("reg_dt"));
            return obj;
        });
    }

    public CarpoolObj getDetail(Long id) {
        String sql = "select * from carpool where _id = ?";

        CarpoolObj carpoolObj = template.queryForObject(sql, carpoolRowMapper(), id);
        return carpoolObj;
    }

}