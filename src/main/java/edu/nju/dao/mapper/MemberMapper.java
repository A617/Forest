package edu.nju.dao.mapper;

import edu.nju.model.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}