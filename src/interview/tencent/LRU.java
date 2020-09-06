package interview.tencent;

import java.util.*;

/**
 * 1000用户
 * 处理1万用户
 * 最长时间未响应的用户替换出去，把1001用户放入
 * O(logN)
 */
public class LRU {

    private int maxUserSize=1000;
    private List<User> userList=new ArrayList<>();
    private Map<Integer,User> userMap=new HashMap<>();

    public void updateUser(int uuid){
        // 更新用户登录时间

    }

    public User getUser(int uuid){
        return userMap.get(uuid);
    }

    public void setUser(User user){
        // 如果userList未满或者map中已经有该user，直接放入map，并对userList做处理
        boolean existed=userMap.containsKey(user.uuid);
        if (userList.size() != maxUserSize||existed) {
            userMap.put(user.uuid,user);

            // 对userList做更新处理
            // userList需要按loginTime排序，登陆时间最早的放在最左边

            // 如果userList中有该user，需要删掉已有的，并重新放置user
            if(existed){
                userList.removeIf(x->x.uuid==user.uuid);
            }

            // 重新防止user
            userList.add(user);
            userList.sort(Comparator.comparingInt(x->x.loginTime));
        }
    }

    // loginTime:1,5,10,100
    private void addToList(User user){
    }

    private static final class User{
        public int uuid;
        public int loginTime; // 按登录时间排序

        public User(int uuid,int loginTime){
            this.loginTime=loginTime;
        }
    }
}
