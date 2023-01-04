package arvind.neetcode;

import java.util.*;

public class Twitter {

    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<Tweet>> tweets;
    private static int TIME = 0;


    class Tweet {
        int tweetId;
        int userId;
        int time;
        int link;

        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.time = TIME;
            TIME+=1;
        }
    }

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, userId);
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((o1, o2) -> o2.time - o1.time);
        List<Integer> userIds = new ArrayList<>();
        userIds.add(userId);
        if (followers.containsKey(userId)) {
            userIds.addAll(followers.get(userId));
        }
        for (int uid :userIds) {
            if (tweets.get(uid).isEmpty()) continue;
            int idx = tweets.get(uid).size() - 1;
            Tweet tweet = tweets.get(uid).get(idx);
            tweet.link = idx;
            pq.offer(tweet);
        }

        while (!pq.isEmpty() && result.size() < 10) {
            Tweet t = pq.poll();
            result.add(t.tweetId);

            if (t.link <= 0) continue;
            Tweet nextTweet = tweets.get(t.userId).get(t.link - 1);
            nextTweet.link = t.link - 1;
            pq.offer(nextTweet);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followeeId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 15); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 25); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 45); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 95); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}
