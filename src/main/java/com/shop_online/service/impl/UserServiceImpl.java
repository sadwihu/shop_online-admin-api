package com.shop_online.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop_online.common.result.PageResult;
import com.shop_online.convert.UserConvert;
import com.shop_online.entity.User;
import com.shop_online.mapper.UserMapper;
import com.shop_online.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop_online.utils.ExcelUtils;
import com.shop_online.vo.UserVO;
import org.springframework.stereotype.Service;

import com.shop_online.common.model.Query;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunyu
 * @since 2023-11-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public PageResult<UserVO> getPage(Query query) {
        Page<User> page = new Page<User>(query.getPage(), query.getLimit());
        Page<User> userPage = baseMapper.selectPage(page, null);
        List<UserVO> list = UserConvert.INSTANCE.convertToUserVOList(userPage.getRecords());
        return new PageResult<>(list,page.getTotal());

    }

    @Override
    public void exportUserInfo(Query query, HttpServletResponse response) {
        List<User> users = baseMapper. selectList( null);
        List<UserVO>list = UserConvert . INSTANCE . convertToUserVOList(users);
        ExcelUtils.writeExcel(response, list, "userList", "用户信息",UserVO.class);

    }
}
