package controllers;

import errors.BusinessLogicException;
import interfaces.IController;
import models.Member;
import services.MemberService;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberController implements IController<Member> {
    private final ArrayList<Member> members;
    private MemberService memberService;

    public MemberController(MemberService memberService) throws SQLException {
        this.memberService = memberService;
        members = memberService.findAll();
    }

    @Override
    public void display() {
        System.out.printf(Member.toStringHeader());
        for (Member member : this.members) {
            System.out.printf(member.toString());
        }
    }

    private Member findGradeById(long id) {
        Member member = null;
        for (int i = 0; i < this.members.size(); i++) {
            if (this.members.get(i).getid() == id) {
                member = this.members.get(i);
                break;
            }
        }
        return member;
    }

    private int findIndexByGradeId(long id) {
        int index = -1;
        for (int i = 0; i < this.members.size(); i++) {
            if (this.members.get(i).getid() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void removeItem(long id) throws SQLException {
        Member member = this.findGradeById(id);
        if (member == null) {
            throw new BusinessLogicException(this.getClass(), "Không tìm thấy độc giả với id đã cho");
        }
        this.members.remove(member);
        this.memberService.remove(id);
    }

    @Override
    public void update(Member member) throws SQLException {
        int index = this.findIndexByGradeId(member.getid());
        if (index == -1) {
            throw new BusinessLogicException(this.getClass(), "Không tìm thấy độc giả với id đã cho");
        }
        this.members.add(index, member);
        this.memberService.update(member);
    }

    @Override
    public void insert(Member member) throws SQLException {
        this.members.add(member);
        this.memberService.save(member);
    }
}
