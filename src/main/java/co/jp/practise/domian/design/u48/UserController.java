package co.jp.practise.domian.design.u48;


/**
 * 被代理类
 */
public class UserController implements IUserController {
    @Override
    public void login() {
        System.out.println("UserController login...");
    }
}
