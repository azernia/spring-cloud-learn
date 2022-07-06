package com.rui.auth.security.service;

import com.rui.api.feign.UserFeignClient;
import com.rui.api.model.request.UserDTO;
import com.rui.auth.enums.PasswordEncoderTypeEnum;
import com.rui.auth.security.details.SysUserDetails;
import com.rui.common.basic.result.RespBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * description:
 * date: 2022/6/17 14:40
 *
 * @author rui
 */
@Service("sysUserDetailsService")
@Slf4j
@RequiredArgsConstructor
public class SysUserDetailsService implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RespBean<UserDTO> respBean = userFeignClient.getUserByUsername(username);
        SysUserDetails userDetails = null;
        if (RespBean.success().getCode().equals(respBean.getCode())) {
            UserDTO userDTO = respBean.getData();
            if (Objects.nonNull(userDTO)) {
                userDetails = SysUserDetails.builder()
                        .userId(userDTO.getId().longValue())
                        .username(userDTO.getUsername())
                        .password(PasswordEncoderTypeEnum.BCRYPT.getPrefix() + userDTO.getPassword())
                        .enabled(userDTO.getStatus())
                        .authorities(authorities(userDTO.getRoleCodes())).build();
            } else {
                throw new UsernameNotFoundException("用户不存在");
            }
        }
        Assert.notNull(userDetails,"user details is null");
        if (!userDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return userDetails;
    }

    private Collection<SimpleGrantedAuthority> authorities(List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    // private SysUserDetails loadUser(String username) {
    //     Collection<SimpleGrantedAuthority> authorities =new ArrayList<>();
    //     authorities.add(new SimpleGrantedAuthority("admin"));
    //     return SysUserDetails.builder()
    //             .userId(1L)
    //             .username(username)
    //             .enabled(true)
    //             .authorities(authorities)
    //             .password(PasswordEncoderTypeEnum.BCRYPT.getPrefix() + new BCryptPasswordEncoder().encode("123456")).build();
    // }
}
