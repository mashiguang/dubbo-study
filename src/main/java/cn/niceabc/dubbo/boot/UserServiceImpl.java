package cn.niceabc.dubbo.boot;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    public User get(Long id) {
        User u = new User();
        u.setId(1L);
        u.setName("Jack");
        return u;
    }
}
