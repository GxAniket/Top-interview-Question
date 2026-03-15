// LeetCode 134 — Gas Station is a classic greedy algorithm problem.

// Problem Summary
// You are given two arrays:
// gas[i] → gas available at station i
// cost[i] → gas needed to go from station i to i+1
// You start with 0 gas and must find the starting gas station index so that you can travel around the circuit once.
// If it’s not possible → return -1.

// Example
// gas  = [1,2,3,4,5]
// cost = [3,4,5,1,2]

// Check total:
// gas total  = 15
// cost total = 15
// Since total gas ≥ total cost → solution exists.
// Correct starting station:
// index = 3

// Dry Run
// Start at station 3
// gas[3] = 4
// cost[3] = 1
// tank = 3
// Next:
// station 4:
// tank = 3 + 5 - 2 = 6
// Next:
// station 0:
// tank = 6 + 1 - 3 = 4
// Next:
// station 1:
// tank = 4 + 2 - 4 = 2
// Next:
// station 2:
// tank = 2 + 3 - 5 = 0
// Completed circuit ✅

// 1️⃣ Brute Force Method
// Idea
// Try every gas station as a starting point and check if we can complete the circle.
// Steps:
// Start from station i
// Travel through all stations
// Track fuel in tank
// If tank becomes negative → starting point invalid
// Java Code (Brute Force)
  
public class GasStationBrute {

    static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        for(int start = 0; start < n; start++) {

            int tank = 0;
            int count = 0;
            int i = start;

            while(count < n) {

                tank += gas[i] - cost[i];

                if(tank < 0)
                    break;

                i = (i + 1) % n;
                count++;
            }

            if(count == n)
                return start;
        }

        return -1;
    }
}

// Time Complexity
// Case	Complexity
// Worst	O(n²)

// Because we may check every station.

// 2️⃣ Greedy Method (Optimal)
// Idea
// Two observations:
// If total gas < total cost → impossible
// If tank becomes negative at station i, then any station before i cannot be start
// So we reset start:
// start = i + 1
  
// Java Code (Greedy
  
public class GasStationGreedy {

    static int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];

            total += diff;
            tank += diff;

            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }

        if(total >= 0)
            return start;

        return -1;
    }
}

// Time Complexity
// Case	Complexity
// Time	O(n)
// Space	O(1)
// Key Difference
// Method	Idea	Time
// Brute Force	Try every station	O(n²)
// Greedy	Reset start when tank < 0	O(n)

// ✅ Interview Tip
// If interviewer asks:
// Why greedy works?
// Answer:
// If we fail at station i, then any station before i also cannot reach i, so we move the start to i+1.
