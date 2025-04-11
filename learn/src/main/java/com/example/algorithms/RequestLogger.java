package com.example.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class RequestLogger {
    private HashMap<String,Integer> his;
    private int timeLimit = 0;
    public RequestLogger(int timeLimit) {
		// Initialize your data structure here
        this.timeLimit = timeLimit;
        this.his = new HashMap<>();
	}

	public boolean messageRequestDecision(int timestamp, String request) {
		// Replace this placeholder return statement with your code
        if (his.containsKey(request)) {
            int disTime = his.get(request);
            if (timestamp - disTime > this.timeLimit) {
                his.put(request, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            his.put(request, timestamp);
            return true;
        }		
	}

     public boolean checkSubarraySum(ArrayList<Integer> nums, int k) {
        
        // Return this placeholder return statement with your code
        
        for (int i = 0; i < nums.size() - 1; i++) {
            int sum = nums.get(i);
            for (int j = i + 1; j < nums.size();j++) {
                sum += nums.get(j);
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
