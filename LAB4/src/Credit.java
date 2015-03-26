/*
 * Created by Prasanna on 3/24/2015.
 */
public class Credit {
    public double getCredit(int marks){
        if(marks >= 80)return 4.0;
        else if (marks >= 75 && marks < 80) return 3.7;
        else if (marks >= 70 && marks < 75) return 3.3;
        else if (marks >= 65 && marks < 70) return 3.0;
        else if (marks >= 60 && marks < 65) return 2.7;
        else if (marks >= 55 && marks < 60) return 2.3;
        else if (marks >= 50 && marks < 55) return 3.0;
        else if (marks >= 45 && marks < 50) return 1.7;
        else return 1.7;
    }
}
