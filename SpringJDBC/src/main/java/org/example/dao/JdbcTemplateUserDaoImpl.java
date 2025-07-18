package org.example.dao;

import org.example.dao.interfaces.UserDAO;
import org.example.entity.Project;
import org.example.entity.User;
import org.example.enumiration.RoleType;
import org.example.enumiration.TaskProjectStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Set;

@Repository
public class JdbcTemplateUserDaoImpl implements UserDAO {
    private static Logger logger = LoggerFactory.getLogger(JdbcTemplateUserDaoImpl.class);
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Set<User> findAll() {
        return Collections.EMPTY_SET;
    }


    public User findByIdOld(int id) {
        return jdbcTemplate.queryForObject("select * from users where id = ?", new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public User findById(int id) {
//        return jdbcTemplate.queryForObject("select * from users where id = ?", new UserRowMapper(), id);

        return jdbcTemplate.query("select *, P.ID as P_ID  from users u " +
                "         left join PROJECT P on u.ID = P.USER_ID" +
                "         where u.id =  ?", new UserRowMapper(), id).get(0);
    }

    static class UserRowMapper implements RowMapper<User> {
        User user = null;

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            if (user == null) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setHashPass(rs.getString("hash_pass"));
                user.setRole(RoleType.valueOf(rs.getString("ROLE_TYPE")));
            }

            Project project = new Project();
            project.setId(rs.getString("P_ID"));
            project.setName(rs.getString("name"));
            project.setDescription(rs.getString("description"));
            project.setStatus(TaskProjectStatus.valueOf((rs.getString("status") == null ? "Planned" : rs.getString("status"))));
            project.setStartDate(rs.getDate("START_DATE"));
            project.setEndDate(rs.getDate("END_DATE"));
            user.getProjects().add(project);

            return user;
        }
    }
}
