class Twitter {
    class Tweet {
        int tweetId;
        int time;
        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> userTweets; 
    private int timestamp;
    
    public Twitter() {
        followMap = new HashMap<>();
        userTweets = new HashMap<>();
        timestamp = 0;        
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId,timestamp++);
        List<Tweet> tweets;
        if(userTweets.containsKey(userId)){
            tweets = userTweets.get(userId);
        }else{
           tweets = new ArrayList<>();
        }
        tweets.add(newTweet);
        userTweets.put(userId,tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> recentTweets = new PriorityQueue<>((a,b)->(a.time)-(b.time));

         Set<Integer> peopleToCheck = new HashSet<>();
         peopleToCheck.add(userId); // always include self
         if (followMap.containsKey(userId)) {
              peopleToCheck.addAll(followMap.get(userId));
         }

         for(Integer user : peopleToCheck){
            List<Tweet> tweets = userTweets.get(user);
            if (tweets == null) continue;
            int n = tweets.size();
            for (int i = n - 1; i >= Math.max(0, n - 10); i--) {
                 recentTweets.offer(tweets.get(i));
                if (recentTweets.size() > 10) recentTweets.poll();
            } 
         }

         while(!recentTweets.isEmpty()){
           feed.add(recentTweets.peek().tweetId);
           recentTweets.poll();
         }

         Collections.reverse(feed);
         return feed;    
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> following;
        if(followMap.containsKey(followerId)){
           following = followMap.get(followerId);
        }else{
            following = new HashSet<Integer>();
        }
        following.add(followeeId);
        followMap.put(followerId,following);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following;
        if(followMap.containsKey(followerId)){
           following = followMap.get(followerId);
           following.remove(followeeId);
           if(following.size()>0){
             followMap.put(followerId,following);
           }else{
             followMap.remove(followerId);
           }  
        }
    }
}
