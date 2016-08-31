class Tweet {
    int userId;
    int tweetId;
    int time;
    Tweet nextTweet;
    Tweet(int time, int userId, int tweetId) {
        this.time = time;
        this.userId = userId;
        this.tweetId = tweetId;
        nextTweet = null;
    }
    
    void setNext(Tweet tweet) {
        nextTweet = tweet;
    }
}

class User {
    List<Tweet> tweets;
    HashSet<User> followees;
    
    int userId;
    User(int userId) {
        this.userId = userId;
        tweets = new ArrayList<Tweet>();
        followees = new HashSet<User>();
        followees.add(this);
    }
    
    void postTweet(Tweet tweet) {
        if (tweets.size() > 0)
        	tweet.setNext(tweets.get(0));
        tweets.add(0, tweet);
    }
    
    List<Integer> getTweets() {
        List<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a,b)->(b.time-a.time));
        
        for (User followee : followees) {
            if (followee.tweets.size() > 0)
                queue.offer(followee.tweets.get(0));
        }
        
        while (ans.size() < 10 && queue.size() > 0) {
            Tweet tweet = queue.poll();
            ans.add(tweet.tweetId);
            if (tweet.nextTweet != null)
                queue.offer(tweet.nextTweet);
        }
        
        return ans;
    }
}

public class Twitter {

    /** Initialize your data structure here. */
    int time;
    HashMap<Integer, User> users;
    public Twitter() {
        time = 0;
        users = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = users.getOrDefault(userId, new User(userId));
        users.putIfAbsent(userId, user);
        
        user.postTweet(new Tweet(time++, userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user = users.getOrDefault(userId, new User(userId));
        return user.getTweets();
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = users.getOrDefault(followerId, new User(followerId));
        User followee = users.getOrDefault(followeeId, new User(followeeId));
        users.putIfAbsent(followerId, follower);
        users.putIfAbsent(followeeId, followee);
        follower.followees.add(followee);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User follower = users.getOrDefault(followerId, new User(followerId));
        User followee = users.getOrDefault(followeeId, new User(followeeId));
        users.putIfAbsent(followerId, follower);
        users.putIfAbsent(followeeId, followee);
        follower.followees.remove(followee);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */  