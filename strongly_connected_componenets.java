import java.util.*;
public class Main
{
    int v;
    LinkedList<Integer>array[];
    public Main(int v)
    {
        this.v=v;
        array=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            array[i]=new LinkedList();
        }
    }
    void add_edge(int src,int dest)
    {
        array[src].add(dest);
    }
    Main transpose()
    {
        Main g=new Main(v);
        for(int i=0;i<v;i++)
        {
            for(Integer pro:array[i])
            {
                g.array[pro].add(i);
            }
        }
        return g;
    }
    void assignstack(int i,Boolean visited[],Stack stack)
    {
        visited[i]=true;
        Iterator<Integer>I=array[i].listIterator();
        while(I.hasNext())
        {
            int n=I.next();
            if(!visited[n])
            assignstack(n,visited,stack);
        }
        stack.push(i);
    }
    void dfsutils(Boolean visited[],int s)
    {
        visited[s]=true;
        System.out.print(s+" ");
        Iterator<Integer>I=array[s].listIterator();
        while(I.hasNext())
        {
            int n=I.next();
            if(!visited[n])
            {
                dfsutils(visited,n);
            }
        }
    }
    void dfs()
    {
        Boolean visited[]=new Boolean[v];
        for(int i=0;i<v;i++)
        visited[i]=false;
        Stack<Integer>stack=new Stack<Integer>();
        for(int i=0;i<v;i++)
        {
        if(!visited[i])
        assignstack(i,visited,stack);
        }
        Main gr=transpose();
        for(int i=0;i<v;i++)
        visited[i]=false;
        while(!stack.empty())
        {
            int v=stack.pop();
            if(!visited[v]){
            gr.dfsutils(visited,v);
            System.out.println();}
        }
    }
    public static void main(String[] args)
    {
        Main obj=new Main(5);
        obj.add_edge(1,0);
        obj.add_edge(0,2);
        obj.add_edge(2,1);
        obj.add_edge(0,3);
        obj.add_edge(3,4);
        obj.dfs();
    }
}


