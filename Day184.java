/*

Topic:- Determining DNA Health

Link:- https://www.hackerrank.com/challenges/determining-dna-health/problem?isFullScreen=true

Problem:-

DNA is a nucleic acid present in the bodies of living things. Each piece of DNA contains a number of genes, some of which are beneficial and increase the DNA's total health. Each gene has a health value, and the total health of a DNA is the sum of the health values of all the beneficial genes that occur as a substring in the DNA. We represent genes and DNA as non-empty strings of lowercase English alphabetic letters, and the same gene may appear multiple times as a susbtring of a DNA.

Given the following:

An array of beneficial gene strings, . Note that these gene sequences are not guaranteed to be distinct.
An array of gene health values, , where each  is the health value for gene .
A set of  DNA strands where the definition of each strand has three components, , , and , where string  is a DNA for which genes  are healthy.
Find and print the respective total healths of the unhealthiest (minimum total health) and healthiest (maximum total health) strands of DNA as two space-separated values on a single line.

Input Format

The first line contains an integer, , denoting the total number of genes.
The second line contains  space-separated strings describing the respective values of  (i.e., the elements of ).
The third line contains  space-separated integers describing the respective values of  (i.e., the elements of ).
The fourth line contains an integer, , denoting the number of strands of DNA to process.
Each of the  subsequent lines describes a DNA strand in the form start end d, denoting that the healthy genes for DNA strand  are  and their respective correlated health values are .


Output Format

Print two space-separated integers describing the respective total health of the unhealthiest and the healthiest strands of DNA.




Solution:-
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class QuickScanner {
    static final int BUFFER_NOT_READ = -1;
    static final int BUFFER_SIZE = 64*1024;
    final InputStream is;
    int curr = BUFFER_NOT_READ;
    int length;
    byte[] buffer = new byte[BUFFER_SIZE];
    QuickScanner(InputStream is) {
        this.is = is;
    }

    void readBuffer() throws IOException {
        int readBytes = is.read(buffer);
        if (readBytes == -1) {
            throw new IllegalStateException(
                    "End of stream reached.");
        }
        curr = 0;
        length = readBytes;
    }

    void initialRead() throws IOException {
        if (curr == BUFFER_NOT_READ || curr >= BUFFER_SIZE) {
            readBuffer();
        }
    }

    char nextChar() throws IOException {
        initialRead();
        if (curr >= length) {
            return ' ';
        }
        return (char) buffer[curr++];
    }

    long nextLong() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char ch = nextChar();
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else {
                break;
            }
        }
        return Long.parseLong(sb.toString());
    }

    int nextInt() throws IOException {
        long l = nextLong();
        assert(l < (long) Integer.MAX_VALUE);
        return (int) l;
    }

    String nextAlphanumericString() throws IOException {
        StringBuilder sb = new StringBuilder(256);
        while (true) {
            char ch = nextChar();
            if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    void close() throws IOException {
        length = 0;
        curr = 0;
        is.close();
    }
}

class DNATask implements Comparable<DNATask> {
    final int gene;
    final int dna;
    final boolean isStart;

    DNATask(int gene, int dna, boolean isStart) {
        this.gene = gene;
        this.dna = dna;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(DNATask o) {
        int comp;
        comp = Integer.compare(gene, o.gene);
        if (comp != 0) return comp;
        comp = Integer.compare(dna, o.dna);
        if (comp != 0) return comp;
        return - Boolean.compare(isStart, o.isStart);
    }

    @Override
    public String toString() {
        return "DNATask{" +
                "gene=" + gene +
                ", dna=" + dna +
                ", isStart=" + isStart +
                '}';
    }
}

class Node {
    final Node parent;
    final int ch; 
    String nodeName;  

    Node[] children;
    long score;

    Node postfix;
    Set<Node> reversePostfixes;

    Node(Node parent, int ch) {
        this.parent = parent;
        this.ch = ch;
    }

    void add(String str, int strIdx, int sc) {
        if (strIdx >= str.length()) {
            score += sc;
            // clearTotalScore();
        } else {
            int c = str.charAt(strIdx) - 'a';
            if (children == null) {
                children = new Node[26];
            }
            Node child = children[c];
            if (child == null) {
                children[c] = child = new Node(this, c);
                child.calculatePostfix();
                child.updateReversePostfixes(this);
            }
            child.add(str, strIdx + 1, sc);
        }
    }

    void setPostfix(Node newPostfixNode) {
        if (postfix != null) {
            postfix.reversePostfixes.remove(this);
        }
        postfix = newPostfixNode;
        if (newPostfixNode != null) {
            Set<Node> h = newPostfixNode.reversePostfixes;
            if (h == null) {
                newPostfixNode.reversePostfixes =
                        h = new HashSet<>(4);
            }
            h.add(this);
        }
    }

    void calculatePostfix() {
        if (parent == null) {
            return;
        }
        Node p = parent.postfix;
        if (p == null) {
            setPostfix(parent);
            return;
        }
        while (true) {
            if (p.children != null) {
                Node child = p.children[ch];
                if (child != null) {
                    setPostfix(child);
                    break;
                }
            }
            if (p.postfix == null) {
                setPostfix(p);
                break;
            }
            p = p.postfix;
        }
    }

    void updateReversePostfixes(Node parentNode) {
        if (parentNode == null || parentNode == this ||
                parentNode.reversePostfixes == null) return;
        for (Node n:parentNode.reversePostfixes.toArray(
                new Node[0])) {
            if (n.children != null) {
                Node sameChild = n.children[ch];
                if (sameChild != null) {
                    sameChild.setPostfix(this);
                    continue;
                }
            }
            updateReversePostfixes(n);
        }
    }

    String getNodeName() {
        if (nodeName == null) {
            nodeName = parent == null
                ? "l_" : parent.getNodeName() + (char)(ch + 'a');
        }
        return nodeName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "ch=" + (char)(ch + 'a') +
                ", nodeName='" + getNodeName() + '\'' +
                ", score=" + score +
                ", postfix=" + (postfix == null ?
                '-' : postfix.getNodeName()) +
                '}';
    }

    void printTree() {
        System.err.println(getNodeName() +
                " [ label=\"" + (char)(ch + 'a') +
                ": " + score + " (" + getTotalScore() + ")\" ]");
        if (parent != null) {
            System.err.println(
                    parent.getNodeName() + " -> " + getNodeName());
        }
        if (postfix != null) {
            System.err.println(
                    getNodeName() + " -> " +
                            postfix.getNodeName() + " [color=blue]");
        }
        if (children != null) {
            for (int i = 0; i < 26; i++) {
                Node child = children[i];
                if (child != null) child.printTree();
            }
        }
    }

    public long getTotalScore() {
        long sc = score;
        if (postfix != null) {
            sc += postfix.getTotalScore();
        }
        return sc;
    }
}

class DNAHealth {
    private static final int SPACE = ' ' - 'a';

    int n;  
    String[] genes;
    int[] scores;

    int s;  
    String[] dnaStrands;
    DNATask[] dnaTasks;
    long[] dnaScores;

    long startTime;
    long lastTime;

    void startTimer() {
        startTime = System.nanoTime();
        lastTime = startTime;
        System.err.println("--- Timer started.");
    }

    synchronized void logTime(String txt) {
        long now = System.nanoTime();
        System.err.format("--- %8.3fms (%8.3fms) %s\n",
                (now - startTime)/1000000.0, (now - lastTime)/1000000.0, txt);
        lastTime = now;
    }

    long addTime = 0;
    long addCount = 0;
    long walkTime = 0;
    long walkCount = 0;

    void readInitialData(String inputFile) throws IOException {
        final QuickScanner scanner = new QuickScanner(inputFile == null ? System.in : new FileInputStream(inputFile));
        n = scanner.nextInt();

        genes = new String[n];

        for (int i = 0; i < n; i++) {
            genes[i] = scanner.nextAlphanumericString();
        }

        scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        logTime("Genes read: " + n);

        s = scanner.nextInt();

        dnaTasks = new DNATask[2*s];
        dnaStrands = new String[s];
        for (int i = 0; i < s; i++) {
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            dnaStrands[i] = scanner.nextAlphanumericString();
            int idx = 2*i;
            dnaTasks[idx] = new DNATask(first, i, true);
            dnaTasks[idx + 1] = new DNATask(last + 1, i, false);
        }
        scanner.close();
        dnaScores = new long[s];
        logTime("DNA Strands read: " + s);
    }

    class ProcessingThread extends Thread {
        final int partition;
        final int geneStart;
        int geneEnd;
        final int dnaTaskStartIdx;
        int dnaTaskEndIdx;
        Integer[] finishProc;
        long t0;

        void resetT0() {
            t0 = System.nanoTime();
        }

        void endWalkTime() {
            synchronized (DNAHealth.this) {
                walkTime += System.nanoTime() - t0;
                walkCount++;
            }
        }

        void endAddTime() {
            synchronized (DNAHealth.this) {
                addTime += System.nanoTime() - t0;
                addCount++;
            }
        }

        ProcessingThread(int partition, int geneStart, int dnaTaskStartIdx) {
            super("Partition " + partition);
            this.partition = partition;
            this.geneStart = geneStart;
            this.dnaTaskStartIdx = dnaTaskStartIdx;
        }

        @Override
        public void run() {
            logTime("Thread for partition " +
                    partition + " started. geneStart: " + geneStart);
            final Node tree = new Node(null, SPACE);
            int treeBuiltIdx = geneStart - 1;
            for (int i = dnaTaskStartIdx; i < dnaTaskEndIdx; i++) {
                DNATask task = dnaTasks[i];
                while (treeBuiltIdx < task.gene - 1) {
                    treeBuiltIdx++;
                    resetT0();
                    tree.add(genes[treeBuiltIdx], 0, scores[treeBuiltIdx]);
                    endAddTime();
                }
                long score = (task.isStart ? -1L : 1L)
                        * calcScoreForStrand(tree, dnaStrands[task.dna]);
                synchronized (DNAHealth.this) {
                    dnaScores[task.dna] += score;
                }
            }
            while (treeBuiltIdx < geneEnd - 1) {
                treeBuiltIdx++;
                resetT0();
                tree.add(genes[treeBuiltIdx], 0, scores[treeBuiltIdx]);
                endAddTime();
            }
            for (int finishProcDna : finishProc) {
                long sc = calcScoreForStrand(tree, dnaStrands[finishProcDna]);
                synchronized (DNAHealth.this) {
                    dnaScores[finishProcDna] += sc;
                }
            }
            logTime("Thread for partition " + partition + " completed.");
        }

        long calcScoreForStrand(Node tree, String d) {
            resetT0();
            Node p = tree;
            long score = 0;
            for (int i = 0; i < d.length(); i++) {
                int c = d.charAt(i) - 'a';
                while (true) {
                    if (p.children != null) {
                        Node child = p.children[c];
                        if (child != null) {
                            p = child;
                            score += p.getTotalScore();
                            break;
                        }
                    }
                    if (p.postfix == null) {
                        // we are at root.
                        break;
                    }
                    p = p.postfix;
                }
            }
            endWalkTime();
            return score;
        }
    }

    void calcStrands() throws Exception {
        Arrays.sort(dnaTasks);
        logTime("DNATasks sorted.");
        int partitions =
            n > 50 * s ? 8 :
                    n > 5 * s ? 4 : 1;
        logTime("Partitions: " + partitions);
        if (partitions > n) partitions = n;
        ProcessingThread[] threads =
                new ProcessingThread[partitions];
        Set<Integer> dnasInProgress = new HashSet<>();
        int lastPartition = -1;
        for (int i = 0; i < dnaTasks.length; i++) {
            DNATask task = dnaTasks[i];
            int partition = (int) (
                    (task.gene - 1.0) * partitions / (n + 0.0) );
            if (partition != lastPartition) {
                if (lastPartition >= 0) {
                    ProcessingThread lastThread =
                            threads[lastPartition];
                    lastThread.finishProc =
                            dnasInProgress.toArray(new Integer[0]);
                    lastThread.dnaTaskEndIdx = i;
                    lastThread.geneEnd = task.gene;
                    lastThread.start();
                }
                lastPartition = partition;
            }

            ProcessingThread thread = threads[partition];
            if (thread == null) {
                threads[partition] = thread =
                        new ProcessingThread(partition, task.gene, i);
            }

            if (task.isStart) {
                dnasInProgress.add(task.dna);
            } else {
                dnasInProgress.remove(task.dna);
            }
        }
        if (lastPartition >= 0 && threads[lastPartition] != null) {
            ProcessingThread lastThread = threads[lastPartition];
            lastThread.finishProc = new Integer[0];
            lastThread.dnaTaskEndIdx = dnaTasks.length;
            lastThread.geneEnd = n;
            lastThread.start();
        }
        for (ProcessingThread thread : threads) {
            if (thread != null) thread.join();
        }
    }

    void printTree(int builtUpTo) {
        System.err.println("*** Tree built up to " + (builtUpTo - 1));
        System.err.println("digraph x {");
      
        System.err.println("}");
    }

    void run(String[] args) throws Exception {
        startTimer();
        readInitialData(args.length > 0 ? args[0] : null);
        logTime("Data read.");
        calcStrands();
        logTime("Calculated.");
        long minScore = Long.MAX_VALUE;
        long maxScore = Long.MIN_VALUE;
        for (int i = 0; i < s; i++) {
            long score = dnaScores[i];
            if (score > maxScore) {
                maxScore = score;
            }
            if (score < minScore) {
                minScore = score;
            }
        }
        logTime(String.format(
                "End. Add time (%d): %8.3fms, Walk time (%d): %8.3fms",
                addCount, addTime / 1000000.0,
                walkCount, walkTime / 1000000.0));
        System.out.println(minScore + " " + maxScore);
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        new DNAHealth().run(args);
    }
}
