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
        ArrayList<String> firsts;
	int f=0;
        String sortted="$ a b c d e f g h i j k l m n o p q r s t u v w x y z";
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
                        
                        String minians="";
                           resolvedvals.add(s);
                        resolvedanss.add(SortS(minians));
                        for (var a : fs){
                            var d=a.substring(0,1);
                            if(!d.equals(s)){
                                var ll=fristofvale(d,false);
                                minians=smartmerge(minians,ll);
                            }
                        }
                        sd=minians;
                     
                    }
                    var index=resolvedvals.indexOf(s);
                    
                    String ans=resolvedanss.get(index);
                    for (var a : fs){
                        var d=a.substring(0,1);
                        var sol=fristofvale(d,false);
                        if(sol.contains("e")||(d.equals(s) &&sd.contains("e"))  ){
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
        void prepare(){
                resolvedvals=new ArrayList<String>();
		resolvedanss=new ArrayList<String>();
		rightsidevariables=new ArrayList<String>();
		leftsideVariables=new ArrayList<String>();
                firsts=new ArrayList<String>();
                follows=new ArrayList<String>();
                
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
                for(var a :leftsideVariables){
                    follows.add("");
                }
        }
        ArrayList<String> follows;
	public String first() {
                prepare();
		String ans="";
		for(var r:leftsideVariables){
			ans+=r+"/"+ fristofvale(r,true)+";";
		}
                ans="";
                for(var r:leftsideVariables){
                        var x=fristofvale(r,true);
			ans+=r+"/"+ x+";";
                        firsts.add(x);
		}
		// TODO Auto-generated method stub
		return ans.substring(0, ans.length()-1);
	}
        public String followofvale(String s,boolean original,boolean First){
            if(check(s)){
                return s;
            }
            else{
                var ind=leftsideVariables.indexOf(s);
                if(!original){
                    return follows.get(ind);
                }
                else
                {
                    String ans="";
                    int ii=0;
                    for(var a :sides)
                    {
                        if(!a.contains(s)){
                            ii++;
                            continue;
                            
                        }
                        for (var h :a.split(",")){
                        var inx=h.indexOf(s);
                        if(!(inx<h.length()-1)){
                            ans=smartmerge(ans,followofvale(leftsideVariables.get(ii),false,false));
                        }
                        while(inx!=-1&& inx<h.length()-1){
                            String v="";
                            var next=h.substring(inx+1,inx+2);
                            v=fristofvale(next,false);
                            var i=inx+2;
                            while(v.contains("e")&& i<h.length()){
                                v=v.replace("e", "");
                                var x=fristofvale(h.substring(i,i+1),false);
                                v=smartmerge(v,x);
                                //  smartmerge;
                                i++;
                            }
                            v=v.replace("e", "");
                            ans=smartmerge(ans,v);
                            h=h.substring(inx+1);
                            inx=h.indexOf(s);
                            }
                        }
                        ii++;
                    }
                    
                    if(First){
                        ans="$"+ans;
                    }
                    ans=SortS(ans);
                    follows.set(ind, ans);
                    return ans;
                }
            }
       //     return "";
        }
	/**
	 * Calculates the Follow Set of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
                first();
                String ans="";int y=0;
		for(var r:leftsideVariables){
                        boolean z=false;
                        if(y==0){
                            z=true;
                        }
			ans+=r+"/"+ followofvale(r,true,z)+";";
                        y++;
		}
                ans=""; y=0;
		for(var r:leftsideVariables){
                        boolean z=false;
                        if(y==0){
                            z=true;
                        }
			ans+=r+"/"+ followofvale(r,true,z)+";";
                        y++;
		}
                
		// TODO Auto-generated method stub
		return ans.substring(0, ans.length()-1);
	}

}
