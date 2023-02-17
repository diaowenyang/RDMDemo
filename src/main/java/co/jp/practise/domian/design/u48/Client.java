package co.jp.practise.domian.design.u48;


public class Client {

    public static void main(String[] args) {
        ProxyFactory proxy = new ProxyFactory();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.login();
    }
}
