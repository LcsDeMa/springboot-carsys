package com.qf.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

/**
 * @Auther: Lcs
 * @Date: 2020/8/13 17:36
 * @Description:
 */
public class ShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //身份信息，用户名
        String principal = (String) token.getPrincipal();
        System.out.println(principal);
        //凭证信息，密码 123
        String credential = new String((char[]) token.getCredentials());
        System.out.println(credential);
        //查询数据库
//        sysUserMapper.selectOne(principal)
        //从数据库查出来的密码：e807d41b46bede835fbecc6669c49233
        //前端登录的密码
//        String password = credential;//密码明文
//        String salt = "fasd";//盐
//        Integer hashIterations = 3;
//        Md5Hash md5Hash = new Md5Hash(password,salt,hashIterations);
//        //判断
//        if("jack".equals(principal) && md5Hash.equals("e4efcddd163d1c83daf379231242c695")){
//            return new SimpleAuthenticationInfo(principal,credential,"MyRealm");
//        }
//        //判断
        if ("jack".equals(principal) && "123".equals(credential)){
            return new SimpleAuthenticationInfo(principal,credential,"ShiroRealm");
        }
        return null;
    }
}
