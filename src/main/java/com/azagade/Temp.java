package com.azagade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Temp {
    public static void main(String[] args) {
//        String t = "D E F G H I J K L M N O P Q R S T U V W X Y Z AA AB AC AD AE AF AG AH AI AJ AK AL AM AN AO AP AQ AR AS AT AU AV AW AX AY AZ BA BB BC BD BE BF BG BH BI BJ BK BL BM BN BO BP BQ BR BS BT BU BV BW BX BY BZ CA CB CC CD CE CF CG CH CI CJ CK CL CM CN CO CP CQ CR CS CT CU CV CW CX CY CZ DA DB DC DD DE DF DG DH DI DJ DK DL DM DN DO DP DQ DR DS DT DU DV DW DX DY DZ EA EB EC ED EE EF EG EH EI EJ EK EL EM EN EO EP EQ ER ES ET EU EV EW EX EY EZ FA FB FC FD FE FF FG FH FI FJ";
//        String[] tt = t.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < tt.length; i = i + 3) {
//            sb.append(tt[i] + "3+");
//        }
//        System.out.println(sb.toString());

////        String StockNames = "";
//        String t = "C D E F G H I J K L M N O P Q R S T U V W X Y Z AA AB AC AD AE AF AG AH AI AJ AK AL AM AN AO AP AQ AR AS AT AU AV AW AX AY AZ BA BB BC BD BE BF BG BH BI BJ BK BL BM BN BO BP BQ BR BS BT BU BV BW BX BY BZ CA CB CC CD CE CF CG CH CI CJ CK CL CM CN CO CP CQ CR CS CT CU CV CW CX CY CZ DA DB DC";
//        String[] tt = t.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < tt.length; i++) {
//            if (i % 2 == 0) {
//                //even
////                sb.append("=AVERAGE(" + tt[i] + "4:" + tt[i] + "254) ");
////                sb.append("=" + tt[i] + "4-$" + tt[i] + "$255 ");
//                sb.append("=STDEV(" + tt[i] + "4:" + tt[i] + "254) ");
//            } else {
////                sb.append(" ");
//            }
//        }
//        System.out.println(sb.toString());

//        String[] tt = temp.split("\n");
//        String stockNames = tt[0];
//        String[] stockArr = stockNames.split("\t");
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < stockArr.length; i++) {
//            if(stockArr[i].equals("DailyReturn")) {
//               sb.append(stockArr[i]);
//               sb.append("\t");
//               sb.append("Weight");
//                sb.append("\t");
//            } else {
//                sb.append(stockArr[i]);
//                sb.append("\t");
//            }
//        }
//        String header = sb.toString();
//        System.out.println(header);
//        String t = "B";
//        StringBuilder sb = new StringBuilder();
//        for (int i = 542; i <= 594; i++) {
//            sb.append(" ");
//            sb.append(" ");
//            sb.append("=Variance!$B$" + i);
//            sb.append(" ");
//        }
//        System.out.println(sb.toString());
//        String t = "131.3125\t\t\t52.85\t\t\t753\t\t\t547.85\t\t\t96.65\t\t\t378.75\t\t\t3162.4\t\t\t240.55\t\t\t324.6\t\t\t840.6\t\t\t458.25\t\t\t437.3\t\t\t343.15\t\t\t480.85\t\t\t337.9\t\t\t214.65\t\t\t120.4\t\t\t1763.6\t\t\t3103.55\t\t\t357\t\t\t568.25\t\t\t124.5\t\t\t713.25\t\t\t1132.8\t\t\t3626.05\t\t\t1273.35\t\t\t295.9\t\t\t143.15\t\t\t1426.65\t\t\t713\t\t\t250.7\t\t\t388.65\t\t\t1178.9\t\t\t180.2\t\t\t532.05\t\t\t142\t\t\t67.77\t\t\t59.3\t\t\t1437\t\t\t560.45\t\t\t554.65\t\t\t133.7\t\t\t150.25\t\t\t698.5\t\t\t344.65\t\t\t1547.65\t\t\t643.4\t\t\t123.35\t\t\t498.15\t\t\t167.4\t\t\t1148.2\t\t\t65.85\t\t\t307\t\t\n";
//        String t = "131.3125\t\t52.85\t\t753\t\t547.85\t\t96.65\t\t378.75\t\t3162.4\t\t240.55\t\t324.6\t\t840.6\t\t458.25\t\t437.3\t\t343.15\t\t480.85\t\t337.9\t\t214.65\t\t120.4\t\t1763.6\t\t3103.55\t\t357\t\t568.25\t\t124.5\t\t713.25\t\t1132.8\t\t3626.05\t\t1273.35\t\t295.9\t\t143.15\t\t1426.65\t\t713\t\t250.7\t\t388.65\t\t1178.9\t\t180.2\t\t532.05\t\t142\t\t67.77\t\t59.3\t\t1437\t\t560.45\t\t554.65\t\t133.7\t\t150.25\t\t698.5\t\t344.65\t\t1547.65\t\t643.4\t\t123.35\t\t498.15\t\t167.4\t\t1148.2\t\t65.85\t\t307\t\t";
//        String t = "131.3125\t\t\t52.85\t\t\t753\t\t\t547.85\t\t\t96.65\t\t\t378.75\t\t\t3162.4\t\t\t240.55\t\t\t324.6\t\t\t840.6\t\t\t458.25\t\t\t437.3\t\t\t343.15\t\t\t480.85\t\t\t337.9\t\t\t214.65\t\t\t120.4\t\t\t1763.6\t\t\t3103.55\t\t\t357\t\t\t568.25\t\t\t124.5\t\t\t713.25\t\t\t1132.8\t\t\t3626.05\t\t\t1273.35\t\t\t295.9\t\t\t143.15\t\t\t1426.65\t\t\t713\t\t\t250.7\t\t\t388.65\t\t\t1178.9\t\t\t180.2\t\t\t532.05\t\t\t142\t\t\t67.77\t\t\t59.3\t\t\t1437\t\t\t560.45\t\t\t554.65\t\t\t133.7\t\t\t150.25\t\t\t698.5\t\t\t344.65\t\t\t1547.65\t\t\t643.4\t\t\t123.35\t\t\t498.15\t\t\t167.4\t\t\t1148.2\t\t\t65.85\t\t\t307\t\t";
//        StringBuilder sb = new StringBuilder();
//        int j = 542;
//        String[] tt = t.split("\t");
//        for (int i = 0; i < tt.length; i++) {
//            if (i % 3 == 0 || i % 3 == 1) {
//                sb.append(tt[i]);
//                sb.append("\t");
//            } else if (i % 3 == 2) {
//                sb.append("=Variance!$B$" + j);
//                sb.append("\t");
//                j++;
//            }
//        }
//        System.out.println(sb.toString());
        String t = "C D E F G H I J K L M N O P Q R S T U V W X Y Z AA AB AC AD AE AF AG AH AI AJ AK AL AM AN AO AP AQ AR AS AT AU AV AW AX AY AZ BA BB BC BD BE BF BG BH BI BJ BK BL BM BN BO BP BQ BR BS BT BU BV BW BX BY BZ CA CB CC CD CE CF CG CH CI CJ CK CL CM CN CO CP CQ CR CS CT CU CV CW CX CY CZ DA DB DC DD DE DF DG DH DI DJ DK DL DM DN DO DP DQ DR DS DT DU DV DW DX DY DZ EA EB EC ED EE EF EG EH EI EJ EK EL EM EN EO EP EQ ER ES ET EU EV EW EX EY EZ FA FB FC FD FE";
        String[] tt = t.split(" ");
        StringBuilder sb = new StringBuilder();
//        sb.append("=SUM(");
//        for (int i = 0; i < tt.length; i = i + 3) {
//            sb.append(tt[i] + "2");
//            sb.append(",");
//        }
//        sb.append(")");

        for (int i = 0; i < tt.length; i=i+2) {
            sb.append("=Variance!" + tt[i] + "255");
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
