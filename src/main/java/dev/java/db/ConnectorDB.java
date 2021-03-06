package dev.java.db;

import dev.java.db.DAOs.CandidateDAO;
import dev.java.db.DAOs.CandidateSkillDAO;
import dev.java.db.DAOs.SkillDAO;
import dev.java.db.model.Candidate;
import dev.java.db.model.CandidateSkill;
import dev.java.db.model.Skill;
import dev.java.db.model.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        /*CandidateDAO candidateDAO = new CandidateDAO(connection, Table.CANDIDATE);
        Candidate candidate = new Candidate();
        candidate.setEmail("k.pilyak96@tut.by");
        candidate.setPhoto("C://image.jpg");
        candidate.setName("Kseniya");
        candidate.setSurname("Piliak");
        candidate.setSalaryInDollars(200);
        candidate.setExperienceInYears(1.5f);
        candidate.setPhone("+375444859574");
        candidate.setStatus(Candidate.Status.UNDER_CONSIDERATION);
        candidate = candidateDAO.create(candidate);
        candidate.setEmail("k.pilyak96@gmail.com");
        candidateDAO.update(candidate);
        System.out.println(candidateDAO.delete(10));*/
        CandidateSkillDAO candidateSkillDAO = new CandidateSkillDAO(connection, Table.CANDIDATE_SKILL);
        candidateSkillDAO.delete(1);

    }
}
