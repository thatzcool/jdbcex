package com.ssg.jdbcex.todo.service;

import com.ssg.jdbcex.todo.dao.MemberDAO;
import com.ssg.jdbcex.todo.domain.MemberVO;
import com.ssg.jdbcex.todo.dto.MemberDTO;
import com.ssg.jdbcex.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;


public enum MemberService {
    INSTANCE;

    private ModelMapper modelMapper = new ModelMapper();
    private MemberDAO dao;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

    public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }

}
