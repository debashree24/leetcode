# LeetCode Solutions in Java

This repository contains my solutions to various LeetCode problems implemented in Java.

## Project Structure

```
src/
└── main/
    └── java/
        └── solutions/
            ├── easy/         # Solutions for easy difficulty problems
            ├── medium/       # Solutions for medium difficulty problems
            └── hard/         # Solutions for hard difficulty problems
```

## Adding a New Solution

1. Create a new Java file in the appropriate difficulty folder
2. Name the file using the problem's name in snake_case
3. Follow this template for each solution:

```java
/**
 * Problem: [Problem Name]
 * Difficulty: [Easy/Medium/Hard]
 * 
 * Problem Statement:
 * [Paste the problem statement here]
 * 
 * Example:
 * [Example input and output]
 * 
 * Solution:
 * [Brief explanation of the approach]
 */

public class Solution {
    public static void main(String[] args) {
        // Test cases
    }
    
    // Your solution method here
}
```

## Running Solutions

1. Make sure you have Java JDK installed
2. Compile and run individual solution files using:
   ```
   javac src/main/java/solutions/[difficulty]/[problem_name].java
   java -cp src/main/java solutions.[difficulty].[problem_name]
   ```

## Notes

- Each solution includes comments explaining the approach
- Time and space complexity analysis is included where applicable
- Test cases are included in the main method for verification
