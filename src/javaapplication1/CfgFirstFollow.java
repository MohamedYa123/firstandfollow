package javaapplication1;


import java.io.Console;
import java.util.ArrayList;

/**
 * Write your info here
 * 
 * @name Jane Smith
 * @id 46-0234
 * @labNumber 07
 */

public class CfgFirstFollow {

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */
	String order;
	public CfgFirstFollow(String cfg) {
		// TODO Auto-generated constructor stub
		order=cfg;
	}

	/**
	 * Calculates the First Set of each variable in the CFG.
	 * 
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	String[] items;
	ArrayList<String> leftsideVariables;
	String[] sides;
	ArrayList<String> rightsidevariables;
	ArrayList<String> resolvedvals;
	ArrayList<String> resolvedanss;
	int f=0;
        String sortted="a b c d e f g h i j k l m n o p q r s t u v w x y z";
        boolean check(String s){
            if(s.equals("e") || !leftsideVariables.contains(s)){
                   return true;
                }
            return false;
        }
        String smartmerge(String a,String b){
            String ans=b;
            for(int i=0;i<a.length();i++){
                var x=a.substring(i,i+1);
                if(!b.contains(x)){
                    ans+=x;
                }
            }
            return ans;
        }
        String SortS(String s){
            String ans="";
            for(int i=0;i<sortted.length();i++){
                var x=sortted.substring(i,i+1);
                if(s.contains(x)){
                    ans+=x;
                }
            }
            return ans;
        }
	private String fristofvale(String s,boolean original){
                if(s.equals("I")){
                   // System.out.println(" I ");
                }
                if(check(s)){
                    return s;
                }
                else if(resolvedvals.contains(s)&&!original)
                {
                    var ind=resolvedvals.indexOf(s);
                    //if(!original)
                   // { 
                        return resolvedanss.get(ind);
                   // }
                }
                else{
                    var ind=leftsideVariables.indexOf(s);
                    var formula=sides[ind];
                    var fs=formula.split(",");
                    String sd="";
                    if(!resolvedvals.contains(s))
                    {
                        resolvedvals.add(s);
                        String minians="";
                        
                        for (var a : fs){
                            var d=a.substring(0,1);
                            if(check(d)){
                                minians=smartmerge(minians,d);
                            }
                        }
                        sd=minians;
                        resolvedanss.add(SortS(minians));
                    }
                    var index=resolvedvals.indexOf(s);
                    
                    String ans=resolvedanss.get(index);
                    for (var a : fs){
                        var d=a.substring(0,1);
                        var sol=fristofvale(d,false);
                        if(sol.contains("e")||(d.equals(s) && sd.length()==0)){
                            int i=1;
                            while(true){
                                if(a.length()>i){
                                    sol=smartmerge(sol.replace("e",""),fristofvale(a.substring(i,i+1),false));
                                    i++;
                                }
                                else{
                                    break;
                                }
                                if(!sol.contains("e")){
                                    break;
                                }
                            }
                        }
                        ans=smartmerge(ans,sol);
                        
                        resolvedanss.set(index, ans);
                    }
                    ans=SortS(ans);
                     resolvedanss.set(index, ans);
                    return ans;
                }
		//return "";
	}
	public String first() {
		resolvedvals=new ArrayList<String>();
		resolvedanss=new ArrayList<String>();
		rightsidevariables=new ArrayList<String>();
		leftsideVariables=new ArrayList<String>();
		order=order.replace(" ", "");
		 items=order.split("#");
		 var al=items[0].split(";");
		 var ar=items[1].split(";");
		 for(var z:ar){
			rightsidevariables.add( z);
		 }
		 for(var z:al){
			leftsideVariables.add( z);
		 }
		 sides=items[2].split(";");
		for(int ind=0;ind<sides.length;ind++){
			String vb=leftsideVariables.get(ind);
			String sd=sides[ind];
			sides[ind]=sd.replace(vb+"/", "");
		}
		String ans="";
		for(var r:leftsideVariables){
			ans+=r+"/"+ fristofvale(r,true)+";";
		}

		// TODO Auto-generated method stub
		return ans.substring(0, ans.length()-1);
	}

	/**
	 * Calculates the Follow Set of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		// TODO Auto-generated method stub
		return null;
	}

}
