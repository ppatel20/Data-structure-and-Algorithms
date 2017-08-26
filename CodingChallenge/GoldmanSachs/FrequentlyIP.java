package GoldmanSachs;

/* Problem Name is &&& ApacheLog &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement findTopIpAddress() correctly.
 *  4) If time permits, try to improve your implementation.
 */

import java.util.*;

class Solution {

  /**
   * String findTopIpaddress(String[] lines)
   * Given an Apache log file, return IP address(es) which accesses the site most often.
   * 
   * Our log is in this format (Common Log Format). One entry per line and it starts with an IP address which accessed the site, 
   * followed by a whitespace.
   * 
   * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
   * 
   * Log file entries are passsed as an array.
   */

  public static Set<String> findTopIpaddress(String[] lines) {
    // TODO: Implement solution
    Map<String, Integer> ipMap = new HashMap<>();
    Set<String> ips = new HashSet<>();
    int max = 0;
    for(String ip : lines){
      String ipAddress = ip.substring(0, ip.indexOf(" "));
      if(ipMap.containsKey(ipAddress)){
        ipMap.put(ipAddress, ipMap.get(ipAddress)+1);        
        max = Math.max(max,ipMap.get(ipAddress));
      }else{
        ipMap.put(ipAddress, 1);
        max = Math.max(max,1);
      }      
    }
    
    for(Map.Entry<String, Integer> entry : ipMap.entrySet()){
      if(entry.getValue() == max)
        ips.add(entry.getKey());
    }
   // System.out.println(max);
   // ipMap.forEach((k,v) -> System.out.println(k + " " + v));
    System.out.println(ips);
    return ips;
  }
  
  /**
   * boolean doTestsPass()
   * Returns true if the test passes. Otherwise returns false.
   */      
  public static boolean doTestsPass() {
    // TODO: improve the test
    String lines[] = new String[] {
        "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
        "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
        "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
        "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
    };
    Set<String> result = findTopIpaddress(lines);
    Set<String> accResult = new HashSet<>();
    accResult.add("10.0.0.1");
    accResult.add("10.0.0.2");
    
    for(String s : accResult){
      if(!result.contains(s))
      {
        System.out.println("Test failed");
        return false;
      }
    }
    System.out.println("Test passed");
    return true;
    // if (result.get(1).equals("10.0.0.1") && result.get(0).equals("10.0.0.2")) {
    //   System.out.println("Test passed");
    //   return true;
    // } else {
    //   System.out.println("Test failed");
    //   return false;
    // }  
  }
  
  public static void main(String[] args) {
    doTestsPass();
    
  }
  
}
