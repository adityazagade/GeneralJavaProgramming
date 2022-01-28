import java.util.ArrayList;

class test {
    Nut matchedNut = null;

    public static void main(String args[]){
        ArrayList<Bolt> bolts = new ArrayList<>();
        bolts.add(new Bolt(1));
        bolts.add(new Bolt(2));
        bolts.add(new Bolt(3));
        bolts.add(new Bolt(4));
        bolts.add(new Bolt(5));

        ArrayList<Nut> nuts = new ArrayList<>();
        nuts.add(new Nut(1));
        nuts.add(new Nut(2));
        nuts.add(new Nut(3));
        nuts.add(new Nut(4));
        nuts.add(new Nut(5));

        new test().soWork(bolts, nuts);
    }

    void soWork(ArrayList<Bolt> bolts, ArrayList<Nut> nuts){
        if(bolts.isEmpty() || nuts.isEmpty()) {
            return;
        }
        Bolt b1 = bolts.get(0);
        ArrayList<Nut> smallerList = new ArrayList<>();
        ArrayList<Nut> biggerList = new ArrayList<>();
        nuts.forEach(nut -> {
            int comparison = isMatch(b1,nut);
            if( comparison == 0){
                matchedNut = nut;
                System.out.println(b1 + " " + nut);
            } else if(comparison > 1) {
                smallerList.add(nut);
            } else {
                biggerList.add(nut);
            }
        });

        ArrayList<Bolt> smallerBoltList = new ArrayList<>();
        ArrayList<Bolt> biggerBoltList = new ArrayList<>();

        bolts.forEach(bolt -> {
            int comparison = isMatch(bolt,matchedNut);
            if(comparison > 1) {
                biggerBoltList.add(bolt);
            } else {
                smallerBoltList.add(bolt);
            }
        });

        soWork(smallerBoltList, smallerList);
        soWork(biggerBoltList, biggerList);
    }

    int isMatch(Bolt b, Nut n){
        if(b.id < n.id) {
            return -1;
        } else if(b.id > n.id) {
            return 1;
        }
        else{
            return 0;
        }
    }
}


class Bolt{
    int id;

    Bolt(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Bolt: " + id;
    }
}

class Nut{
    int id;

    Nut(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Nut: " + id;
    }
}