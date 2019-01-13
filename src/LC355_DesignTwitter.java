import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC355_DesignTwitter {
    class Tweet{
        int time;
        int id;
        Tweet(int _time, int _id){
            time = _time;
            id = _id;
        }
    }

    private HashMap<Integer, List<Tweet>> newsFeed;
    private HashMap<Integer, List<Tweet>> tweets;
    private HashMap<Integer, List<Integer>> followers;
    private int time;

    /** Initialize your data structure here. */
    public LC355_DesignTwitter() {
        newsFeed = new HashMap<>();
        tweets = new HashMap<>();
        followers = new HashMap<>();
        time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(time++, tweetId);
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(tweet);
        newsFeed.putIfAbsent(userId, new ArrayList<>());
        newsFeed.get(userId).add(0, tweet);

        List<Integer> followers = this.followers.get(userId);
        if(followers==null) return;
        for(int follower: followers){
            newsFeed.get(follower).add(0, tweet);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsList = new ArrayList<>();
        if(newsFeed.get(userId)==null) return newsList;

        for(int i=0;i<Math.min(10, newsFeed.get(userId).size());i++){
            newsList.add(newsFeed.get(userId).get(i).id);
        }
        return newsList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId || (followers.get(followeeId)!=null && followers.get(followeeId).contains(followerId))) return ;

        tweets.putIfAbsent(followeeId, new ArrayList<>());
        newsFeed.putIfAbsent(followerId, new ArrayList<>());
        List<Tweet> tweetsFromFollowee = tweets.get(followeeId);
        List<Tweet> newsFeedOfFollower = newsFeed.get(followerId);
        newsFeedOfFollower.addAll(tweetsFromFollowee);
        Collections.sort(newsFeed.get(followerId), (a, b)->b.time-a.time);

        followers.putIfAbsent(followeeId, new ArrayList<>());
        followers.get(followeeId).add(followerId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId || followers.get(followeeId)==null || !followers.get(followeeId).contains(followerId)) return ;

        followers.putIfAbsent(followeeId, new ArrayList<>());
        followers.get(followeeId).remove((Integer)followerId);

        tweets.putIfAbsent(followeeId, new ArrayList<>());
        newsFeed.putIfAbsent(followerId, new ArrayList<>());
        List<Tweet> tweetsFromFollowee = tweets.get(followeeId);
        List<Tweet> newsFeedOfFollower = newsFeed.get(followerId);
        for(Tweet tweet: tweetsFromFollowee){
            newsFeedOfFollower.remove(tweet);
        }
    }
}
