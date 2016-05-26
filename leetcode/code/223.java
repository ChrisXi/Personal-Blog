public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int covered = 0;
        if(!(A >= G|| B >= H || C <= E || D <= F)){
             int x1 = Math.max(A, E);
            int y1 = Math.max(B, F);
            int x2 = Math.min(C, G);
            int y2 = Math.min(D, H);
            covered = (x2-x1)*(y2-y1);
        }
            
        return (C-A)*(D-B) + (G-E)*(H-F) - covered;
    }
}