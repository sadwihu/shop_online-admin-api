package com.shop_online.controller;

import com.shop_online.common.result.PageResult;
import com.shop_online.common.result.Result;
import com.shop_online.service.UserService;
import com.shop_online.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop_online.common.model.Query;
import javax.validation.Valid;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunyu
 * @since 2023-11-28
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("page")
    @ApiOperation("分页")
//    @PreAuthorize("hasAuthority('sys:user:list')")
    public Result<PageResult<UserVO>> page(@RequestBody @Valid Query query) {
        PageResult<UserVO> result = userService.getPage(query);
        return Result.ok(result);

    }
}
