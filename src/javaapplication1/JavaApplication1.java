/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author tecyo
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ArrayList questionsfirst=new ArrayList();
        ArrayList solutionsfirst=new ArrayList();
        //1
        questionsfirst.add("S; T; L#a; b; c; d; i#S/ScT, T; T/aSb, iaLb, e; L/SdL,S");
        solutionsfirst.add("S/acei;T/aei;L/acdei");
        //2
        questionsfirst.add("S;Z;I;P;B;J;W#b;f;i;m;n;p;s#S/PZb,S,iBbB;Z/II,If,P;I/B,JZPP,SPnJS,SWsI,bBPb,iB;P/JWWfP,S,Ss,e;B/e,pBPBb,sSP;J/BmPZ,Z,iP;W/bZ,mPnWb,pWBfB");
        solutionsfirst.add("S/bfimps;Z/befimps;I/befimps;P/befimps;B/eps;J/befimps;W/bmp");
        //3
        questionsfirst.add("S;E;Q;N;C;F;Y#f;h;p;r;u;w#S/S,SE,SwFh,Y,rCr;E/CS,e,fCp;Q/NES,S,YCEwF,e;N/C,ChSuY,EhY,Q,QhEN,hN,rQCS;C/FNC,N,Q,SE,YrFp,pSSQ;F/FrCE,SEpC;Y/FpFYE,YFwE");
        solutionsfirst.add("S/r;E/efhpr;Q/efhpr;N/efhpr;C/efhpr;F/r;Y/r");
        //4
        questionsfirst.add("S;O;H;D;Z;X#a;k;p;s;t;w;x#S/SkSwO,pO,pZSt,tO;O/SOa,Z,e,sSp;H/OXt,XOD,ZOkOO,Zx,e,kZ;D/H,OaHk,S,SD,Z,ZkO,e,sDH;Z/O,Z,kXpO,x;X/HaZ,O,SXSH,SZ,pDaH,pDs");
        solutionsfirst.add("S/pt;O/ekpstx;H/aekpstx;D/aekpstx;Z/ekpstx;X/aekpstx");
        //5
        questionsfirst.add("S;K;D;I;M;L#a;d;g;x;y#S/L,S,SDxS;K/D,Ly,gMgSK;D/K,KdL,e,gIxLS;I/DgS,K,S,SaS,aDSI,aDSL,gSyL;M/D,DIaIM,IIdMS,e,x;L/SaDL,SgDL,xDaDg");
        solutionsfirst.add("S/x;K/degx;D/degx;I/adegx;M/adegx;L/x");
        //6
        questionsfirst.add("S;W;G;A;D;C;P#f;h;l;o;q;s;t#S/A,DPS,DqDDq,qAlS,qDPPo;W/e,lSD,tCShP;G/C,G,S,sDC,sS;A/fPlDf,o;D/PS,WAPs,e,oW,qD;C/G,PDP,PW,W;P/o,q");
        solutionsfirst.add("S/floqt;W/elt;G/efloqst;A/fo;D/efloqt;C/efloqst;P/oq");
        
        int score=0;
        for(int i=0;i<questionsfirst.size();i++){
            System.out.println("\r\nTest point : "+(i+1)+"\r\n");
            var r=readfirst((String)questionsfirst.get(i),(String)solutionsfirst.get(i));
            if(r){
                score++;
            }
        }
        System.out.println("\r\nScore : "+score+" / "+questionsfirst.size());
       
    }
    static boolean readfirst(String question,String solution){
        
        System.out.println("\r\n");
        CfgFirstFollow cfg= new CfgFirstFollow(question);
		String a= cfg.first();
        System.out.println(solution);
		System.out.println("\r\n\r\n");
        System.out.println(a);
		if(solution.equals(a)){
            System.out.println("\r\n** Matched ^_^ **\r\n");
            return true;
        }
        else{
            System.out.println("\r\n** Not Matched :( **\r\n");
            return false;
        }
    }
    
}
