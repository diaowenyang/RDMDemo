package co.jp.practise.business.design.u29;


import co.jp.practise.domian.design.u29.WalletRpcService;

public class MockWalletRpcServiceOne extends WalletRpcService {

    public String moveMoney(Long id, Long fromUserId, Long toUserId, Double amount) {
        return "123bac";
    }
}
