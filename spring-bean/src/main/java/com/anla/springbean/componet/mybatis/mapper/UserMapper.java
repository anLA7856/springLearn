package com.anla.springbean.componet.mybatis.mapper;

import com.anla.springbean.componet.mybatis.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**不用 @mapper也一样
 *
 * @author anLA7856
 * @date 20-3-15 下午3:47
 * @description
 */
public interface UserMapper {
    @Select("SELECT * FROM user WHERE uid = #{userId}")
    User getUser(@Param("userId") Long userId);
}