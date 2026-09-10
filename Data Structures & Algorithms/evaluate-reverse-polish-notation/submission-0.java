class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq=new ArrayDeque<>();
        int a=0,b=0;
        for(int i=0;i<tokens.length;i++)
        {
            String token=tokens[i];

            switch(token)
            {
                case "+":
                 a=dq.pop();
                 b=dq.pop();
                dq.push(b+a);
                break;
                case "-":
                 a=dq.pop();
                 b=dq.pop();
                dq.push(b-a);
                break;
                case "*":
                 a=dq.pop();
                 b=dq.pop();
                dq.push(b*a);
                break;
                case "/":
                 a=dq.pop();
                 b=dq.pop();
                dq.push(b/a);
                break;
                default:
                                dq.push(Integer.parseInt(token));
break;

            }
        }
        return dq.pop();
        
    }
}
