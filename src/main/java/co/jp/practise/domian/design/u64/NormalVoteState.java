package co.jp.practise.domian.design.u64;


public class NormalVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        // 正常投票
        manager.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功");
    }
}
