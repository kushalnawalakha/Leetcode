package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwitterFollower {

        HashMap<Integer,Integer> userTweets=new HashMap<>();
        HashMap<Integer,HashSet<Integer>> userFollows=new HashMap<>();
        ArrayList<Integer> tweets =new ArrayList<>();
        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            tweets.add(tweetId);
            userTweets.put(tweetId,userId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            ArrayList<Integer> list=new ArrayList<>();
            int countOfRelevantTweets=0;
            for(int i=tweets.size()-1;i>=0&&countOfRelevantTweets<10;i--){
                if(userTweets.get(tweets.get(i))==userId||(userFollows.get(userId)!=null&&userFollows.get(userId).contains(userTweets.get(tweets.get(i))))){
                    countOfRelevantTweets++;
                    list.add(tweets.get(i));
                }
            }
            return list;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            HashSet<Integer> set=userFollows.get(followerId);
            if(set==null){
                set=new HashSet<>();
                set.add(followeeId);
                userFollows.put(followerId,set);
            }else{
                set.add(followeeId);
            }

        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            HashSet<Integer> set=userFollows.get(followerId);
            if(set!=null){
                set.remove(followeeId);
            }
        }

    public static void main(String[] args) {
        TwitterFollower follower=new TwitterFollower();
        follower.postTweet(1,4);
        follower.postTweet(2,5);
        follower.unfollow(1,2);
        System.out.println(follower.getNewsFeed(1));
        System.out.println(follower.getNewsFeed(2));
    }
}
