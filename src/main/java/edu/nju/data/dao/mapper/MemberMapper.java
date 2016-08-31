package edu.nju.data.dao.mapper;

import edu.nju.data.model.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String username);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}