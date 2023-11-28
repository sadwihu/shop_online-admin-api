package com.shop_online.service;

import com.shop_online.common.result.PageResult;
import com.shop_online.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop_online.vo.UserVO;

import com.shop_online.common.model.Query;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunyu
 * @since 2023-11-28
 */
public interface UserService extends IService<User> {

    /**
     * 用户记录
     *
     * @param query
     * @return
     */

    PageResult<UserVO> getPage (Query query);
    /**
     * 导出用户记录
     *
     * @param query
     * @param response
     */
    void exportUserInfo(Query query, HttpServletResponse response);
}
