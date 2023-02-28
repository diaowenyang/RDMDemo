package co.jp.practise.domian.design.u64;


public interface VoteState {
    /**
     * 处理状态对应的行为
     *
     * @param user     投票人
     * @param voteItem 投票项
     * @param manager  投票上下文
     */
    void vote(String user, String voteItem, VoteManager manager);
}
