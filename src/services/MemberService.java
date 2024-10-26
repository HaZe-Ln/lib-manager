package services;

import conf.Database;
import interfaces.IService;
import models.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MemberService implements IService<Member> {
    private MemberService() {}

    @Override
    public ArrayList<Member> findAll() throws SQLException {
        ArrayList<Member> members = new ArrayList<>();
        PreparedStatement stmt = Database.getConnection().prepareStatement("select * from books");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Member member = new Member(
                    rs.getLong("member_id"),
                    rs.getString("name"),
                    rs.getInt("phone"),
                    rs.getString("address")
            );
            members.add(member);
        }
        return members;
    }

    @Override
    public boolean save(Member member) throws SQLException {
        PreparedStatement stmt = Database.getConnection().prepareStatement(
                "INSERT INTO members(name, phone, address) VALUES (?, ?, ?)");
        stmt.setString(1, member.getName());
        stmt.setInt(2, member.getPhone());
        stmt.setString(3, member.getAddress());
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public boolean remove(long id) throws SQLException {
        PreparedStatement stmt = Database.getConnection().prepareStatement("DELETE FROM members WHERE id = ?");
        stmt.setLong(1, id);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public boolean update(Member member) throws SQLException {
        PreparedStatement stmt = Database.getConnection().prepareStatement(
                "UPDATE students SET name = ?, address = ?, phone = ? WHERE id = ?");
        stmt.setString(1, member.getName());
        stmt.setString(2, member.getAddress());
        stmt.setInt(3, member.getPhone());
        stmt.setLong(4, member.getid());
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public Member findById(long id) throws SQLException {
        Member member = null;
        PreparedStatement stmt = Database.getConnection().prepareStatement("select * from members where id = ?");
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            member = new Member(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("phone"),
                    rs.getString("address")
            );
        }
        return member;
    }
}