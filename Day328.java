/*

Topic:- Count Strings

Link:- https://www.hackerrank.com/challenges/count-strings/problem?isFullScreen=true

Problem:-

A regular expression is used to describe a set of strings. For this problem the alphabet is limited to 'a' and 'b'.

We define  to be a valid regular expression if:
1)  is "" or "".
2)  is of the form "", where  and  are regular expressions.
3)  is of the form "" where  and  are regular expressions.
4)  is of the form "" where  is a regular expression.

Regular expressions can be nested and will always have have two elements in the parentheses. ('' is an element, '' is not; basically, there will always be pairwise evaluation) Additionally, '' will always be the second element; '' is invalid.

The set of strings recognized by  are as follows:
1) If  is "", then the set of strings recognized .
2) If  is "", then the set of strings recognized .
3) If  is of the form "" then the set of strings recognized = all strings which can be obtained by a concatenation of strings  and , where  is recognized by  and  by .
4) If  is of the form "" then the set of strings recognized = union of the set of strings recognized by  and .
5) If  is of the form "" then the the strings recognized are the empty string and the concatenation of an arbitrary number of copies of any string recognized by .

Task
Given a regular expression and an integer, , count how many strings of length  are recognized by it.

Input Format

The first line contains the number of test cases .  test cases follow.
Each test case contains a regular expression, , and an integer, .

Output Format

Print  T lines, one corresponding to each test case containing the required answer for the corresponding test case. As the answers can be very big, output them modulo 10^9 + 7.




Solution:-
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
 
 static int parseIndex = 0;
 static final int MOD = 1000000007;
 
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int cases = scan.nextInt();
  for(int cs=0; cs<cases; cs++){
   String regex = scan.next();
   int length = scan.nextInt();
   NFA nfa = parse(regex);
   DFA dfa = new DFA(nfa);
   long[][] graph = dfa.toAdjacencyMatrix();
   graph = power(graph, length);
   long words = 0;
   for(int end : dfa.ends){
    words += graph[dfa.start][end];
   }
   words %= MOD;
   System.out.println(words);
  }
 }
 
 static long[][] power(long[][] matrix, long power){
  if(power == 1)
   return matrix;
  else if(power % 2 == 0)
   return power(multiply(matrix, matrix), power/2);
  else
   return multiply(matrix, power(multiply(matrix, matrix), power/2));
 }
 
 static long[][] multiply(long[][] m1, long[][] m2){
  long[][] res = new long[m1.length][m1.length];
  for(int i=0; i<m1.length; i++){
   for(int j=0; j<m1.length; j++){
    long dotProd = 0;
    for(int k=0; k<m1.length; k++){
     dotProd += m1[i][k] * m2[k][j];
                    dotProd %= MOD;
    }
    res[i][j] = dotProd;
   }
  }
  return res;
 }
 
 static NFA parse(String regex){
  parseIndex = 0;
  return new NFA(regex);
 }
 
 static class DFA{
  int start;
  HashSet<Integer> ends = new HashSet<Integer>();
  List<DFANode> nodes = new ArrayList<DFANode>();
  HashMap<DFANode, Integer> nodeMap = new HashMap<DFANode, Integer>();
  
  public DFA(NFA nfa){
   HashSet<DFANode> allNodes = new HashSet<DFANode>();
   Queue<DFANode> wipNodes = new LinkedList<DFANode>();
   DFANode startNode = new DFANode(nfa.start.findClosure());
   startNode.startState = true;
   allNodes.add(startNode);
   wipNodes.offer(startNode);
   
   while(!wipNodes.isEmpty()){
    DFANode node = wipNodes.poll();
    
    HashSet<NFANode> nextState = NFA.nextState(node.state, 'a');
    if(!nextState.isEmpty()){
     DFANode next = new DFANode(nextState);
     node.letterA = next;
     if(allNodes.add(next))
      wipNodes.offer(next);
    }
    
    nextState = NFA.nextState(node.state, 'b');
    if(!nextState.isEmpty()){
     DFANode next = new DFANode(nextState);
     node.letterB = next;
     if(allNodes.add(next))
      wipNodes.offer(next);
    }
    
    if(node.state.contains(nfa.end))
     node.endState = true;
   }
   
   for(DFANode node : allNodes){
    int index = nodes.size();
    nodes.add(node);
    nodeMap.put(node, index);
    if(node.startState)
     start = index;
    else if(node.endState)
     ends.add(index);
   }
  }
  
  long[][] toAdjacencyMatrix(){
   long[][] matrix = new long[nodes.size()][nodes.size()];
   for(int i=0; i<nodes.size(); i++){
    DFANode node = nodes.get(i);
    if(node.letterA != null)
     matrix[i][nodeMap.get(node.letterA)] = 1;
    if(node.letterB != null)
     matrix[i][nodeMap.get(node.letterB)] = 1;
   }
   return matrix;
  }
 }
 
 static class NFA{
  NFANode start, end;
  
  public NFA(String regex){
   start = new NFANode();
   end = new NFANode();
   end.endState = true;
   
   if(regex.charAt(parseIndex) == 'a'){//direct 'a' transition
    parseIndex++;
    start.letterA.add(end);
   } else if(regex.charAt(parseIndex) == 'b'){//direction 'b' transition
    parseIndex++;
    start.letterB.add(end);
   } else{//opening bracket
    parseIndex++;
    NFA child = new NFA(regex);
    if(regex.charAt(parseIndex) == '*'){//repeat
     parseIndex++;
     start.epsilon.add(child.start);
     start.epsilon.add(end);
     child.end.epsilon.add(end);
     child.end.endState = false;
     end.epsilon.add(child.start);
    } else if(regex.charAt(parseIndex) == '|'){//or
     parseIndex++;
     NFA child2 = new NFA(regex);
     start.epsilon.add(child.start);
     start.epsilon.add(child2.start);
     child.end.epsilon.add(end);
     child2.end.epsilon.add(end);
     child.end.endState = false;
     child2.end.endState = false;
    } else{//concat
     NFA child2 = new NFA(regex);
     start = child.start;
     end = child2.end;
     child.end.epsilon.add(child2.start);
     child.end.endState = false;
    }
    parseIndex++;//skip closing bracket
   }
  }
  
  static HashSet<NFANode> nextState(HashSet<NFANode> states, char transition){
   HashSet<NFANode> reachableClosure = new HashSet<NFANode>();
   for(NFANode node : states){
    HashSet<NFANode> reachable = new HashSet<NFANode>();
    switch(transition){
    case 'a':
     reachable.addAll(node.letterA);
     break;
    case 'b':
     reachable.addAll(node.letterB);
     break;
    }
    for(NFANode n : reachable)
     reachableClosure.addAll(n.findClosure());
   }
   return reachableClosure;
  }
 }
 
 static class NFANode{
  HashSet<NFANode> letterA = new HashSet<NFANode>();
  HashSet<NFANode> letterB = new HashSet<NFANode>();
  HashSet<NFANode> epsilon = new HashSet<NFANode>();
  
  boolean endState = false;
  
  HashSet<NFANode> findClosure(){
   HashSet<NFANode> closure = new HashSet<NFANode>();
   Stack<NFANode> DFS = new Stack<NFANode>();
   DFS.push(this);
   while(!DFS.isEmpty()){
    NFANode node = DFS.pop();
    closure.add(node);
    for(NFANode n : node.epsilon)
                    if(!closure.contains(n))
         DFS.push(n);
   }
   return closure;
  }
 }
 
 static class DFANode{
  DFANode letterA;
  DFANode letterB;
  
  HashSet<NFANode> state = new HashSet<NFANode>();
  
  boolean startState = false;
  boolean endState = false;
  
  public DFANode(HashSet<NFANode> state){
   this.state = state;
  }

  @Override
  public int hashCode() {
   final int prime = 31;
   int result = 1;
   result = prime * result + ((state == null) ? 0 : state.hashCode());
   return result;
  }

  @Override
  public boolean equals(Object obj) {
   if (this == obj)
    return true;
   if (obj == null)
    return false;
   if (getClass() != obj.getClass())
    return false;
   DFANode other = (DFANode) obj;
   if (state == null) {
    if (other.state != null)
     return false;
   } else if (!state.equals(other.state))
    return false;
   return true;
  }
 }
}
